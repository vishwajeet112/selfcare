package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpRole extends AppCompatActivity {
    Button  next;
    TextView t;
    String selectedRole1,selectedRole2;
    Spinner role1,role2;
    ArrayAdapter<CharSequence> role1adapter,role2adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up_role);
       role1=findViewById(R.id.role1);role2=findViewById(R.id.role2);
        role1adapter=ArrayAdapter.createFromResource(this,R.array.role1_array,R.layout.spinner_layout);
        role1adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role1.setAdapter(role1adapter);
        role1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                role2=findViewById(R.id.role2);
                selectedRole1=role1.getSelectedItem().toString();
                int parentID= adapterView.getId();
                if(parentID==R.id.role1){
                    switch (selectedRole1){
                        case ("Select your role"):
                            role2adpater=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.select_subrole,R.layout.spinner_layout);
                            break;
                        case ("Student"):
                            role2adpater=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.student_array,R.layout.spinner_layout);
                            break;
                        case ("Guardian"):
                            role2adpater=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.guardian_array,R.layout.spinner_layout);
                            break;
                        case ("Councellor"):
                            role2adpater=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.counsellor_array,R.layout.spinner_layout);
                            break;

                    }
role2adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    role2.setAdapter(role2adpater);
                    role2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedRole2=role2.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
next=findViewById(R.id.next);
t=findViewById(R.id.textView7);
next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(selectedRole1.equalsIgnoreCase("Select your role")){
            Toast.makeText(SignUpRole.this, "Please select your role", Toast.LENGTH_LONG).show();
            t.setError("Select role");
            t.requestFocus();
        }
        else if(selectedRole1.equalsIgnoreCase("Student")) {
            if (selectedRole2.equalsIgnoreCase("Primary (Class 1-5)")) {
                t.setError(null);
                Intent intent = new Intent(SignUpRole.this, signUp1_5.class);
                startActivity(intent);
            }
            else if (selectedRole2.equalsIgnoreCase("Junior (Class 6-8)")) {
                t.setError(null);
                Intent intent = new Intent(SignUpRole.this, signUp6_8.class);
                startActivity(intent);
            }
            else if (selectedRole2.equalsIgnoreCase("Secondary (Class 9-12)")) {
                t.setError(null);
                Intent intent = new Intent(SignUpRole.this, signUp9_12.class);
                startActivity(intent);
            }
            else if (selectedRole2.equalsIgnoreCase("College")) {
                t.setError(null);
                Intent intent = new Intent(SignUpRole.this, signUpCollege.class);
                startActivity(intent);
            }
        }
        else if(selectedRole1.equalsIgnoreCase("Guardian")) {
                t.setError(null);
                Intent intent = new Intent(SignUpRole.this, GuuardianSignUp.class);
                startActivity(intent);
            }
        else if(selectedRole1.equalsIgnoreCase("Councellor")) {
            t.setError(null);
            Intent intent = new Intent(SignUpRole.this, signup.class);
            startActivity(intent);
        }
    }
});
    }
}