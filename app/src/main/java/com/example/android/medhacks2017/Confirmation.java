package com.example.android.medhacks2017;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.StartupAuthResult;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;


/**
 * Created by Nathan on 9/9/2017.
 */

public class Confirmation extends AppCompatActivity {
    private String confirmationCode;

    DynamoDBMapper dynamoDBMapper;
    private TextView mTextMessage;
    String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Context appContext = getApplicationContext();
        AWSConfiguration awsConfig = new AWSConfiguration(appContext);
        IdentityManager identityManager = new IdentityManager(appContext, awsConfig);
        IdentityManager.setDefaultIdentityManager(identityManager);
        identityManager.doStartupAuth(this, new StartupAuthResultHandler() {
            @Override
            public void onComplete(StartupAuthResult startupAuthResult) {
                // User identity is ready as unauthenticated
                // user or previously signed-in user.
            }
        });

        final AWSCredentialsProvider credentialsProvider = identityManager.getCredentialsProvider();
        userId = identityManager.getCachedUserID();
        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);
        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(awsConfig)
                .build();

        User same = (User) getIntent().getSerializableExtra("User");

        final UsersDO user = new UsersDO();

        same.setUniqueCode(user.getUserId());
        user.setUserId(this.userId);
        user.setFirstName(same.getFirstName());
        user.setLastName(same.getLastName());
        user.setPhoneNum(same.getPhoneNum());
        user.setEmail(same.getEmail());
        user.setDoctorFirst(same.getDoctorFirst());
        user.setDoctorLast(same.getDoctorLast());
        user.setDoctorPhone(same.getDoctorPhone());
        user.setDoctorEmail(same.getDoctorEmail());

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Show Progress:", "Start saving all data");
                dynamoDBMapper.save(user);
                Log.d("Show Progress:", "Saved all data");
            }
        }).start();



    }
}
