package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView username,email,mob,pass;
    SharedPrefrences sharedPrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPrefrences=SharedPrefrences.getsharedprefInstance(getApplicationContext());
        username=findViewById(R.id.username);
        email=findViewById(R.id.email_id);
        mob=findViewById(R.id.Phone);
        pass=findViewById(R.id.Pass);
            username.setText(sharedPrefrences.getusername());
            email.setText(sharedPrefrences.getemail());
            pass.setText(sharedPrefrences.getpassword());
            mob.setText(sharedPrefrences.getmob());


    }
}