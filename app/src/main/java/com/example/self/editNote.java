package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.self.UsersClasses.DiaryHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editNote extends AppCompatActivity {
    DatabaseReference databaseReference;private Button save;private EditText content;String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        save=findViewById(R.id.button);
        content=findViewById(R.id.content);
        databaseReference= FirebaseDatabase.getInstance().getReference("Diary").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        String key=getIntent().getStringExtra("EDIT");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             String note=   snapshot.child(key).child("note").getValue(String.class) ;
             content.setText(note);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               databaseReference.child(key).child("note").setValue(content.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(editNote.this, "Thought updated Successfully", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(editNote.this,AnonymousCorner.class));}
                        else
                                Toast.makeText(editNote.this, "Some Error occoured", Toast.LENGTH_SHORT).show();


                   }
               });

            }
        });
    }
}