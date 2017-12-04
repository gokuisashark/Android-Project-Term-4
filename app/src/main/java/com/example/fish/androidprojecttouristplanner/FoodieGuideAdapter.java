package com.example.fish.androidprojecttouristplanner;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 4/12/2017.
 */

public class FoodieGuideAdapter extends RecyclerView.Adapter<FoodieGuideAdapter.FoodieViewHolder> {

    private StartFoodieGuideActivity.FoodieGuideJsonData[] data;
    private static int viewHolderCount = 0;
    Context parentContext;

    FoodieGuideAdapter(Context context, StartFoodieGuideActivity.FoodieGuideJsonData[] data) {
        this.parentContext = context;
        this.data = data;
    }

    @Override
    public FoodieGuideAdapter.FoodieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIDForListItem = R.layout.foodie_guide_viewholder;
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);

        FoodieViewHolder foodieViewHolder = new FoodieViewHolder(view);

        viewHolderCount++;
        Log.i("Fish", "onCreateViewHolder called " + viewHolderCount + "times");
        return foodieViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodieViewHolder holder, int position) {
        holder.bind(position);
        Log.i("Fish", "onBindViewHolder" + position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class FoodieViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        TextView foodDesc;
        TextView foodAddr;
        ImageView foodImage;

        FoodieViewHolder(View view) {
            super(view);
        }

        public void bind(int position) {
            String filename = data[position].name;
            String packageName = parentContext.getPackageName();
            String typeOfResource = "mipmap";

            int resID = parentContext.getResources().getIdentifier(filename, typeOfResource, packageName);

            foodImage.setImageResource(resID);
            foodName.setText(data[position].name);
            foodDesc.setText(data[position].description);
            foodAddr.setText(data[position].address);

        }

    }

}