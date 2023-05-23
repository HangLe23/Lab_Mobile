package com.example.bai05;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class dishAdapter extends ArrayAdapter<dish> {
    private Activity context;
    private int LayoutID;

    public dishAdapter(Activity context, int LayoutID, List<dish>objects){
        super(context, LayoutID, objects);
        this.context=context;
        this.LayoutID= LayoutID;

    }
    @Override
    public View getView(final int position, View contextView, ViewGroup parent){
        if(contextView==null){
            contextView= LayoutInflater.from(context).inflate(LayoutID, null, false);
        }
        dish dish = getItem(position);

        //getView
        TextView tvname = contextView.findViewById(R.id.tvname);
        ImageView ivthumb = contextView.findViewById(R.id.ivthumbnail);
        ImageView ivpro = contextView.findViewById(R.id.ivpromotion);

        // show thumbnail
        if(dish.getThumbnail() != null){
            ivthumb.setImageResource(dish.getThumbnail().getImg());
        }
        //show name
        if(dish.getName() != null){
            tvname.setText(dish.getName());
            tvname.setHorizontallyScrolling(true);
            tvname.setSelected(true);
        }
        //show promotion
        if(dish.isPromotion()){
            ivpro.setVisibility(View.VISIBLE);
        } else {
            ivpro.setVisibility(View.GONE);
        }
        return contextView;
    }
}
