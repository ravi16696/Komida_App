package com.project.ravi.projecct;

/**
 * Created by ravi on 03-Feb-18.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Foodmenulist extends RecyclerView.Adapter<Foodmenulist.MyViewHolder>{

    private final Context context;
    private final String[] web;
    private final Integer[] imageId;
    private final String[] web1;
    public Foodmenulist(Context context,
                String[] web,String web1[],Integer[] imageId) {
        this.context = context;
        this.web = web;
        this.web1=web1;
        this.imageId = imageId;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodmenu_list, parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(imageId[position]);
        holder.textView.setText(web[position]);
        holder.textView1.setText(web1[position]);
    }


    @Override
    public int getItemCount() {
        return web.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        TextView textView1;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView12);
            textView1 = (TextView) itemView.findViewById(R.id.textView13);
            imageView = (ImageView) itemView.findViewById(R.id.imageView6);

        }
    }
}
