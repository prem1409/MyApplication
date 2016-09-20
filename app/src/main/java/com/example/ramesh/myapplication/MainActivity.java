package com.example.ramesh.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email,password;
    private TextView link;
    private ProgressDialog progressDialog;
private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        progressDialog = new ProgressDialog(this);
        email = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        link = (TextView) findViewById(R.id.textView);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Main4Activity.class));
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, Main3Activity.class));
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (TextUtils.isEmpty(emailid)) {
                    Toast.makeText(MainActivity.this, "Enter the email id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering User....");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(emailid, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "You are registered successfully", Toast.LENGTH_SHORT).show();

                            finish();
                            startActivity(new Intent(MainActivity.this, Main3Activity.class));


                        } else {
                            Toast.makeText(MainActivity.this, "You are not registered.Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
    }
   /* public void onClick(View v) {
        if(v==button)
        {
            registerUser();
        }
     /*   if(v==link)
        {

            finish();
            startActivity(new Intent(this,Main2Activity.class));


        }*/

    }


