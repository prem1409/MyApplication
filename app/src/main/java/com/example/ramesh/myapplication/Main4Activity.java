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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{
private Button log;
    private EditText email1,password1;
    private TextView link1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        email1=(EditText)findViewById(R.id.logeditText1);
        password1=(EditText)findViewById(R.id.logeditText2);
        progressDialog =new ProgressDialog(this);
        log=(Button)findViewById(R.id.logbutton);
        link1=(TextView)findViewById(R.id.logtextView);
        log.setOnClickListener(this);
        link1.setOnClickListener(this);
        firebase=FirebaseAuth.getInstance();
        if(firebase.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(this,Main3Activity.class));
        }
    }
    public void loginUser()
    {
        email1=(EditText)findViewById(R.id.logeditText1);
        password1=(EditText)findViewById(R.id.logeditText2);

        String e=email1.getText().toString().trim();
        String p=password1.getText().toString().trim();
        if(TextUtils.isEmpty(e))
        {
            Toast.makeText(Main4Activity.this, "Enter the email id", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(p))
        {
            Toast.makeText(Main4Activity.this, "Enter the password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging In....");
        progressDialog.show();
        firebase.signInWithEmailAndPassword(e,p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    finish();
                    Toast.makeText(Main4Activity.this, "You are Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main4Activity.this,Main3Activity.class));
                }
                else
                {
                    startActivity(new Intent(Main4Activity.this,MainActivity.class));
                    Toast.makeText(Main4Activity.this, "Something went wrong please try again", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        if(v==log)
        {
            loginUser();
        }
        if(v==link1)
        { finish();
            startActivity(new Intent(this,MainActivity.class));

        }
    }
}
