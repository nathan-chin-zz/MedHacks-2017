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

public class LogIn extends AppCompatActivity {

    private String lastName;
    private String password;
    private Button login_next;


    DynamoDBMapper dynamoDBMapper;
    private TextView mTextMessage;
    String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_next = (Button)findViewById(R.id.login_next);


        Context appContext = getApplicationContext();
        AWSConfiguration awsConfig = new AWSConfiguration(appContext);
        final IdentityManager identityManager = new IdentityManager(appContext, awsConfig);
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
        final AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);
        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(awsConfig)
                .build();


        login_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String userId = "";
                final AWSCredentialsProvider credentialsProvider = identityManager.getCredentialsProvider();
                userId = identityManager.getCachedUserID();
                AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
                final DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
                Runnable runnable = new Runnable() {
                    public void run() {
                        //DynamoDB calls go here
                        UsersDO person = mapper.load(UsersDO.class, password);
                        Toast.makeText(getApplicationContext(), person.getDoctorEmail() + "", Toast.LENGTH_SHORT).show();
                    }
                };
                Thread mythread = new Thread(runnable);
                mythread.start();*/
                User same = (User) getIntent().getSerializableExtra("User");
                String oldPassword = getIntent().getStringExtra("Password");
                lastName = ((EditText)findViewById(R.id.login_lastname)).getText().toString();
                password = ((EditText)findViewById(R.id.login_password)).getText().toString();
                if(lastName.equals(same.getLastName()) && password.equals(oldPassword)){
                    Intent next = new Intent(getApplicationContext(), com.example.android.medhacks2017.Menu.class);
                    next.putExtra("User", same);
                    startActivity(next);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Account not found", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
