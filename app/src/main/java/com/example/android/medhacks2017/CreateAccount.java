package com.example.android.medhacks2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nathan on 9/9/2017.
 */

public class CreateAccount extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phoneNum;
    private EditText email;
    private Button createAccount_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        phoneNum = (EditText)findViewById(R.id.phoneNumber);
        email = (EditText)findViewById(R.id.email);
        createAccount_next1 = (Button)findViewById(R.id.createAccount_next1);

        createAccount_next1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String firstName = ((EditText) findViewById(R.id.firstName)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.lastName)).getText().toString();
                String phoneNum = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
                String email = ((EditText) findViewById(R.id.email)).getText().toString();

                if(firstName.length() == 0 && lastName.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter your name to continue", Toast.LENGTH_SHORT).show();
                }
                else if(firstName.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter your first name", Toast.LENGTH_SHORT).show();
                }
                else if(lastName.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter your last name", Toast.LENGTH_SHORT).show();
                }
                else if(phoneNum.length() != 10 && phoneNum.length() != 0){
                    Toast.makeText(getApplicationContext(), "The input phone number is not valid", Toast.LENGTH_SHORT).show();
                }
                else if(email.indexOf('@') < 0 && email.length() != 0){
                    Toast.makeText(getApplicationContext(), "The input email is not valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    User newUser = new User(firstName, lastName, phoneNum, email);
                    Intent nextIntent = new Intent(getApplicationContext(), CreateAccount2.class);
                    nextIntent.putExtra("User", newUser);
                    startActivity(nextIntent);
                }
            }
        });

    }
}
