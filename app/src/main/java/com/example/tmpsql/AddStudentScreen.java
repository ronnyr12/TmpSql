package com.example.tmpsql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentScreen extends AppCompatActivity {
    EditText classNameNS, lastNameNS,firstNameNS,avgGradeNS;
    Button saveNS_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_screen2);


        saveNS_btn = findViewById(R.id.saveNS_btn);
    }
}