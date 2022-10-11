package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.self.UsersClasses.UserGuardian;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GuuardianSignUp extends AppCompatActivity {
    EditText childMail, yourMail, yourPhn, password, confirmPassword, name, childpassword;
    FirebaseAuth mAuth;
    String UID, sguardianMail, role;
    DatabaseReference databaseReference;
    private TextView tv;
    String schildMail;
    String syourMail;
    String schildpassword;
    String syourPhn;
    String spassword;
    String sconfirmPassword;
    String sname,myrole="Guardian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_guuardian_sign_up);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        name = findViewById(R.id.editTextTextPersonName);
        yourMail = findViewById(R.id.editTextTextPersonName1);
        yourPhn = findViewById(R.id.editTextTextPersonName2);
        childMail = findViewById(R.id.editTextTextPersonName5);
        childpassword = findViewById(R.id.cpassword);
        tv = findViewById(R.id.checkBox);
        mAuth = FirebaseAuth.getInstance();


    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        schildMail = childMail.getText().toString();
        schildpassword = childpassword.getText().toString();
        syourMail = yourMail.getText().toString().trim();
        syourPhn = yourPhn.getText().toString().trim();
        spassword = password.getText().toString().trim();
        sconfirmPassword = confirmPassword.getText().toString().trim();
        sname = name.getText().toString().trim();


        if (TextUtils.isEmpty(syourMail)) {
            yourMail.setError("Your mail cannot be empty");
            yourMail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(syourMail).matches()) {
            yourMail.setError("Enter valid email");
            yourMail.requestFocus();
        } else if (TextUtils.isEmpty(schildMail)) {
            childMail.setError("Child mail cannot be empty");
            childMail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(schildMail).matches()) {
            childMail.setError("Enter valid email");
            childMail.requestFocus();
        } else if (TextUtils.isEmpty(schildpassword)) {
            childpassword.setError("Child mail cannot be empty");
            childpassword.requestFocus();
        } else if (TextUtils.isEmpty(sname)) {
            name.setError("Name cannot be empty");
            name.requestFocus();
        } else {


            mAuth.signInWithEmailAndPassword(schildMail, schildpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                    } else {
                        Toast.makeText(GuuardianSignUp.this, "Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        childMail.setError(task.getException().getMessage());
                        childMail.requestFocus();
                    }
                }
            });
            if (FirebaseAuth.getInstance().getCurrentUser() != null)
                UID = FirebaseAuth.getInstance().getCurrentUser().getUid();

            FirebaseAuth.getInstance().signOut();


            if (UID == null) {
                Toast.makeText(this, "Please click on sign up button again", Toast.LENGTH_SHORT).show();
            } else {
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        sguardianMail = snapshot.child(UID).child("guardianMail").getValue().toString();
                        role = snapshot.child(UID).child("role").getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(GuuardianSignUp.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                if (sguardianMail == null || role == null) {
                    Toast.makeText(this, "Please click on sign up button again", Toast.LENGTH_SHORT).show();
                } else if (sguardianMail.equalsIgnoreCase(syourMail) && role.equalsIgnoreCase("Student(6-8)")) {
                    createUser();
                } else {
                    Toast.makeText(this, "Some error Occoured.Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void createUser() {
        schildMail = childMail.getText().toString();
        schildpassword = childpassword.getText().toString();
        syourMail = yourMail.getText().toString().trim();
        syourPhn = yourPhn.getText().toString().trim();
        spassword = password.getText().toString().trim();
        sconfirmPassword = confirmPassword.getText().toString().trim();
        sname = name.getText().toString().trim();
        if (TextUtils.isEmpty(spassword)) {
            password.setError("Password cannot be empty");
            password.requestFocus();
        } else if (spassword.length() < 8) {
            password.setError("Password cannot be less than 8 caharacters");
            password.requestFocus();
            Toast.makeText(this, "Password cannot be of length less then 8 characters", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(sconfirmPassword)) {
            confirmPassword.setError("Confirm Password cannot be empty");
            confirmPassword.requestFocus();
        } else if (spassword.equals(sconfirmPassword) == false) {
            password.setError("Password and confirm password do not match");
            password.requestFocus();
        } else {
        mAuth.createUserWithEmailAndPassword(syourMail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UserGuardian userGuardian=new UserGuardian(syourMail,syourPhn,schildMail,sname,myrole,schildpassword);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(userGuardian)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(GuuardianSignUp.this, "User signed up successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(GuuardianSignUp.this,MainActivity.class));
                                    }else {
                                        Toast.makeText(GuuardianSignUp.this, "Error\t"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });
        }

    }
}
