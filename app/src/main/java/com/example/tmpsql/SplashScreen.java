package com.example.tmpsql;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity implements View.OnClickListener {
    Animation anim_roteat,anim_baounch;
    ImageView imageAnim;
    Button btn_roteat,btn_baounch;
    SQLiteDatabase db;
    private  static int SplashScreen=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        db = openOrCreateDatabase(Utils.DATABASE_NAME, MODE_PRIVATE, null);
        Utils.createTables(db);

        anim_baounch = AnimationUtils.loadAnimation(this, R.anim.baounch);
        anim_roteat = AnimationUtils.loadAnimation(this, R.anim.roteat);

        imageAnim = findViewById(R.id.imageView);
        btn_roteat= findViewById(R.id.btn_roteat);
        btn_baounch= findViewById(R.id.btn_baounch);
        btn_baounch.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SplashScreen);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_baounch){
            imageAnim.setAnimation(anim_baounch);
        }
        if (v==btn_roteat){
            imageAnim.setAnimation(anim_roteat);
        }
    }
}