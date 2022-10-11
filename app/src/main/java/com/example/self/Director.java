package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Director extends AppCompatActivity {
  DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);
        databaseReference=FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int m=0,f=0,o=0;
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    if(dataSnapshot.child("role").getValue(String.class).equalsIgnoreCase("Guardian")||dataSnapshot.child("role").getValue(String.class).equalsIgnoreCase("Councellor")){}
               else{
                String gender=   dataSnapshot.child("gender").getValue(String.class);
                if(gender.equalsIgnoreCase("Male")){m++;}
                else if(gender.equalsIgnoreCase("Female")){f++;}
                else if(gender.equalsIgnoreCase("Other")){o++;}
                    } }
              // Intent intent=new Intent(Director.this,Circular.class);//
                Toast.makeText(Director.this, ""+m+f+o, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}