package com.example.android.medhacks2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = (Button)findViewById(R.id.logIn);
        createAccount = (TextView)findViewById(R.id.createAccount);

        logIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), com.example.android.medhacks2017.LogIn.class));
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
