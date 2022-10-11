package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.self.UsersClasses.DiaryHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class addNote extends AppCompatActivity {
    DatabaseReference databaseReference;private Button save;private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        save=findViewById(R.id.button);
        content=findViewById(R.id.content);
        databaseReference= FirebaseDatabase.getInstance().getReference("Diary").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=content.getText().toString();
                String currentTime = DateFormat.getDateTimeInstance().format(System.currentTimeMillis());
                String key=databaseReference.push().getKey();
                DiaryHelper diaryHelper=new DiaryHelper(s,key,currentTime);
                databaseReference.child(key).setValue(diaryHelper).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(addNote.this, "Thought created Successfully", Toast.LENGTH_SHORT).show();
                            //finish();
                       startActivity(new Intent(addNote.this,AnonymousCorner.class));
                            }
                        else
                            Toast.makeText(addNote.this, "Some Error occoured", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}