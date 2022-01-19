package com.example.tmpsql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AllStudentScreen extends AppCompatActivity {
    ListView lv;
    SQLiteDatabase db;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student_screen2);


        lv = findViewById(R.id.lvAllStudentScreen);
        db = openOrCreateDatabase(Utils.DATABASE_NAME,MODE_PRIVATE, null);
        students = new ArrayList<>();
        students = Utils.better_average(70, db);
        studentAdapter adapter = new studentAdapter(AllStudentScreen.this,0, students);
        lv.setAdapter(adapter);
    }
}