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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txt_log,txt_sign_up_string;
    EditText txt_email,txt_password;
    SharedPrefrences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = SharedPrefrences.getsharedprefInstance(getApplicationContext());
        txt_sign_up_string=findViewById(R.id.signupstring);
        txt_email=findViewById(R.id.email);
        txt_password=findViewById(R.id.password);
        txt_log=findViewById(R.id.txt_login);
        txt_sign_up_string.setOnClickListener(this);
        txt_log.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signupstring:
                Intent intent1 = new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.txt_login:
                String email=txt_email.getText().toString().trim();
                String pass=txt_password.getText().toString().trim();
                String user_email= sharedPref.getemail();
                String user_pass= sharedPref.getpassword();
                if(!TextUtils.isEmpty(email)|| !TextUtils.isEmpty(pass))
                {
                    if(email.equals(user_email)&&pass.equals(user_pass))
                    {
                        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Profile.class);
                        startActivity(intent);
                    }
                    else if(!email.equals(user_email)|| ! pass.equals(user_pass))
                        Toast.makeText(getApplicationContext(),"email or password invalid",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter all field",Toast.LENGTH_SHORT).show();
                }

        }
    }
}
