package com.example.fish.androidprojecttouristplanner;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 4/12/2017.
 */

public class FoodieGuideAdapter {

    private StartFoodieGuideActivity.FoodPlacesJsonData[] data;
    private static int viewHolderCount = 0;
    Context parentContext;

    FoodieGuideAdapter(Context context, StartFoodieGuideActivity.FoodPlacesJsonData[] data) {
        this.parentContext = context;
        this.data = data;
    }

    public FoodieGuideAdapter.FoodieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutIDForListItem = R.layout.foodie_guide_viewholder;
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);

        FoodieViewHolder foodieViewHolder = new FoodieViewHolder(view);

        viewHolderCount ++;
        Log.i("Fish", "onCreateViewHolder called " + viewHolderCount + "times");
        return foodieViewHolder;
    }

    public void onBindViewHolder(FoodieViewHolder holder, int position) {
        holder.bind(position);
        Log.i("Fish", "onBindViewHolder " + position);
    }

    public int getItemCount() {
        return data.length;
    }


    class FoodieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView foodName;
        ImageView foodImage;

        FoodieViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);

            foodImage = (ImageView) view.findViewById(R.id.food_image);
            foodName = (TextView) view.findViewById(R.id.food_text);
        }

        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();

            AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);

            String foodName = data[clickedPosition].name;
            builder.setMessage("Food: " + foodName);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }

        public void bind(int position) {

            String filename = data[position].description;

            String packageName = parentContext.getPackageName();
            String typeOfResource = "mipmap";

            int resID = parentContext.getResources().getIdentifier(filename, typeOfResource, packageName);

            foodImage.setImageResource(resID);

            foodName.setText(data[position].name);
        }

    }


}
