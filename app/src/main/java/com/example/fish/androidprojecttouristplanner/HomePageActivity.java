package com.example.fish.androidprojecttouristplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    Button foodieGuideButton;
    Button learnCoffeeButton;
    Button findWaySGButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        foodieGuideButton = (Button) findViewById(R.id.foodieGuideButton);
        learnCoffeeButton = (Button) findViewById(R.id.learnCoffeeButton);
        findWaySGButton = (Button) findViewById(R.id.findWaySGButton);

        foodieGuideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent foodieGuideIntent = new Intent(context, FoodieGuideActivity.class);
                startActivity(foodieGuideIntent);
            }
        });
    }

}