package com.project.ravi.projecct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Foodmenu extends AppCompatActivity {
    String[] web = {
            "Paneer Masala",
            "Aalo Matar",
            "Veg Biryani",
            "Plain palak",
            "Veg Handi",
            "Veg Tarka",
            "Butter Paneer"
    };
    String[] web1 ={
            "Rs.100",
            "Rs.150",
            "Rs.90",
            "Rs.60",
            "Rs.120",
            "Rs.40",
            "Rs.100"

    };
    Integer[] imageId = {
            R.drawable.ic_menu,
            R.drawable.ic_menu,
            R.drawable.ic_menu,
            R.drawable.ic_menu,
            R.drawable.ic_menu,
            R.drawable.ic_menu,
            R.drawable.ic_menu

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView1) ;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Foodmenulist adapter=new Foodmenulist(Foodmenu.this,web,web1,imageId);
        recyclerView.setAdapter(adapter);

    }
}

