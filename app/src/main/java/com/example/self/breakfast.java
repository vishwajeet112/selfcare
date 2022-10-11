package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.self.databinding.ActivityDietchartBinding;

public class breakfast extends AppCompatActivity {
    int cal = 0;
    int proteins=0;
    int carb=0;
    int fat=0;
    public static final String VALUE = "breakfast.name";
    public static final String VALUE1 = "breakfast.name";
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox13, checkBox12,checkBox14;
    Button button;
    ImageView imageView33;
    ImageView imageView34;
    ImageView aj;
    ImageView imageView35;
    ImageView imageView36;
    ImageView imageView37;
    ImageView imageView38;
    ImageView imageView39;
    ImageView imageView40;
    ImageView imageView41;
    ImageView imageView42;
    ImageView imageView45;
    ImageView imageView46;
    ImageView imageView48;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);
        checkBox7=findViewById(R.id.checkBox7);
        checkBox8=findViewById(R.id.checkBox8);
        checkBox9=findViewById(R.id.checkBox9);
        checkBox10=findViewById(R.id.checkBox10);
        checkBox11=findViewById(R.id.checkBox11);
        checkBox12=findViewById(R.id.checkbox12);
        checkBox13=findViewById(R.id.checkBox13);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView33);
        imageView.setImageResource(R.drawable.tea);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkbox12);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox14 = findViewById(R.id.checkBox14);
        button = findViewById(R.id.button);

//        imageView33=findViewById(R.id.imageView33);
//        imageView33.setImageResource(R.drawable.ajwainwater);
//
//        imageView34=findViewById(R.id.imageView34);
//        imageView34.setImageResource(R.drawable.oats);
//
//        aj=findViewById(R.id.aj);
//        aj.setImageResource(R.drawable.ajwainwater);
//
//        imageView35=findViewById(R.id.imageView35);
//        imageView35.setImageResource(R.drawable.rawahalwa);
//
//        imageView36=findViewById(R.id.imageView36);
//        imageView36.setImageResource(R.drawable.lauki);
//
//        imageView37=findViewById(R.id.imageView37);
//        imageView37.setImageResource(R.drawable.curd);
//
//        imageView38=findViewById(R.id.imageView38);
//        imageView38.setImageResource(R.drawable.pavbhaji);
//
//        imageView39=findViewById(R.id.imageView39);
//        imageView39.setImageResource(R.drawable.upma);
//
//        imageView40=findViewById(R.id.imageView40);
//        imageView40.setImageResource(R.drawable.orangejuice);
//
//        imageView41=findViewById(R.id.imageView41);
//        imageView41.setImageResource(R.drawable.watermelon);
//
//        imageView42=findViewById(R.id.imageView42);
//        imageView42.setImageResource(R.drawable.poha);
//
//        imageView45=findViewById(R.id.imageView45);
//        imageView45.setImageResource(R.drawable.boiledwhite);
//
//        imageView46=findViewById(R.id.imageView46);
//        imageView46.setImageResource(R.drawable.boiled);
//
//        imageView48=findViewById(R.id.imageView48);
//        imageView48.setImageResource(R.drawable.eggbhurji);
        if(cal>400){
            Toast.makeText(this, "You are overeating", Toast.LENGTH_SHORT).show();
        }
    }
    public void on(View view) {
        Intent intent = new Intent(breakfast.this, ActivityDietchartBinding.class);
        if (cal > 400) {
            Toast.makeText(breakfast.this, "You are overeating!!", Toast.LENGTH_SHORT).show();
        }
        intent.putExtra(VALUE,cal);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void checkBox1(View view) {
        if (checkBox1.isChecked()) {
            cal += 103;
            proteins+=2.7;
            carb+=16.9;
            fat+=2.5;
        }
        else
            cal -= 103;
    }
    public void checkBox2(View view) {
        if (checkBox2.isChecked()) {
            cal += 99;
            proteins += 2.8;
            carb += 12.3;
            fat += 4.3;
        }
        else
            cal -= 99;
    }
    public void checkBox3(View view) {
        if (checkBox3.isChecked()) {
            cal += 2;
            proteins += 0.1;
            carb += 0.1;
            fat += 0.1;
        }
        else
            cal-=2;

    }
    public void checkBox4(View view) {
        if (checkBox4.isChecked()) {
            cal += 195;
            proteins += 2.8;
            carb += 32.5;
            fat += 6.3;
        }
        else
            cal -= 195;
    }
    public void checkBox5(View view) {
        if (checkBox5.isChecked()) {
            cal += 15;
            proteins += 0.5;
            carb += 2.8;
            fat += 0.4;
        }
        else
            cal -= 15;
    }
    public void checkBox6(View view) {
        if (checkBox6.isChecked()) {
            cal += 90;
            proteins += 4.7;
            carb += 4.5;
            fat += 6.0;
        }
        else
            cal -= 90;
    }
    public void checkBox7(View view) {
        if (checkBox7.isChecked()) {
            cal += 376;
            proteins += 8.3;
            carb += 73.2;
            fat += 5.9;
        }
        else
            cal = -376;
    }
    public void checkBox8(View view) {
        if (checkBox8.isChecked()) {
            cal += 322;
            proteins += 11.0;
            carb += 59.0;
            fat += 0.1;
        }
        else
            cal -= 322;
    }
    public void checkBox9(View view) {
        if (checkBox9.isChecked()) {
            cal += 113;
            proteins += 1.8;
            carb += 25.8;
            fat += 0.0;
        }
        else
            cal -= 113;
    }
    public void checkBox10(View view) {
        if (checkBox10.isChecked()) {
            cal += 114;
            proteins += 1.5;
            carb += 28.9;
            fat += 0.4;
        }
        else
            cal -= 114;
    }
    public void checkBox11(View view) {
        if (checkBox11.isChecked()) {
            cal += 100;
            proteins += 2.5;
            carb += 26.6;
            fat += 2.4;
        }
        else
            cal -= 100;
    }
    public void checkBox12(View view) {
        if (checkBox12.isChecked()) {
            cal += 17;
            proteins += 3.6;
            carb += 0.2;
            fat += 0.2;
        }
        else
            cal = -17;
    }
    public void checkBox13(View view) {
        if (checkBox13.isChecked()) {
            cal += 66;
            proteins += 6.29;
            carb += 0.56;
            fat += 5.3;
        }
        else
            cal -= 66;
    }
    public void checkBox14(View view) {
        if (checkBox14.isChecked()) {
            cal += 84;
            proteins += 5.7;
            carb += 3.8;
            fat += 5.1;
        }
        else
            cal -=84;
    }
}