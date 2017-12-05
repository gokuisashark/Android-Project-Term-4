package com.example.fish.androidprojecttouristplanner;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StartFoodieGuideActivity extends AppCompatActivity {

    FoodieGuideJsonData[] foodieGuideJsonData;
    private RecyclerView foodieGuide;
    private FoodieGuideAdapter foodieGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_foodie_guide);

        parseJson();

        foodieGuide = (RecyclerView) findViewById(R.id.recyclerViewFoodieGuide);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        foodieGuide.setLayoutManager(linearLayoutManager);

        foodieGuideAdapter = new FoodieGuideAdapter(this, foodieGuideJsonData);
        foodieGuide.setAdapter(foodieGuideAdapter);
    }

    public class FoodieGuideJsonData {
        String name;
        String description;
        String address;
        String image;
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
        String jsonData = readTxt(R.raw.foodplaces);
        Log.i("Fish", jsonData);

        foodieGuideJsonData = gson.fromJson(jsonData, FoodieGuideJsonData[].class);
    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int verticalSpaceHeight;

        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;

            if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
                outRect.bottom = verticalSpaceHeight;
            }
        }

    }


}

