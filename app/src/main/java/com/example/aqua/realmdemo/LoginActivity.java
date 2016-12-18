package com.example.aqua.realmdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {
    EditText usernameet;
    EditText passwordet;
    Button loginbt;
    Button signupbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameet = (EditText) findViewById(R.id.usenameET);
        passwordet = (EditText) findViewById(R.id.passwordET);

        loginbt = (Button) findViewById(R.id.loginBT);
        signupbt = (Button) findViewById(R.id.signupBT);
        //login click
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredusername = usernameet.getText().toString();
                String enteredpassword = passwordet.getText().toString();
                Realm.init(LoginActivity.this);
                RealmResults<User> realmResults = DatabaseTask.getUserDetails(enteredusername);
                for (int i = 0; i < realmResults.size(); i++) {

                    User user = realmResults.get(i);
                    String stemail = user.getEmail();
                    String stpwd = user.getPassword();
                    String stname = user.getName();
                    if (enteredusername.equals(stname) && enteredpassword.equals(stpwd)) {
                       // Toast.makeText(LoginActivity.this, stname + " " + stemail + " " + stpwd, Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginActivity.this, "Login Successful\n welcome "+stname, Toast.LENGTH_LONG).show();

                    }else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        //signup click
        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupintent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signupintent);

            }
        });

    }
}
