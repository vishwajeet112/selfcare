package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Circular extends AppCompatActivity {
    PieChart pieChart;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        pieChart=findViewById(R.id.pieChart);
        databaseReference=FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int m=0,f=0,o=0;
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    if(dataSnapshot.child("role").getValue(String.class).equalsIgnoreCase("Guardian")||dataSnapshot.child("role").getValue(String.class).equalsIgnoreCase("Councellor")){}
                    else{
                        String gender=   dataSnapshot.child("gender").getValue(String.class);
                        if(gender.equalsIgnoreCase("Male")){m++;}
                        else if(gender.equalsIgnoreCase("Female")){f++;}
                        else if(gender.equalsIgnoreCase("Other")){o++;}
                    } }
                ArrayList<PieEntry> pieEntries=new ArrayList<>();
                pieEntries.add(new PieEntry(m,"Male"));
                pieEntries.add(new PieEntry(f,"Female"));
                pieEntries.add(new PieEntry(o,"Others"));
                databaseReference= FirebaseDatabase.getInstance().getReference("User Data");
                PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                pieDataSet.setValueTextSize(20f);
                pieChart.setData(new PieData(pieDataSet));
                pieChart.animateXY(1000,1000);
                pieChart.getDescription().setEnabled(false);
                pieChart.setCenterText("Your Report");
                pieChart.setCenterTextSize(20f);
              //  Intent intent=new Intent(Director.this,Circular.class)

                Toast.makeText(Circular.this, ""+m+f+o, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}