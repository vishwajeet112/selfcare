package com.example.self;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.self.UsersClasses.Uploadhelp;
import com.example.self.UsersClasses.UserCouncellor;
import com.example.self.UsersClasses.UserGuardian;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class signup extends AppCompatActivity {
    private Button button23;
    private EditText specialisation, yourMail, yourPhn, password, confirmPassword, name;
    private String sspecialisation, syourMail, syourPhn, spassword, sconfirmPassword, sname, role = "Councellor", cerurl;
    private Spinner gender;private TextView error;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    ArrayAdapter<CharSequence> gender_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        gender = findViewById(R.id.role1);
        gender_adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, R.layout.gender_spinner_layout);
        gender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(gender_adapter);error=findViewById(R.id.errorTV);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        name = findViewById(R.id.editTextTextPersonName);
        yourMail = findViewById(R.id.editTextTextPersonName1);
        yourPhn = findViewById(R.id.editTextTextPersonName2);
        specialisation = findViewById(R.id.editTextTextPersonName5);
        button23 = findViewById(R.id.button23);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        mAuth=FirebaseAuth.getInstance();
        button23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sspecialisation = specialisation.getText().toString().trim();
                syourMail = yourMail.getText().toString().trim();
                syourPhn = yourPhn.getText().toString().trim();
                spassword = password.getText().toString().trim();
                sconfirmPassword = confirmPassword.getText().toString().trim();
                sname = name.getText().toString().trim();
                selectPDFFile();
            }
        });


    }

    private void selectPDFFile() {
        Intent intent = new Intent();
        intent.setType("image/jpeg");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Jpeg File"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uploadPDFFile(data.getData());
        }
    }

    private void uploadPDFFile(Uri data) {
        syourMail = yourMail.getText().toString().trim();
        syourMail = yourMail.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading.......");
        progressDialog.show();
        StorageReference reference = storageReference.child("uploads/" + System.currentTimeMillis() + ".jpeg");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete()) ;
                        Uri url = uri.getResult();
                        cerurl = url.toString();
//                        Uploadhelp uploadhelp=new Uploadhelp(url.toString(),sname,syourMail);
//                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadhelp);
                        Toast.makeText(signup.this, "File uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("Uploaded:  " + (int) progress + "%");

                    }
                });
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        sspecialisation = specialisation.getText().toString().trim();
        syourMail = yourMail.getText().toString().trim();
        syourPhn = yourPhn.getText().toString().trim();
        spassword = password.getText().toString().trim();
        sconfirmPassword = confirmPassword.getText().toString().trim();
        sname = name.getText().toString().trim();
        String sgender=gender.getSelectedItem().toString();
        if (TextUtils.isEmpty(syourMail)) {
            yourMail.setError("Your mail cannot be empty");
            yourMail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(syourMail).matches()) {
            yourMail.setError("Enter valid email");
            yourMail.requestFocus();
        } else if (TextUtils.isEmpty(sname)) {
            name.setError("Name cannot be empty");
            name.requestFocus();
        } else if (sgender.equalsIgnoreCase("Select your Gender")) {
            error.setVisibility(View.VISIBLE);
            error.setError("Select gender");
            error.requestFocus();
        } else if (TextUtils.isEmpty(spassword)) {
            password.setError("Password cannot be empty");
            password.requestFocus();}
            else if(TextUtils.isEmpty(syourPhn)==false&&syourPhn.length()!=10){
            yourPhn.setError("Password cannot be empty");
            yourPhn.requestFocus();

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
        } else if (TextUtils.isEmpty(sspecialisation)) {
            specialisation.setError("Password cannot be empty");
            specialisation.requestFocus();}
            else {
                if(cerurl==null){
                    Toast.makeText(this, "Please upload a certificate file", Toast.LENGTH_SHORT).show();
                    error.setText("Please upload a certificate file");
                    error.setError("Please upload a certificate file");
                    error.requestFocus();
                }
                else{
                    error.setVisibility(View.INVISIBLE);
//                    Toast.makeText(this, "" + cerurl, Toast.LENGTH_SHORT).show();
                    mAuth.createUserWithEmailAndPassword(syourMail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               UserCouncellor userCouncellor=new UserCouncellor(syourMail,syourPhn,sname,sspecialisation,sgender,cerurl,role,false);
                               databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userCouncellor).addOnCompleteListener(new OnCompleteListener<Void>() {
                                   @Override
                                   public void onComplete(@NonNull Task<Void> task) {
                                       if(task.isSuccessful()){
                                           Toast.makeText(signup.this, "User signed up successfully", Toast.LENGTH_SHORT).show();
                                           startActivity(new Intent(signup.this,MainActivity.class));
                                       }else {
                                           Toast.makeText(signup.this, "Error\t"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                       }
                                   }
                               });
                           }
                           else{
                               Toast.makeText(signup.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                }


        }
    }
}