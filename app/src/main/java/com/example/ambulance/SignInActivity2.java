package com.example.ambulance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity2 extends AppCompatActivity
{

    EditText e1,e2;
    FirebaseAuth auth;
    ProgressDialog dialog;
    DatabaseReference databaseReference;
   // FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);

        e1=findViewById(R.id.email_in);
        e2=findViewById(R.id.password_in);
        auth=FirebaseAuth.getInstance();
        dialog = new  ProgressDialog(this);
    }

    public void signinDriver(View V)
    {
        dialog.setMessage("Signing in... Please wait");
        dialog.show();
        if(e1.getText().toString().equals("")&& e2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Field cannot be empty!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            auth.signInWithEmailAndPassword(e1.getText().toString(), e2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {

                        dialog.hide();
                        databaseReference = FirebaseDatabase.getInstance().getReference().child("Drivers");
                        //Drivers drivers_object = new Drivers(e4.getText().toString(), e5.getText().toString(), e6.getText().toString(), e7.getText().toString(),"online");
                        FirebaseUser firebaseUser = auth.getCurrentUser();
                        databaseReference.child(firebaseUser.getUid()).child("status").setValue("online");
                        Toast.makeText(getApplicationContext(),"Driver Successfully sign in!",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(SignInActivity2.this,MainPageActivity2.class);
                        startActivity(i);

                    }
                    else
                    {
                        dialog.hide();
                        Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void register(View v)
    {
        Intent intent = new Intent(SignInActivity2.this, Register.class);
        startActivity(intent);
        finish();
    }

    public void login(View v)
    {
        Intent intent = new Intent(SignInActivity2.this, Login.class);
        startActivity(intent);
        finish();
    }



}
