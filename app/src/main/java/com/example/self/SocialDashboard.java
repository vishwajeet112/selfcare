package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SocialDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_dashboard);
    }

    public void selfDilemma(View view) {
        startActivity(new Intent(this,AfterSelfDilemma.class));
    }

    public void interactivity(View view) {
        startActivity(new Intent(this,AfterInteractivity.class));
    }

    public void family(View view) {
        startActivity(new Intent(this,AfterFamily.class));
    }

    public void friends(View view) {
        startActivity(new Intent(this,AfterFriends.class));
    }
}