package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.self.UsersClasses.StartBMIData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CircularProgressbar extends AppCompatActivity {
    PieChart pieChart;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_circular_progressbar);
        pieChart=findViewById(R.id.pieChart);
        Intent intent=getIntent();
        int p=Integer.parseInt(intent.getStringExtra(dashboard1.PHYSICAL_EXTRA))*10;
        int m=Integer.parseInt(intent.getStringExtra(dashboard1.MENTAL_EXTRA))*10;
        int s=Integer.parseInt(intent.getStringExtra(dashboard1.SOCIAL_EXTRA))*10;
        ArrayList<PieEntry> pieEntries=new ArrayList<>();
        pieEntries.add(new PieEntry(p,"Physical"));
        pieEntries.add(new PieEntry(s,"Social"));
        pieEntries.add(new PieEntry(m,"Mental"));
        databaseReference= FirebaseDatabase.getInstance().getReference("User Data");

//        for(int i=1;i<4;i++){
//            float value =(float)(i*10.0);
//            PieEntry pieEntry=new PieEntry(i,value);
//            pieEntries.add(pieEntry);
        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextSize(20f);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.animateXY(1000,1000);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Your Report");
        pieChart.setCenterTextSize(20f);
    }


    public void doneFun(View view) {
        Intent intent=getIntent();
        int p=Integer.parseInt(intent.getStringExtra(dashboard1.PHYSICAL_EXTRA))*10;
        int m=Integer.parseInt(intent.getStringExtra(dashboard1.MENTAL_EXTRA))*10;
        int s=Integer.parseInt(intent.getStringExtra(dashboard1.SOCIAL_EXTRA))*10;
        int w,h;
        w=Integer.parseInt(intent.getStringExtra(dashboard1.WEIGHT_EXTRA));
        h=Integer.parseInt(intent.getStringExtra(dashboard1.HEIGHT_EXTRA));
        StartBMIData startBMIData=new StartBMIData(p,m,s,w,h);
        mAuth=FirebaseAuth.getInstance();
        String UID= mAuth.getCurrentUser().getUid();
         //Toast.makeText(this, ""+UID, Toast.LENGTH_SHORT).show();
         FirebaseDatabase.getInstance().getReference("Users").child(UID).child("profileComp").setValue(true);
        databaseReference.child(UID).child("StartingData").setValue(startBMIData);
         startActivity(new Intent(this,maindashboard.class));
    }
}
