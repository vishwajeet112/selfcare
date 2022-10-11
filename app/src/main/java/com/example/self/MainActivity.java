package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    EditText email, password;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.password);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
    }

    public void roleOpen(View view) {
        Intent intent = new Intent(this, SignUpRole.class);

        startActivity(intent);
    }

    public void forgetPassword(View view) {
        Intent intent = new Intent(this, ForgetPassword.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        String smail, spassword;
        smail = email.getText().toString();
        spassword = password.getText().toString();
        if (TextUtils.isEmpty(smail)) {
            email.setError("Email cannot be empty");
            email.requestFocus();
        } else if (TextUtils.isEmpty(spassword)) {
            password.setError("Password cannot be empty");
            password.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(smail, spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Log in successfull", Toast.LENGTH_SHORT).show();
                        String UID = mAuth.getCurrentUser().getUid();
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                role = snapshot.child(UID).child("role").getValue(String.class);
                                if (role != null) {
                                    if (role.equalsIgnoreCase("Councellor")) {
                                        Intent intent = new Intent(MainActivity.this, CouncellorDashboard.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(MainActivity.this, maindashboard.class);
                                        startActivity(intent);
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });


                    } else {
                        Toast.makeText(MainActivity.this, "Log in Error" + (task.getException().getMessage()), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
//        Intent intent=new Intent(MainActivity.this,SocialFeed.class);
//        startActivity(intent);


    }

}