package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dashboard1 extends AppCompatActivity {
    public static final String PHYSICAL_EXTRA="dashboard1.extra.physical";
    public static final String MENTAL_EXTRA="dashboard1.extra.mental";
    public static final String SOCIAL_EXTRA="dashboard1.extra.social";
    public static final String BMI="dashboard1.extra.bmi";
    public static final String WEIGHT_EXTRA="dashboard1.extra.weight";
    public static final String HEIGHT_EXTRA="dashboard1.extra.height";
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tvhead;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9;
    int q1,q2,q3,q4,q5,q6,q7,q8,q9;
    RadioButton radioButton;
    Button button3,calculate;
    TextView tq1,tq2,tq3,tq4,tq5,tq6,tq7,tq8,tq9;
    NumberPicker height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard1);
        radioGroup1=findViewById(R.id.radioGroup1);
        radioGroup2=findViewById(R.id.rg2);
        radioGroup3=findViewById(R.id.rg3);
        radioGroup4=findViewById(R.id.rg4);
        radioGroup5=findViewById(R.id.rg5);
        radioGroup6=findViewById(R.id.rg6);
        radioGroup7=findViewById(R.id.rg7);
        radioGroup8=findViewById(R.id.rg8);
        radioGroup9=findViewById(R.id.rg9);
        button3=findViewById(R.id.button3);
        height=findViewById(R.id.height);
        tv1=findViewById(R.id.textView10);
        tv2=findViewById(R.id.textView11);
        tv3=findViewById(R.id.textView12);
        tv4=findViewById(R.id.textView13);
        tv5=findViewById(R.id.textView14);
        tv6=findViewById(R.id.textView15);
        tv7=findViewById(R.id.textView10);
        tv8=findViewById(R.id.textView10);
        tv9=findViewById(R.id.textView10);
        tvhead=findViewById(R.id.textView2);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String UID=FirebaseAuth.getInstance().getCurrentUser().getUid();
                String role=snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("role").getValue(String.class);
               // Toast.makeText(dashboard1.this, ""+role, Toast.LENGTH_SHORT).show();
                if(!role.equalsIgnoreCase("Student(1-5)")){
                    tvhead.setText("Please answer these questions to let us know you better....!!");
                    tv1.setText("Rate your level of physical activeness ?");
                    tv2.setText("How would you rate your diet chart");
                    tv6.setText("Rate the impact of social media on you?");
                    tv3.setText("How would you rate your sleeping pattern ?");
                    tv4.setText("How is your interaction with other children ?");
                    tv5.setText("Rate the level of curiosity of yourself ?");
                    tv7.setText("How well you regulate your behaviour");
                    tv8.setText("How much are you intersted in trying new things on a scale of 1 to 3");
                    tv9.setText("How much are you intersted in spending time in your hobby");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        height.setMinValue(100);
        height.setMaxValue(250);
        weight=findViewById(R.id.weight);
        weight.setMinValue(20);
        weight.setMaxValue(150);
        height.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                calculateBMI();
            }
        });
        weight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                calculateBMI();
            }
        });
    }

    public double calculateBMI() {
        double Height=height.getValue();
        double Weight=weight.getValue();
        Height=Height/100;
        double bmi=(Weight)/(Height*Height);
        return bmi;
    }

    public void calculate(View view) {
        double bmi =calculateBMI();

        if(bmi>25){
            Toast.makeText(this, "Over weight "+bmi, Toast.LENGTH_SHORT).show();
        }
        else if(bmi> 18.5 ){
            Toast.makeText(this, "Healthy "+bmi, Toast.LENGTH_SHORT).show();
        }

        else
            Toast.makeText(this, "Under Weight "+bmi , Toast.LENGTH_SHORT).show();
    }


    public void checkButton(View view){}
    public void onClick(View view){

        tq1=findViewById(R.id.textView10);
        int radioId1=radioGroup1.getCheckedRadioButtonId();

        if(radioId1==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq1.setError("Please answer");
            tq1.requestFocus();
        }
        else {
            tq1.setError(null);tq1.requestFocus();
            if (radioId1 == R.id.radioButton1) {
                q1 = 1;
            } else if (radioId1 ==  R.id.radioButton2) {
                q1 = 2;
            } else if (radioId1 ==  R.id.radioButton3) {
                q1 = 3;
            }
        }

tq2=findViewById(R.id.textView11);
        int radioId2=radioGroup2.getCheckedRadioButtonId();

        if(radioId2==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq2.setError("Please answer");
            tq2.requestFocus();
        }
        else {
            tq2.setError(null);tq2.requestFocus();
            if (radioId2 ==  R.id.radioButton4) {
                q2 = 1;
            } else if (radioId2 ==  R.id.radioButton5) {
                q2 = 2;
            } else if (radioId2 ==  R.id.radioButton6) {
                q2 = 3;
            }
        }
        tq3=findViewById(R.id.textView12);
        int radioId3=radioGroup3.getCheckedRadioButtonId();

        if(radioId3==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq3.setError("Please answer");
            tq3.requestFocus();
        }
        else {
            tq3.setError(null);tq3.requestFocus();
            if (radioId3 ==  R.id.radioButton7) {
                q3 = 1;
            } else if (radioId3 ==  R.id.radioButton8) {
                q3 = 2;
            } else if (radioId3 ==  R.id.radioButton9) {
                q3 = 3;
            }
        }
        tq4=findViewById(R.id.textView13);
        int radioId4=radioGroup4.getCheckedRadioButtonId();
       // Toast.makeText(this, ""+radioId4, Toast.LENGTH_SHORT).show();
        if(radioId4==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq4.setError("Please answer");
            tq4.requestFocus();
        }
        else {
            tq4.setError(null);tq4.requestFocus();
            if (radioId4 ==  R.id.radioButton10) {
                q4 = 1;
            } else if (radioId4 ==  R.id.radioButton11) {
                q4 = 2;
            } else if (radioId4 ==  R.id.radioButton12) {
                q4 = 3;
            }
        }
        tq5=findViewById(R.id.textView14);
        int radioId5=radioGroup5.getCheckedRadioButtonId();
     //   Toast.makeText(this, ""+radioId5, Toast.LENGTH_SHORT).show();
        if(radioId5==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq5.setError("Please answer");
            tq5.requestFocus();
        }
        else {
            tq5.setError(null);tq5.requestFocus();
            if (radioId5 ==  R.id.radioButton13) {
                q5 = 1;
            } else if (radioId5 ==  R.id.radioButton14) {
                q5 = 2;
            } else if (radioId5 ==  R.id.radioButton15) {
                q5 = 3;
            }
        }
        tq6=findViewById(R.id.textView15);
        int radioId6=radioGroup6.getCheckedRadioButtonId();
       // Toast.makeText(this, ""+radioId6, Toast.LENGTH_SHORT).show();
        if(radioId6==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq6.setError("Please answer");
            tq6.requestFocus();
        }
        else {
            tq6.setError(null);tq6.requestFocus();
            if (radioId6 ==  R.id.radioButton16) {
                q6 = 1;
            } else if (radioId6 ==  R.id.radioButton17) {
                q6 = 2;
            } else if (radioId6 ==  R.id.radioButton18) {
                q6 = 3;
            }
        }
        tq7=findViewById(R.id.textView19);
        int radioId7=radioGroup7.getCheckedRadioButtonId();
       // Toast.makeText(this, ""+radioId7, Toast.LENGTH_SHORT).show();
        if(radioId7==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq7.setError("Please answer");
            tq7.requestFocus();
        }
        else {
            tq7.setError(null);tq7.requestFocus();
            if (radioId7 ==  R.id.radioButton20) {
                q7 = 1;
            } else if (radioId7 ==  R.id.radioButton21) {
                q7 = 2;
            } else if (radioId7 ==  R.id.radioButton22) {
                q7 = 3;
            }
        }
        tq8=findViewById(R.id.textView20);
        int radioId8=radioGroup8.getCheckedRadioButtonId();
       // Toast.makeText(this, ""+radioId8, Toast.LENGTH_SHORT).show();
        if(radioId8==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq8.setError("Please answer");
            tq8.requestFocus();
        }
        else {
            tq8.setError(null);tq8.requestFocus();
            if (radioId8 ==  R.id.radioButton24) {
                q8 = 1;
            } else if (radioId8 ==  R.id.radioButton25) {
                q8 = 2;
            } else if (radioId8 ==  R.id.radioButton26) {
                q8 = 3;
            }
        }
        tq9=findViewById(R.id.textView21);
        int radioId9=radioGroup9.getCheckedRadioButtonId();
        if(radioId9==-1){
            Toast.makeText(dashboard1.this, "Please answer all the questions...!!", Toast.LENGTH_SHORT).show();
            tq9.setError("Please answer");
            tq9.requestFocus();
        }
        else {
            tq9.setError(null);tq9.requestFocus();
            if (radioId9 ==  R.id.radioButton27) {
                q9 = 1;
            } else if (radioId9 ==  R.id.radioButton28) {
                q9 = 2;
            } else if (radioId9 ==  R.id.radioButton29) {
                q9 = 3;
            }
        }

        String physical=""+(q1+q2+q3);
        String social=""+(q4+q5+q6);
        String mental=""+(q7+q8+q9);
        String Height=""+height.getValue();
        String Weight=""+weight.getValue();
        //Toast.makeText(this, ""+physical+social+mental, Toast.LENGTH_SHORT).show();
       if (q1!=0&&q2!=0&&q3!=0&&q4!=0&&q5!=0&&q6!=0&&q7!=0&&q8!=0&&q9!=0) {
        Intent intent=new Intent(this,CircularProgressbar.class);
        intent.putExtra(BMI,calculateBMI());
        intent.putExtra(MENTAL_EXTRA,mental);
        intent.putExtra(PHYSICAL_EXTRA,physical);
        intent.putExtra(SOCIAL_EXTRA,social);
           intent.putExtra(WEIGHT_EXTRA,Weight);
           intent.putExtra(HEIGHT_EXTRA,Height);
        startActivity(intent);
        }
    }



}