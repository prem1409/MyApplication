package com.example.ramesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Map;

public class radar extends AppCompatActivity implements View.OnClickListener{
    private TextView logout1,user1;
    private FirebaseAuth firebaseAuth;
    private Firebase mRef;
    private RadarChart radarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);
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
                radarChart=(RadarChart) findViewById(R.id.ptext);
                ArrayList<Entry> barEntries=new ArrayList<>();
                barEntries.add(new Entry(Integer.parseInt(a),0));
                barEntries.add(new Entry(Integer.parseInt(b),1));
                barEntries.add(new Entry(Integer.parseInt(c),2));
                barEntries.add(new Entry(Integer.parseInt(d),3));
                barEntries.add(new Entry(Integer.parseInt(e),4));
                barEntries.add(new Entry(Integer.parseInt(f),5));
                barEntries.add(new Entry(Integer.parseInt(g),6));
                barEntries.add(new Entry(Integer.parseInt(h),7));
                barEntries.add(new Entry(Integer.parseInt(i),8));
                RadarDataSet dataSet=new RadarDataSet(barEntries,"Revenue");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
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

                RadarData barData=new RadarData(daa,dataSet);
                radarChart.setData(barData);

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
