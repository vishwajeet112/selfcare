package com.example.self;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;

public class Insidephysical extends AppCompatActivity {


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insidephysical);

    }
    public void inside(View view){
        Intent intent=new Intent(this,workouts.class);
        startActivity(intent);
    }
    public void diet(View view){
        Intent intent=new Intent(this,Dietchart.class);
        startActivity(intent);
    }
    public void yoga(View view){
        Intent intent=new Intent(this,yoga.class);
        startActivity(intent);
    }
    public void personal(View view){
        Intent intent=new Intent(this,personalhygiene.class);
        startActivity(intent);
    }
}