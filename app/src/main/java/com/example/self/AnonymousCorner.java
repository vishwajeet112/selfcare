package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.self.UsersClasses.DiaryHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AnonymousCorner extends AppCompatActivity {
   private FloatingActionButton addNoteButton;
   RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<DiaryHelper> notesList,revnotesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_corner);
        addNoteButton=findViewById(R.id.fab);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(AnonymousCorner.this,addNote.class));
            }
        });

        recyclerView=findViewById(R.id.notes_list);
        databaseReference= FirebaseDatabase.getInstance().getReference("Diary").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesList=new ArrayList<>();revnotesList=new ArrayList<>();
        DiaryAdapter diaryAdapter=new DiaryAdapter(this,revnotesList);
        notesList.clear();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
           for(DataSnapshot dataSnapshot :snapshot.getChildren()){
            DiaryHelper diaryHelper= dataSnapshot.getValue(DiaryHelper.class);
            notesList.add(diaryHelper);
           }
           for(int i=notesList.size()-1;i>=0;i--){
               revnotesList.add(notesList.get(i));
           }
              diaryAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView.setAdapter(diaryAdapter);
    }
}