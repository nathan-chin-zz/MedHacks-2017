package com.example.android.medhacks2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nathan on 9/10/2017.
 */

public class editDrug2 extends AppCompatActivity {
    private String drug2name;
    private Button drug2update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdrug2);

        drug2update = (Button)findViewById(R.id.drug2update);
        drug2update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drug2name = ((EditText)findViewById(R.id.drug2name)).getText().toString();
                Intent next = new Intent(getApplicationContext(), com.example.android.medhacks2017.Menu.class);
                startActivity(next);
            }
        });
    }
}
