package com.example.android.medhacks2017;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nathan on 9/9/2017.
 */

public class CreateAccount2 extends AppCompatActivity {
    private EditText doctorFirst;
    private EditText doctorLast;
    private EditText doctorPhone;
    private EditText doctorEmail;
    private Button createAccount_next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_2);

        doctorFirst = (EditText)findViewById(R.id.doctorFirst);
        doctorLast = (EditText)findViewById(R.id.doctorLast);
        doctorPhone = (EditText)findViewById(R.id.doctorPhone);
        doctorEmail = (EditText)findViewById(R.id.doctorEmail);
        createAccount_next2 = (Button)findViewById(R.id.createAccount_next2);

        createAccount_next2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final String doctorFirst = ((EditText) findViewById(R.id.doctorFirst)).getText().toString();
                final String doctorLast = ((EditText) findViewById(R.id.doctorLast)).getText().toString();
                final String doctorPhone = ((EditText) findViewById(R.id.doctorPhone)).getText().toString();
                final String doctorEmail = ((EditText) findViewById(R.id.doctorEmail)).getText().toString();

                if(doctorFirst.length() == 0 && doctorLast.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter the doctor's name to continue", Toast.LENGTH_SHORT).show();
                }
                else if(doctorFirst.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter the doctor's first name", Toast.LENGTH_SHORT).show();
                }
                else if(doctorLast.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter the doctor's last name", Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder message = new AlertDialog.Builder(CreateAccount2.this);
                    message.setMessage("Make sure you filled out AT LEAST ONE form of contact for your doctor. This allows for " +
                            "the doctor to be messaged when your medication is running low or in other emergencies")
                            .setCancelable(false)
                            .setPositiveButton("Got it", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (doctorPhone.length() == 0 && doctorEmail.length() == 0) {
                                        Toast.makeText(getApplicationContext(), "Please listen to the warning", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                    else if(doctorPhone.length() != 10 && doctorPhone.length() != 0){
                                        Toast.makeText(getApplicationContext(), "The input phone number is not valid", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                    else if(doctorEmail.indexOf('@') < 0 && doctorEmail.length() != 0){
                                        Toast.makeText(getApplicationContext(), "The input email is not valid", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                    else {
                                        User same = (User) getIntent().getSerializableExtra("User");
                                        same.updateUser(doctorFirst, doctorLast, doctorPhone, doctorEmail);
                                        /*if(same.getPhoneNum() != null){
                                            Intent textMessage = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + same.getPhoneNum()));
                                            textMessage.putExtra("sms_body", "Your confirmation code is " + same.getUniqueCode());
                                            try {
                                                startActivity(textMessage);
                                            } catch(android.content.ActivityNotFoundException ex){
                                                Toast.makeText(getApplicationContext(), "No text messaging available. Please enter an email", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        else{
                                            Intent emailMessage = new Intent(Intent.ACTION_SEND);
                                            emailMessage.setType("message/rfc822");
                                            emailMessage.putExtra(Intent.EXTRA_EMAIL, new String[]{same.getEmail()});
                                            emailMessage.putExtra(Intent.EXTRA_SUBJECT, "Welcome to ____");
                                            emailMessage.putExtra(Intent.EXTRA_TEXT, "Your confirmation code is " + same.getUniqueCode());
                                            try{
                                                startActivity(Intent.createChooser(emailMessage, "Email sent"));
                                            } catch(android.content.ActivityNotFoundException ex){
                                                Toast.makeText(getApplicationContext(), "No email client found. Please enter a phone number", Toast.LENGTH_SHORT).show();
                                            }
                                        }*/
                                        Intent updated = new Intent(getApplicationContext(), Password.class);
                                        updated.putExtra("User", same);
                                        startActivity(updated);
                                    }
                                }
                            })
                            .setNegativeButton("Hold on", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = message.create();
                    alert.setTitle("WARNING");
                    alert.show();
                }
            }
        });

    }
}
