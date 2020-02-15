package com.example.ambulance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
    }

    public void register(View v) {
        Intent intent = new Intent(firstpage.this, Register.class);
        startActivity(intent);
        finish();
    }

    public void login(View v) {
        Intent intent = new Intent(firstpage.this, Login.class);
        startActivity(intent);
        finish();
    }
}