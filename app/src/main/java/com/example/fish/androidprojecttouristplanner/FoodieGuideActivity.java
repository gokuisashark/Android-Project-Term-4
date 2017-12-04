package com.example.fish.androidprojecttouristplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FoodieGuideActivity extends AppCompatActivity {

    Button startNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodie_guide);

        startNowButton = (Button) findViewById(R.id.foodGuideStartButton);

        startNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent startNowIntent = new Intent(context, StartFoodieGuideActivity.class);
                startActivity(startNowIntent);
            }
        });
    }


}