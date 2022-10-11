package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class dinner extends AppCompatActivity {
    int cal=0;
    public static final String PIE ="dinner.name";
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14;
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
    ImageView imageView47;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

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
        checkBox14=findViewById(R.id.checkBox14);
        button=findViewById(R.id.button);

//        imageView33=findViewById(R.id.imageView33);
//        imageView33.setImageResource(R.drawable.beans);
//
//        imageView34=findViewById(R.id.imageView34);
//        imageView34.setImageResource(R.drawable.dalia);
//
//        aj=findViewById(R.id.aj);
//        aj.setImageResource(R.drawable.curd);
//
//        imageView35=findViewById(R.id.imageView35);
//        imageView35.setImageResource(R.drawable.khichdi);
//
//        imageView36=findViewById(R.id.imageView36);
//        imageView36.setImageResource(R.drawable.lobia);
//
//        imageView37=findViewById(R.id.imageView37);
//        imageView37.setImageResource(R.drawable.malkadaal);
//
//        imageView38=findViewById(R.id.imageView38);
//        imageView38.setImageResource(R.drawable.roti);
//
//        imageView39=findViewById(R.id.imageView39);
//        imageView39.setImageResource(R.drawable.pulaofigma);
//
//        imageView40=findViewById(R.id.imageView40);
//        imageView40.setImageResource(R.drawable.kachorifigma);
//
//        imageView41=findViewById(R.id.imageView41);
//        imageView41.setImageResource(R.drawable.mixveg);
//
//        imageView42=findViewById(R.id.imageView42);
//        imageView42.setImageResource(R.drawable.matarpaneerfigma);
//
//        imageView45=findViewById(R.id.imageView45);
//        imageView45.setImageResource(R.drawable.butterchicken);
//
//        imageView46=findViewById(R.id.imageView46);
//        imageView46.setImageResource(R.drawable.eggcurry);
//
//        imageView47=findViewById(R.id.imageView47);
//        imageView47.setImageResource(R.drawable.fishcurry);


        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked())
                    cal+=80;
                else
                    cal-=80;
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox2.isChecked())
                    cal+=90;
                else
                    cal-=90;

            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox3.isChecked())
                    cal+=74;
                else
                    cal-=74;
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox4.isChecked())
                    cal+=126;
                else
                    cal-=126;

            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox5.isChecked())
                    cal+=137;
                else
                    cal-=137;

            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox6.isChecked())
                    cal+=170;
                else
                    cal-=170;

            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox8.isChecked())
                    cal+=133;
                else
                    cal-=133;

            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox8.isChecked())
                    cal+=110;
                else
                    cal-=110;

            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox9.isChecked())
                    cal+=448;
                else
                    cal-=448;

            }
        });
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox10.isChecked())
                    cal+=85;
                else
                    cal-=85;
            }
        });
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox11.isChecked())
                    cal+=178;
                else
                    cal-=178;

            }
        });
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox12.isChecked())
                    cal+=190;
                else
                    cal=-190;
            }
        });
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox13.isChecked())
                    cal+=159;
                else
                    cal-=159;
            }
        });
        checkBox14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox14.isChecked())
                    cal+=155;
                else
                    cal-=155;
            }
        });
    }

    public void on(View view) {
        Intent intent=new Intent(dinner.this,Dietchart.class);
        if (cal>500) {
            Toast.makeText(dinner.this, "You are overeating!!", Toast.LENGTH_SHORT).show();
        }
        intent.putExtra(PIE,cal);
        startActivity(intent);
    }
}