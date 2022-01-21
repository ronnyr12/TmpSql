package com.example.tmpsql;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentScreen extends AppCompatActivity {
    EditText classNameNS, lastNameNS,firstNameNS,avgGradeNS;
    Button btn_save_addscreen;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_screen);

        db = openOrCreateDatabase(Utils.DATABASE_NAME,MODE_PRIVATE,null);
        classNameNS = findViewById(R.id.classNameNS);
        lastNameNS = findViewById(R.id.lastNameNS);
        firstNameNS = findViewById(R.id.firstNameNS);
        avgGradeNS = findViewById(R.id.avgGradeNS);
        btn_save_addscreen = findViewById(R.id.btn_save_addscreen);

        btn_save_addscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name = firstNameNS.getText().toString();
                String l_name = lastNameNS.getText().toString();
                String class_name = classNameNS.getText().toString();
                double avg = Double.valueOf(avgGradeNS.getText().toString());

                Utils.insert_student("mr","porteno","yb6",
                        98, db);
                Utils.insert_student("jo","rog","yb6",
                        70, db);
                Utils.insert_student("ben","parker","yb6",
                        65, db);
                 Utils.insert_student("albert","einstein","yb2",
                        80, db);
                 Utils.insert_student("yang","li","yb2",
                        50, db);


            }
        });
    }
}