package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dietchart extends AppCompatActivity {
    //    ProgressBar progressbar;
    ProgressBar progressbar3;
    ProgressBar progressbar5;
    ProgressBar progressbar6;
    TextView r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietchart);
        Intent intent = getIntent();
        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
//        Intent intent3=getIntent();
        int PROGRESSVALUE;
        int PROGRESSVALUE1;
        int PROGRESSVALUE2;
        int PROTEINS;
        r1 = findViewById(R.id.recommended);
        r2 = findViewById(R.id.recommended1);
        r3 = findViewById(R.id.recommended2);
        PROGRESSVALUE = intent.getIntExtra(breakfast.VALUE, 1);
//        PROTEINS = intent3.getIntExtra(breakfast.VALUE1, 1);
        PROGRESSVALUE1 = intent1.getIntExtra(lunch.EXTRAS, 1);
        PROGRESSVALUE2 = intent2.getIntExtra(dinner.PIE, 1);
//        Toast.makeText(this, ""+PROGRESSVALUE, Toast.LENGTH_SHORT).show();
        FirebaseDatabase.getInstance().getReference("Userdata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int height = Integer.parseInt(snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("StartingData").child("height").getValue(String.class));
                int weight = Integer.parseInt(snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("StartingData").child("weight").getValue(String.class));
                double heightm = (double) height / 100;
                double bmi = (weight) / (heightm * heightm);
                if (bmi > 25) {
                    r1.setText("200-300 kcal recommended");
                    r2.setText("400-500kcal recommended");
                    r3.setText("300-400kcal recommended");
                    progressbar3 = findViewById(R.id.progressbar3);
                    progressbar3 = findViewById(R.id.progressbar3);
                    progressbar3.setProgress(PROGRESSVALUE);
                    progressbar3.setMax(300);
                    progressbar5 = findViewById(R.id.progressbar5);
                    progressbar5.setProgress(PROGRESSVALUE1);
                    progressbar5.setMax(500);
                    progressbar6 = findViewById(R.id.progressbar6);
                    progressbar6.setProgress(PROGRESSVALUE2);
                    progressbar6.setMax(400);
                    // Toast.makeText(this, "Over weight "+bmi, Toast.LENGTH_SHORT).show();
                } else if (bmi > 18.5) {

                    r1.setText("350-400 kcal recommended");
                    r2.setText("500-700kcal recommended");
                    r3.setText("400-500kcal recommended");
                    // Toast.makeText(this, "Healthy "+bmi, Toast.LENGTH_SHORT).show();
                    progressbar3 = findViewById(R.id.progressbar3);
                    progressbar3.setProgress(PROGRESSVALUE);
                    progressbar3.setMax(400);
                    progressbar5 = findViewById(R.id.progressbar5);
                    progressbar5.setProgress(PROGRESSVALUE1);
                    progressbar5.setMax(600);
                    progressbar6 = findViewById(R.id.progressbar6);
                    progressbar6.setProgress(PROGRESSVALUE2);
                    progressbar6.setMax(500);
                } else {

                    r1.setText("500-600 kcal recommended");
                    r2.setText("700-800kcal recommended");
                    r3.setText("700-900kcal recommended");
                    // Toast.makeText(this, "Under Weight "+bmi , Toast.LENGTH_SHORT).show();
                    progressbar3 = findViewById(R.id.progressbar3);
                    progressbar3.setProgress(PROGRESSVALUE);
                    progressbar3.setMax(600);
                    progressbar5 = findViewById(R.id.progressbar5);
                    progressbar5.setProgress(PROGRESSVALUE1);
                    progressbar5.setMax(800);
                    progressbar6 = findViewById(R.id.progressbar6);
                    progressbar6.setProgress(PROGRESSVALUE2);
                    progressbar6.setMax(900);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        progressbar=findViewById(R.id.progressbar);
//        progressbar.setProgress(PROTEINS);
//        progressbar.setMax(50);


    }

    public void breakfast(View view) {
        Intent intent = new Intent(this, breakfast.class);
        startActivity(intent);
    }
}
