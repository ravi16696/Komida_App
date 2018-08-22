package com.project.ravi.projecct;

/**
 * Created by ravi on 31-Jan-18.
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

public class List extends RecyclerView.Adapter<List.MyViewHolder>{

    private final Context context;
    private final String[] web;
    private final Integer[] imageId;
    public List(Context context,
                String[] web,Integer[] imageId) {
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.imageView.setImageResource(imageId[position]);
       holder.textView.setText(web[position]);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,Menuitem.class);
               context.startActivity(intent);
           }
       });
    }


    @Override
    public int getItemCount() {
        return web.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView3);
            imageView = (ImageView) itemView.findViewById(R.id.imageView3);

        }
    }
}
