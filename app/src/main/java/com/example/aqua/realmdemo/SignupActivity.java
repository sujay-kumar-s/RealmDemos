package com.example.aqua.realmdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class SignupActivity extends AppCompatActivity {
    EditText usernameet;
    EditText emailet;
    EditText passwordet;
    Button cancelbt;
    Button signupbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        usernameet = (EditText) findViewById(R.id.suusernameET);
        emailet = (EditText) findViewById(R.id.suemailET);
        passwordet = (EditText) findViewById(R.id.supasswordET);

        cancelbt = (Button) findViewById(R.id.cancelbt);
        signupbt = (Button) findViewById(R.id.signupbt);

        cancelbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //save data
        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //set data to user object
                String name = usernameet.getText().toString();
                String password = passwordet.getText().toString();
                String email=emailet.getText().toString();


                Realm.init(SignupActivity.this);
                Boolean add=DatabaseTask.addUser(SignupActivity.this,name,email,password);
                if(add==true) {
                   /* Log.d("insert","success insert");*/
                    Toast.makeText(SignupActivity.this, "data saved success", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Log.d("insert","failure");
                    Toast.makeText(SignupActivity.this, "Invalid Data", Toast.LENGTH_LONG).show();

                }


            }
        });
    }


}
