package com.example.self;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.self.UsersClasses.DiaryHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class SocialFeed extends AppCompatActivity {
    private FloatingActionButton addNoteButton;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<FeedAdapter> notesList,revnotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_feed);
        addNoteButton=findViewById(R.id.fab);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SocialFeed.this,AddFeed.class));
            }
        });
    }
}