package com.example.android.medhacks2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class Confirmation extends AppCompatActivity{
    private String confirmationCode;
    private Button done;

    DynamoDBMapper dynamoDBMapper;
    private TextView mTextMessage;
    String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        done = (Button)findViewById(R.id.confirmDone);

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

        final User same = (User) getIntent().getSerializableExtra("User");
        //final String password = getIntent().getStringExtra("Password");
        final UsersDO user = new UsersDO();
        /*String hashPass = "";

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            hashPass = new String(digest);
        } catch(Exception e){

        }*/

        //same.setUniqueCode(user.getUserId());
        user.setUserId(this.userId);
        user.setFirstName(same.getFirstName());
        user.setLastName(same.getLastName());
        user.setPhoneNum(same.getPhoneNum());
        user.setEmail(same.getEmail());
        user.setDoctorFirst(same.getDoctorFirst());
        user.setDoctorLast(same.getDoctorLast());
        user.setDoctorPhone(same.getDoctorPhone());
        user.setDoctorEmail(same.getDoctorEmail());
        final String password = getIntent().getStringExtra("Password");
        user.setPassword(password);
        final User same2 = same;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Log.d("Show Progress:", "Start saving user data");
                dynamoDBMapper.save(user);
                //Log.d("Show Progress:", "Saved user data");
            }
        }).start();

        Toast.makeText(getApplicationContext(), same.getUniqueCode(),Toast.LENGTH_LONG).show();

        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                confirmationCode = ((EditText)findViewById(R.id.confirmationCode)).getText().toString();
                if(confirmationCode.equals(same.getUniqueCode())){
                    Intent reset = new Intent(getApplicationContext(), com.example.android.medhacks2017.MainActivity.class);
                    reset.putExtra("User", same2);
                    reset.putExtra("Password", password);
                    startActivity(reset);
                    Toast.makeText(getApplicationContext(),"Account made!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong code, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
