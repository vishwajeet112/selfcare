package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yoga extends AppCompatActivity {
    public static final String EXTRAS="Physical1_5.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
    }

    public void siddhasana(View view) {
        Intent intent=new Intent(this,YogaStart.class);
        intent.putExtra(EXTRAS,"Siddhasana");
        startActivity(intent);
    }

    public void padmasana(View view) {
        Intent intent=new Intent(new Intent(this,YogaStart.class));
        intent.putExtra(EXTRAS,"Padmasana");


        startActivity(intent);

    }

    public void vajrasana(View view) {
        Intent intent=new Intent(new Intent(this,YogaStart.class));
        intent.putExtra(EXTRAS,"Vajrasana");
        startActivity(intent);

    }

    public void sukhasana(View view) {
        Intent intent=new Intent(new Intent(this,YogaStart.class));
        intent.putExtra(EXTRAS,"Sukhasana");
        startActivity(intent);

    }

    public void bhujangasana(View view) {
        Intent intent=new Intent(new Intent(this,YogaStart.class));
        intent.putExtra(EXTRAS,"Bhujangasana");
        startActivity(intent);

    }
}