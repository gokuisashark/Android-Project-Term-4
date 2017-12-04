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

public class CoffeeActivity extends AppCompatActivity {

    CoffeeJsonData[] coffeeJsonData;
    private RecyclerView coffeeList;
    private CoffeeAdapter mCoffeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        parseJson();

        coffeeList = (RecyclerView) findViewById(R.id.recyclerViewCoffee);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        coffeeList.setLayoutManager(linearLayoutManager);

        mCoffeeAdapter = new CoffeeAdapter(this, coffeeJsonData);
        coffeeList.setAdapter(mCoffeeAdapter);
    }

    public class CoffeeJsonData {
        String name;
        String description;
    }

    private String readTxt(int resource) {
        String output = "";
        String line;

        InputStream inputStream = getResources().openRawResource(resource);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            while( (line = reader.readLine()) != null ){
                output = output + line;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }

    void parseJson() {
        Gson gson = new Gson();
        String jsonData = readTxt(R.raw.coffee);
        Log.i("Fish", jsonData);

        coffeeJsonData = gson.fromJson(jsonData, CoffeeJsonData[].class);
    }

}
