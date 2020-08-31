package com.example.lenovo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity implements View.OnClickListener {
     TextView txt_signup,txt_signinsring;
     EditText txt_name,txt_mob_number,txt_email,txt_pass;
      SharedPrefrences sharedPrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        sharedPrefrences=SharedPrefrences.getsharedprefInstance(getApplicationContext());

        txt_signinsring=findViewById(R.id.signinstring);
        txt_name=findViewById(R.id.Name);
        txt_email=findViewById(R.id.email);
        txt_mob_number=findViewById(R.id.Mob_number);
        txt_pass=findViewById(R.id.password);
        txt_signup=findViewById(R.id.txt_Signup);
        txt_signinsring.setOnClickListener(this);
        txt_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signinstring:
                Intent intent = new Intent(RegistrationPage.this, MainActivity.class);
                startActivity(intent);
                 finish();
                 break;
            case R.id.txt_Signup:
                String name=txt_name.getText().toString().trim();
                String email=txt_email.getText().toString().trim();
                String mob=txt_mob_number.getText().toString().trim();
                String pass=txt_pass.getText().toString().trim();

                if(TextUtils.isEmpty(name)|| TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
                {
                    Toast.makeText(getApplicationContext(),"Please enter all field",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (sharedPrefrences.getcheckStatus() == false) {
                            sharedPrefrences.setusername(name);
                            sharedPrefrences.setemail(email);
                            sharedPrefrences.setpassword(pass);
                            sharedPrefrences.setPhonenumber(mob);
                            finish();
                            Toast.makeText(getApplicationContext(), "Registration successfully done", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(getApplicationContext(), Profile.class);
                            startActivity(intent1);
                        }
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
                }


        }
    }

}