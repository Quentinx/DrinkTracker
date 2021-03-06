/*
This is the first part of the signup Window.
Basically we're just collecting the User's address, weight, and gender.
If the address or weight have invalid inputs then we need to tell the user those inputs are invalid
Upon successful validation we send those string variables to the actual Signup class in a bundle
The Signup class can read those with the default bundle
 */

package edu.usf.drinktracker.drinktracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class InfoSignup extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    EditText address, weight;
    RadioButton male, female;
    Button continueBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_signup);

        address = (EditText) findViewById(R.id.address_text);
        weight = (EditText) findViewById(R.id.weight_text);
        male = (RadioButton) findViewById(R.id.male_text);
        female = (RadioButton) findViewById(R.id.female_text);
        continueBttn = (Button) findViewById(R.id.button_continue);
        male.setChecked(true);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        male.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                female.setChecked(false);
            }
        });

        female.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                male.setChecked(false);
            }
        });
    }

    public void Continue(View v){
        Intent i = new Intent(InfoSignup.this, Signup.class);
        i.putExtra("address", address.getText().toString());
        i.putExtra("weight", weight.getText().toString());
        if(male.isChecked()) {
            i.putExtra("isMaleChecked", "True");
        }
        else {
            i.putExtra("isMaleChecked", "False");
        }
        startActivity(i);
    }
}
