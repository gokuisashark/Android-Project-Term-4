package com.example.fish.androidprojecttouristplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class WelcomeScreenActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.relativeLayoutWelcomeScreen);
        layout.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        return true;
    }
}
