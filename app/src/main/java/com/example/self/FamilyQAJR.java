package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class FamilyQAJR extends AppCompatActivity {
    private RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5;
    private TextView t1,t2,t3,t4,t5;int q1,q2,q3,q4,q5;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_qajr);
        radioGroup1=findViewById(R.id.radioGroup1);radioGroup2=findViewById(R.id.radioGroup2);radioGroup3=findViewById(R.id.radioGroup3);
        radioGroup4=findViewById(R.id.radioGroup4);radioGroup5=findViewById(R.id.radioGroup5);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);  t3=findViewById(R.id.textView3);  t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);  databaseReference= FirebaseDatabase.getInstance().getReference("User Data");

        // button = findViewById(R.id.button);
    }
    public void doneFun(View view) {
        int rb1= radioGroup1.getCheckedRadioButtonId();
        //   Toast.makeText(this, ""+rb1, Toast.LENGTH_SHORT).show();
        if(rb1==-1){
            t1.setError("Please select any one of the options");
            t1.requestFocus();
        }
        else{
            t1.setError(null);
            t1.requestFocus();
            if(rb1==R.id.radioButton11)
                q1=1;
            else if(rb1==R.id.radioButton12)
                q1=2;
            else if(rb1==R.id.radioButton13)
                q1=3;
            else if(rb1==R.id.radioButton14)
                q1=4;
            else if(rb1==R.id.radioButton15)
                q1=5;
        }
        int rb2=radioGroup2.getCheckedRadioButtonId();
        //  Toast.makeText(this, ""+rb2, Toast.LENGTH_SHORT).show();
        if(rb2==-1){
            t2.setError("Please select any one of the options");
            t2.requestFocus();
        }
        else{
            t2.setError(null);
            t2.requestFocus();
            if(rb2==R.id.radioButton21)
                q2=1;
            else if(rb2==R.id.radioButton22)
                q2=2;
            else if(rb2==R.id.radioButton23)
                q2=3;
            else if(rb2==R.id.radioButton24)
                q2=4;
            else if(rb2==R.id.radioButton25)
                q2=5;
        }
        int rb3=radioGroup3.getCheckedRadioButtonId();
        //  Toast.makeText(this, ""+rb3, Toast.LENGTH_SHORT).show();
        if(rb3==-1){
            t3.setError("Please select any one of the options");
            t3.requestFocus();
        }
        else{t3.setError(null);
            t3.requestFocus();
            if(rb3==R.id.radioButton31)
                q3=1;
            else if(rb3==R.id.radioButton32)
                q3=2;
            else if(rb3==R.id.radioButton33)
                q3=3;
            else if(rb3==R.id.radioButton34)
                q3=4;
            else if(rb3==R.id.radioButton35)
                q3=5;
        }
        int rb4=radioGroup4.getCheckedRadioButtonId();
        // Toast.makeText(this, ""+rb4, Toast.LENGTH_SHORT).show();
        if(rb4==-1){
            t4.setError("Please select any one of the options");
            t4.requestFocus();
        }
        else{t4.setError(null);
            t4.requestFocus();
            if(rb4==R.id.radioButton41)
                q4=1;
            else if(rb4==R.id.radioButton42)
                q4=2;
            else if(rb4==R.id.radioButton43)
                q4=3;
            else if(rb4==R.id.radioButton44)
                q4=4;
            else if(rb4==R.id.radioButton45)
                q4=5;
        }
        int rb5=radioGroup5.getCheckedRadioButtonId();
        // Toast.makeText(this, ""+rb5, Toast.LENGTH_SHORT).show();
        if(rb5==-1){
            t5.setError("Please select any one of the options");
            t5.requestFocus();
        }
        else{ t5.setError(null);
            t5.requestFocus();
            if(rb5==R.id.radioButton51)
                q5=1;
            else if(rb5==R.id.radioButton52)
                q5=2;
            else if(rb5==R.id.radioButton53)
                q5=3;
            else if(rb5==R.id.radioButton54)
                q5=4;
            else if(rb5==R.id.radioButton55)
                q5=5;
        }
        //Toast.makeText(this, ""+q1+""+q2+""+q3+""+q4+""+q5, Toast.LENGTH_SHORT).show();
        long time=System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = makeDateString(day, month, year);
        int q=q1+q2+q3+q4+q5;
        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(date).child("FamilyQA").setValue(""+q).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(FamilyQAJR.this,maindashboard.class));
                }
            }
        });
        //Toast.makeText(this, ""+q, Toast.LENGTH_SHORT).show();
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {

        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }
}