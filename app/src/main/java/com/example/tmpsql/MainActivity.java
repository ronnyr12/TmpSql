package com.example.tmpsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==R.id.allStudentScreen){
            Intent intent = new Intent(MainActivity.this, AllStudentScreen.class);
            startActivity(intent);
        }
        else if (id==R.id.addStudentScreen){
            Intent intent = new Intent(MainActivity.this, AddStudentScreen.class);
            startActivity(intent);
        }
        else if (id==R.id.addStudentScreen){
            Intent intent = new Intent(MainActivity.this, detailsS.class);
            startActivity(intent);
        }
        return true;
    }
}