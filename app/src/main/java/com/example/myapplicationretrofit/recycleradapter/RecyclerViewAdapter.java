package com.example.myapplicationretrofit.recycleradapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.myapplicationretrofit.MainActivity;
import com.example.myapplicationretrofit.R;
import com.example.myapplicationretrofit.pojo.ExampleFinal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AdapterViewHolder> {

    Context context;
    List<ExampleFinal.Restaurant> restaurants;

    public RecyclerViewAdapter(MainActivity mainActivity, List<ExampleFinal.Restaurant> restaurantList) {

        context=mainActivity;
        restaurants=restaurantList;
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {

            adapterViewHolder.restaurant_txt_name.setText(""+restaurants.get(i).getName());
            adapterViewHolder.restaurant_txt_cat.setText(""+restaurants.get(i).getCategory());

       /* Glide.with(context)
                .load(restaurants.get(i).getBackgroundImageURL())
                .into(adapterViewHolder.img_restaurant);*/


        Picasso.with(context).load(restaurants.get(i).getBackgroundImageURL()).into(adapterViewHolder.img_restaurant);



    }

    @Override
    public int getItemCount() {
        return this.restaurants.size();
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

            ImageView img_restaurant;
            TextView restaurant_txt_name,restaurant_txt_cat;


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            img_restaurant = itemView.findViewById(R.id.img_restaurant);
            restaurant_txt_name= itemView.findViewById(R.id.restaurant_txt_name);
            restaurant_txt_cat = itemView.findViewById(R.id.restaurant_txt_cat);



        }
    }

}
