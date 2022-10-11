package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class lunch extends AppCompatActivity {
    int cal=0;
    public static final String EXTRAS="lunch.name";
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
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

//        imageView33=findViewById(R.id.imageView33);
//        imageView33.setImageResource(R.drawable.aloochillidry);
//
//        imageView34=findViewById(R.id.imageView34);
//        imageView34.setImageResource(R.drawable.cholecurry);
//
//        aj=findViewById(R.id.aj);
//        aj.setImageResource(R.drawable.papadlunch);
//
//        imageView35=findViewById(R.id.imageView35);
//        imageView35.setImageResource(R.drawable.rotifigma);
//
//        imageView36=findViewById(R.id.imageView36);
//        imageView36.setImageResource(R.drawable.masaladosafigma);
//
//        imageView37=findViewById(R.id.imageView37);
//        imageView37.setImageResource(R.drawable.purifigma);
//
//        imageView38=findViewById(R.id.imageView38);
//        imageView38.setImageResource(R.drawable.kachorifigma);
//
//        imageView39=findViewById(R.id.imageView39);
//        imageView39.setImageResource(R.drawable.rajmacurryfigma);
//
//        imageView40=findViewById(R.id.imageView40);
//        imageView40.setImageResource(R.drawable.butterpaneerfigma);
//
//        imageView41=findViewById(R.id.imageView41);
//        imageView41.setImageResource(R.drawable.matarpaneerfigma);
//
//        imageView42=findViewById(R.id.imageView42);
//        imageView42.setImageResource(R.drawable.pulaofigma);
//
//        imageView45=findViewById(R.id.imageView45);
//        imageView45.setImageResource(R.drawable.eggcurryfigma);
//
//        imageView46=findViewById(R.id.imageView46);
//        imageView46.setImageResource(R.drawable.butterchickenfigma);

    }

    public void on1(View view) {
        Intent intent=new Intent(lunch.this,Dietchart.class);
        if (cal>600) {
            Toast.makeText(lunch.this, "You are overeating!!", Toast.LENGTH_SHORT).show();
        }
        intent.putExtra(EXTRAS,cal);
        startActivity(intent);
    }
    public void checkBox1(View view) {
        if(checkBox1.isChecked())
            cal+=177;
        else
            cal-=177;
    }
    public void checkBox2(View view) {
        if(checkBox2.isChecked())
            cal+=125;
        else
            cal-=125;
    }
    public void checkBox3(View view) {
        if(checkBox3.isChecked())
            cal+=120;
        else
            cal-=120;

    }
    public void checkBox4(View view) {
        if(checkBox4.isChecked())
            cal+=341;
        else
            cal-=341;
    }
    public void checkBox5(View view) {
        if(checkBox5.isChecked())
            cal+=190;
        else
            cal-=190;
    }
    public void checkBox6(View view) {
        if(checkBox6.isChecked())
            cal+=200;
        else
            cal-=200;
    }
    public void checkBox7(View view) {
        if(checkBox7.isChecked())
            cal+=448;
        else
            cal-=448;
    }
    public void checkBox8(View view) {
        if(checkBox8.isChecked())
            cal+=110;
        else
            cal-=110;
    }
    public void checkBox9(View view) {
        if(checkBox9.isChecked())
            cal+=500;
        else
            cal-=500;
    }
    public void checkBox10(View view) {
        if(checkBox10.isChecked())
            cal+=178;
        else
            cal-=178;
    }
    public void checkBox11(View view) {
        if(checkBox11.isChecked())
            cal+=133;
        else
            cal-=133;
    }
    public void checkBox12(View view) {
        if(checkBox12.isChecked())
            cal+=159;
        else
            cal=-159;
    }
    public void checkBox13(View view) {
        if(checkBox13.isChecked())
            cal+=190;
        else
            cal-=190;
    }
}