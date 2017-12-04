package com.example.fish.androidprojecttouristplanner;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 5/12/2017.
 */

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private CoffeeActivity.CoffeeJsonData[] data;
    private static int viewHolderCount = 0;
    Context parentContext;

    CoffeeAdapter(Context context, CoffeeActivity.CoffeeJsonData[] data) {
        this.parentContext = context;
        this.data = data;
    }

    @Override
    public CoffeeAdapter.CoffeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutIDForListItem = R.layout.coffee_viewholder;
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);

        CoffeeViewHolder coffeeViewHolder = new CoffeeViewHolder(view);

        viewHolderCount++;
        Log.i("Fish", "onCreateViewHolder called " + viewHolderCount + " times");
        return coffeeViewHolder;
    }

    @Override
    public void onBindViewHolder(CoffeeViewHolder holder, int position) {
        holder.bind(position);
        Log.i("Fish", "onBindViewHolder " + position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class CoffeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView coffeeName;

        CoffeeViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);

            coffeeName = (TextView) view.findViewById(R.id.coffeeName);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();

            AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);
            String description = data[clickedPosition].description;
            builder.setMessage("Description: " + description);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }

        public void bind(int position) {
            coffeeName.setText(data[position].name);
        }
    }

}
