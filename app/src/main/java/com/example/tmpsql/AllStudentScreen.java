package com.example.tmpsql;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class AllStudentScreen extends AppCompatActivity {
    ListView lvAllStudent;
    StudentAdapter adapter;
    ArrayList<Student>students;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student_screen);

        db = openOrCreateDatabase(Utils.DATABASE_NAME, MODE_PRIVATE, null);
        lvAllStudent = findViewById(R.id.lvAllStudent);
        students = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+Utils.TABLE_STUDENT, null);
        while (cursor.moveToNext()){
            Student st = new Student(cursor.getString(1),
                    cursor.getString(2), cursor.getString(3),cursor.getDouble(4));
            students.add(st);
        }
        adapter = new StudentAdapter(students, AllStudentScreen.this);
        lvAllStudent.setAdapter(adapter);
    }
}