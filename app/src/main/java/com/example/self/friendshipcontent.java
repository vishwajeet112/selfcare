package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class friendshipcontent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendshipcontent);
    }
    public void onNext(View view) {
        //  Toast.makeText(this, ""+ FirebaseAuth.getInstance().getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
       // startActivity(new Intent(this,FriendsQA.class));
        //Intent intent=new Intent(friendshipcontent.this,FriendsQA.class);
       // startActivity(intent);
    }
}