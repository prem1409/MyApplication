package com.example.ramesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
private FirebaseAuth firebaseAuth;
   private TextView user,logout;
private Firebase mRootRef;
    private Spinner sp;
    private String s="";
private Button send,next;
    private EditText mget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mRootRef=new Firebase("https://fir-69df8.firebaseio.com/");
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        FirebaseUser us=firebaseAuth.getCurrentUser();
        user=(TextView)findViewById(R.id.rtextView3);
        user.setText(us.getEmail());
        logout=(TextView)findViewById(R.id.rtextView4);
        logout.setOnClickListener(this);

        sp=(Spinner)findViewById(R.id.rspinner);
        send=(Button)findViewById(R.id.rbutton3);
        mget=(EditText)findViewById(R.id.reditText);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        s=sp.getSelectedItem().toString();
                        switch (s)
                        {
                            case "Utar Pradesh":
                             String value=mget.getText().toString();
                                Firebase childref=mRootRef.child("Utar Pradesh");
                                try
                                {
                                    int v0=Integer.parseInt(value);
                                    childref.setValue(v0+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }

                                break;
                            case "Maharashtra":
                                String value1=mget.getText().toString();
                                Firebase childref1=mRootRef.child("Maharashtra");
                                try
                                {
                                    int v1=Integer.parseInt(value1);
                                    childref1.setValue(v1+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "Bihar":
                                String value2=mget.getText().toString();
                                Firebase childref2=mRootRef.child("Bihar");
                                try
                                {
                                    int v2=Integer.parseInt(value2);
                                    childref2.setValue(v2+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "West Bengal":
                                String value3=mget.getText().toString();
                                Firebase childref3=mRootRef.child("West Bengal");
                                try
                                {
                                    int v3=Integer.parseInt(value3);
                                    childref3.setValue(v3+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }

                                break;
                            case "Madhya Pradesh":
                                String value4=mget.getText().toString();
                                Firebase childref4=mRootRef.child("Madhya Pradesh");
                                try
                                {
                                    int v4=Integer.parseInt(value4);
                                    childref4.setValue(v4+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "Tamil Nadu":
                                String value5=mget.getText().toString();
                                Firebase childref5=mRootRef.child("Tamil Nadu");
                                try
                                {
                                    int v5=Integer.parseInt(value5);
                                    childref5.setValue(v5+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "Rajasthan":
                                String value6=mget.getText().toString();
                                Firebase childref6=mRootRef.child("Rajasthan");
                                try
                                {
                                    int v6=Integer.parseInt(value6);
                                    childref6.setValue(v6+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "Karnataka":
                                String value7=mget.getText().toString();
                                Firebase childref7=mRootRef.child("Karnataka");
                                try
                                {
                                    int v7=Integer.parseInt(value7);
                                    childref7.setValue(v7+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;
                            case "Gujrat":
                                String value8=mget.getText().toString();
                                Firebase childref8=mRootRef.child("Gujrat");
                                try
                                {
                                    int v8=Integer.parseInt(value8);
                                    childref8.setValue(v8+"");
                                }
                                catch(Exception e)
                                {
                                    Toast.makeText(Main3Activity.this, "Entered value isnt a number", Toast.LENGTH_SHORT).show();
                                    mget.setText("");
                                }
                                break;



                        }



            }
        });

next=(Button)findViewById(R.id.rbutton4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        next=(Button)findViewById(R.id.rbutton4);
        if(v==logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

    }
}
