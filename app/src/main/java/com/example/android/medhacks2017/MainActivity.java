package com.example.android.medhacks2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.StartupAuthResult;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;


public class MainActivity extends AppCompatActivity {
    /*
       This will describe the start/home screen of the app
       One button for the first drug (red until taken for the day, then the button is green until the start of the next day)
       Another button below it for the second drug (same as above)
       -For new users, will have to create an account (name, phone number or email, doctor's name, doctor contact)
       -On initialization, will ask to input prescription name and quantity
       -Clicking on one button will take you to a calendar screen, with days highlighted green or red (based on taking medicine)
        -Streak counter listed on the bottom
     */
    private Button logIn;
    private TextView createAccount;
    private int loops = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loops++;

        logIn = (Button)findViewById(R.id.logIn);
        createAccount = (TextView)findViewById(R.id.createAccount);


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

        logIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(loops == 0){
                    Intent fresh = new Intent(getApplicationContext(), com.example.android.medhacks2017.LogIn.class);
                    startActivity(fresh);
                }
                User same = (User) getIntent().getSerializableExtra("User");
                String password = getIntent().getStringExtra("Password");
                Intent fresh = new Intent(getApplicationContext(), com.example.android.medhacks2017.LogIn.class);
                fresh.putExtra("User", same);
                fresh.putExtra("Password", password);
                startActivity(fresh);
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), com.example.android.medhacks2017.CreateAccount.class));
            }
        });

    }
}
