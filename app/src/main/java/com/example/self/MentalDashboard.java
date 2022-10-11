package com.example.self;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MentalDashboard extends AppCompatActivity {
         private CardView c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_dashboard);
        c1=findViewById(R.id.focus);
        c2=findViewById(R.id.stress);
        c3=findViewById(R.id.relax);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MentalDashboard.this,yoga.class));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MentalDashboard.this,AfterStressManagement.class));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MentalDashboard.this,AfterRelaxingActivities.class));
            }
        });
    }
}