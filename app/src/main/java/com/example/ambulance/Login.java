package com.example.ambulance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void signinUser(View v)
    {
        Intent intent = new Intent(Login.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    public void signinDriver(View v)
    {
        Intent intent = new Intent(Login.this, SignInActivity2.class);
        startActivity(intent);
        finish();
    }
}
