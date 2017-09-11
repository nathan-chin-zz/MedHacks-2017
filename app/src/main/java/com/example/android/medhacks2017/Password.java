package com.example.android.medhacks2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nathan on 9/10/2017.
 */

public class Password extends AppCompatActivity {

    private String password;
    private String passwordRetype;
    private Button passwordNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        passwordNext = (Button)findViewById(R.id.passwordNext);

        passwordNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                password = ((EditText)findViewById(R.id.password)).getText().toString();
                passwordRetype = ((EditText)findViewById(R.id.passwordRetype)).getText().toString();

                final User same = (User) getIntent().getSerializableExtra("User");

                boolean check1 = false;
                boolean check2 = false;
                boolean check3 = false;
                for(int i = 0; i < password.length(); i++){
                    if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                        check1 = true;
                    }
                    else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                        check2 = true;
                    }
                    else if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                        check3 = true;
                    }
                }
                if(!check1 || !check2 || !check3){
                    Toast.makeText(getApplicationContext(), "Your password does not meet requirements", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "" + check1 + check2 + check3, Toast.LENGTH_SHORT).show();
                }
                else if(!(password.equals(passwordRetype))){
                    Toast.makeText(getApplicationContext(), "Your passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent toEnd = new Intent(getApplicationContext(), Confirmation.class);
                    toEnd.putExtra("User", same);
                    toEnd.putExtra("Password", password);
                    startActivity(toEnd);
                }
            }
        });



    }
}
