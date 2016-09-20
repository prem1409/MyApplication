package com.example.ramesh.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Map;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

public class line extends AppCompatActivity implements View.OnClickListener {
    private TextView logout1,user1;
    private FirebaseAuth firebaseAuth;
    private Firebase mRef;
    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        FirebaseUser us1=firebaseAuth.getCurrentUser();
        user1=(TextView)findViewById(R.id.ptextView3);
        user1.setText(us1.getEmail());
        logout1=(TextView)findViewById(R.id.ptextView4);
        logout1.setOnClickListener(this);
        mRef=new Firebase("https://fir-69df8.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Map<String,String> map=dataSnapshot.getValue(Map.class);
                String a=map.get("Utar Pradesh");
                String b=map.get("Maharashtra");
                String c=map.get("Madhya Pradesh");
                String d=map.get("Bihar");
                String e=map.get("West Bengal");
                String f=map.get("Tamil Nadu");
                String g=map.get("Rajasthan");
                String h=map.get("Karnataka");
                String i=map.get("Gujrat");
                lineChart=(LineChart) findViewById(R.id.line1);
                ArrayList<Entry> Entries=new ArrayList<>();
                Entries.add(new Entry(Integer.parseInt(a),0));
                Entries.add(new Entry(Integer.parseInt(b),1));
                Entries.add(new Entry(Integer.parseInt(c),2));
                Entries.add(new Entry(Integer.parseInt(d),3));
                Entries.add(new Entry(Integer.parseInt(e),4));
                Entries.add(new Entry(Integer.parseInt(f),5));
                Entries.add(new Entry(Integer.parseInt(g),6));
                Entries.add(new Entry(Integer.parseInt(h),7));
                Entries.add(new Entry(Integer.parseInt(i),8));
                LineDataSet dataSet=new LineDataSet(Entries,"Revenue");
                dataSet.setColors(COLORFUL_COLORS);
                ArrayList<String> daa=new ArrayList<>();
                daa.add("UP");
                daa.add("Mah");
                daa.add("MP");
                daa.add("Bi");
                daa.add("WB");
                daa.add("TN");
                daa.add("Raj");
                daa.add("Kar");
                daa.add("Guj");

                LineData Data=new LineData(daa,dataSet);
                Data.setValueTextColor(Color.WHITE);
                Data.setDrawValues(true);
                lineChart.setData(Data);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    @Override
    public void onClick(View v) {

        if(v==logout1)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }


    }
}
