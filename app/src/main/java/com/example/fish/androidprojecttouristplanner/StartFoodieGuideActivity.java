package com.example.fish.androidprojecttouristplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StartFoodieGuideActivity extends AppCompatActivity {

    FoodPlacesJsonData[] foodPlacesJsonData;
    private RecyclerView foodieguide;
    private FoodieGuideAdapter mFoodieGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_foodie_guide);

        parseJson();

        foodieguide = (RecyclerView) findViewById(R.id.recyclerViewFoodieGuide);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        foodieguide.setLayoutManager(linearLayoutManager);

        mFoodieGuideAdapter = new FoodieGuideAdapter(this, foodPlacesJsonData);
        foodieguide.setAdapter(mFoodieGuideAdapter);

    }

    public class FoodPlacesJsonData {
        String name;
        String description;
        String address;
    }

    private String readTxt(int resource) {
        String output = "";
        String line;

        InputStream inputStream = getResources().openRawResource(resource);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            while ((line = reader.readLine()) != null) {
                output = output + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;

    }

    void parseJson(){
        Gson gson = new Gson();
        String jsonData = readTxt((R.raw.foodplaces));
        Log.i("Fish", jsonData);
        foodPlacesJsonData = gson.fromJson(jsonData, FoodPlacesJsonData[].class);


    }



}
