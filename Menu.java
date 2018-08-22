package com.project.ravi.projecct;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by ravi on 31-Jan-18.
 */

public class Menu extends AppCompatActivity {
    String[] web = {
            "punjabi dhaba",
            "food court",
            "Arsanal",
            "Shimla biryani",
            "Subway",
            "Dominos",
            "KFC"
    };
    Integer[] imageId = {
            R.drawable.food_back2,
            R.drawable.food_back4,
            R.drawable.food_back8,
            R.drawable.food_back6,
            R.drawable.food_back7,
            R.drawable.food_back8,
            R.drawable.food_back9

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView) ;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        List adapter=new List(Menu.this,web,imageId);
        recyclerView.setAdapter(adapter);

    }
}
