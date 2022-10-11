package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AfterRelaxingActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_relaxing_activities);
    }
    public void onNext(View view) {
        startActivity(new Intent(this,RealxingActivitiesQAJR.class));
    }
}