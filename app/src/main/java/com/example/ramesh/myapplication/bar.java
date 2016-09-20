package com.example.ramesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Map;

public class bar extends AppCompatActivity implements View.OnClickListener {
    private TextView logout1,user1;
    private FirebaseAuth firebaseAuth;
    private Firebase mRef;
    private BarChart barChart;
    private int values[]=new  int[1000];
    private String labels[]=new String[1000];
    int i=0;
    ArrayList<String> daa;
    ArrayList<BarEntry> barEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
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
                Map<String,String> map= dataSnapshot.getValue(Map.class);
                String a=map.get("Utar Pradesh");
                String b=map.get("Maharashtra");
                String c=map.get("Madhya Pradesh");
                String d=map.get("Bihar");
                String e=map.get("West Bengal");
                String f=map.get("Tamil Nadu");
                String g=map.get("Rajasthan");
                String h=map.get("Karnataka");
                String i=map.get("Gujrat");
                barChart=(BarChart)findViewById(R.id.bargraph);
                ArrayList<BarEntry> barEntries=new ArrayList<>();
                barEntries.add(new BarEntry(Integer.parseInt(a),0));
                barEntries.add(new BarEntry(Integer.parseInt(b),1));
                barEntries.add(new BarEntry(Integer.parseInt(c),2));
                barEntries.add(new BarEntry(Integer.parseInt(d),3));
                barEntries.add(new BarEntry(Integer.parseInt(e),4));
                barEntries.add(new BarEntry(Integer.parseInt(f),5));
                barEntries.add(new BarEntry(Integer.parseInt(g),6));
                barEntries.add(new BarEntry(Integer.parseInt(h),7));
                barEntries.add(new BarEntry(Integer.parseInt(i),8));
                BarDataSet dataSet=new BarDataSet(barEntries,"Revenue");
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

                BarData barData=new BarData(daa,dataSet);
                barChart.setData(barData);
                barChart.setDragEnabled(true);
                barChart.setScaleEnabled(true);
                barChart.setTouchEnabled(true);
                barChart.setDrawValueAboveBar(true);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        barChart=(BarChart)findViewById(R.id.bargraph);

           /*
            Map<String,String> map=dataSnapshot.getValue(Map.class);
                 up=map.get("Utar Pradesh");
                 m=map.get("Maharashtra");
                 mp=map.get("Madhya Pradesh");
                 b=map.get("Bihar");
                 wb=map.get("West Bengal");
                 tn=map.get("Tamil Nadu");
                 r=map.get("Rajasthan");
                 k=map.get("Karnataka");
                 g=map.get("Gujrat");
                Toast.makeText(bar.this, k, Toast.LENGTH_SHORT).show();
                Log.i("Hello",k);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/

/*        barChart=(BarChart)findViewById(R.id.bargraph);
        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(Integer.parseInt(up),0));
        barEntries.add(new BarEntry(Integer.parseInt(mp),1));
        barEntries.add(new BarEntry(Integer.parseInt(m),2));
        barEntries.add(new BarEntry(Integer.parseInt(k),3));
        barEntries.add(new BarEntry(Integer.parseInt(g),4));
        barEntries.add(new BarEntry(Integer.parseInt(r),5));
        barEntries.add(new BarEntry(Integer.parseInt(b),6));
        barEntries.add(new BarEntry(Integer.parseInt(tn),7));
        barEntries.add(new BarEntry(Integer.parseInt(wb),8));
        BarDataSet dataSet=new BarDataSet(barEntries,"Revenue");
        ArrayList<String> daa=new ArrayList<>();
        daa.add("Uttar Pradesh");
        daa.add("Madhya Pradesh");
        daa.add("Maharashtra");
        daa.add("Karnatak");
        daa.add("Gujrat");
        daa.add("Rajasthan");
        daa.add("Bihar");
        daa.add("Tamil Naidu");
        daa.add("West Bengal");
        BarData barData=new BarData(daa,dataSet);
        barChart.setData(barData);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setTouchEnabled(true);


  */  }

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
