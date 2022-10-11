package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.self.UsersClasses.UserStudent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class signUpCollege extends AppCompatActivity {
    Spinner gender;private EditText yourMail,yourPhn,password,confirmPassword,name;
    private DatePickerDialog datePickerDialog;
    private Button dob;

    ArrayAdapter<CharSequence> gender_adapter;private TextView error;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up_college);
        yourMail=findViewById(R.id.editTextTextPersonName1);
        yourPhn=findViewById(R.id.editTextTextPersonName2);
        name=findViewById(R.id.editTextTextPersonName);
        dob=findViewById(R.id.datePickerButton);
        password=findViewById(R.id.password);confirmPassword=findViewById(R.id.confirmPassword);
        error=findViewById(R.id.errorTV);
        gender=findViewById(R.id.role1);
        gender_adapter=ArrayAdapter.createFromResource(this,R.array.gender_array,R.layout.gender_spinner_layout);
        gender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(gender_adapter);
        initDatePicker();
        dob = findViewById(R.id.datePickerButton);
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dob.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
    public void backToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);}
    public void signUp(View view){
        createUser();
    }

    private void createUser() {
        String sname=name.getText().toString();
        String syourMail,syourPhn,spassword,sconfirmPassword,sdob,sgender,role="Student(College)";
        syourMail=yourMail.getText().toString();
        syourPhn=yourPhn.getText().toString();
        spassword=password.getText().toString();
        sconfirmPassword=confirmPassword.getText().toString();
        sdob=dob.getText().toString();
        sgender=gender.getSelectedItem().toString();
        mAuth=FirebaseAuth.getInstance();
        if(TextUtils.isEmpty(syourMail)){
            yourMail.setError("Your mail cannot be empty");
            yourMail.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(syourMail).matches()){
            yourMail.setError("Enter valid email");
            yourMail.requestFocus();
        }
        else if(TextUtils.isEmpty(syourPhn)==false&&syourPhn.length()!=10){
            yourPhn.setError("Password cannot be empty");
            yourPhn.requestFocus();
        }
        else if(TextUtils.isEmpty(sname)){
            name.setError("Name cannot be empty");
            name.requestFocus();
        }
        else if(TextUtils.isEmpty(sdob)){
            dob.setError("Date of birth cannot be empty");
            dob.requestFocus();
        }
        else if(sgender.equalsIgnoreCase("Select your Gender")){
            error.setVisibility(View.VISIBLE);
            error.setError("Select gender");
            error.requestFocus();
        }
        else if(TextUtils.isEmpty(spassword)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }
        else if(spassword.length()<8){
            password.setError("Password cannot be less than 8 caharacters");
            password.requestFocus();
            Toast.makeText(this, "Password cannot be of length less then 8 characters", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(sconfirmPassword)){
            confirmPassword.setError("Confirm Password cannot be empty");
            confirmPassword.requestFocus();
        }
        else if(spassword.equals(sconfirmPassword)==false){
            password.setError("Password and confirm password do not match");
            password.requestFocus();
        }
        else{

            error.requestFocus();
            error.setVisibility(View.INVISIBLE);
            mAuth.createUserWithEmailAndPassword(syourMail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        UserStudent userStudent =new UserStudent(sname,null,syourMail,null,sdob,sgender,null,role,syourPhn,false);
                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(userStudent)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(signUpCollege.this, "User signed up successfully", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(signUpCollege.this,MainActivity.class));
                                        }else {
                                            Toast.makeText(signUpCollege.this, "Error\t"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }

                }
            });
        }
    }
}