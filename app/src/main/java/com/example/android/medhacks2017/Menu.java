package com.example.android.medhacks2017;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nathan on 9/10/2017.
 */

public class Menu extends AppCompatActivity {
    private Button drug1;
    private Button drug2;
    public boolean drug1seen = false;
    public boolean drug2seen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        drug1 = (Button)findViewById(R.id.drug1);
        drug2 = (Button)findViewById(R.id.drug2);


        if (drug1.getText().toString().equals("Drug 1")) {
            drug1.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            //drug1seen = true;
            drug1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editDrug1 = new Intent(getApplicationContext(), com.example.android.medhacks2017.editDrug1.class);
                    startActivity(editDrug1);
                }
            });
        } else {
            drug1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent seeDrug1 = new Intent(getApplicationContext(), editDrug1.class);
                    startActivity(seeDrug1);
                }
            });
        }
        if (!drug2seen) {
            drug2.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            //drug2seen = true;
            drug2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editDrug2 = new Intent(getApplicationContext(), com.example.android.medhacks2017.editDrug2.class);
                    startActivity(editDrug2);
                }
            });
        } else {
            drug1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewDrug2 = new Intent(getApplicationContext(), com.example.android.medhacks2017.ViewDrug2.class);
                    startActivity(viewDrug2);
                }
            });
        }
    }

}
