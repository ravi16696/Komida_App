package com.project.ravi.projecct;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Menuitem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuitem);
        Button button = (Button) findViewById(R.id.button2);
        RelativeLayout call = (RelativeLayout) findViewById(R.id.relativeLayout9);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.relativeLayout5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuitem.this, Foodmenu.class);
                startActivity(intent);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuitem.this, Rateitem.class);
                startActivity(intent);
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_SEND);
                a.setType("text/link");
                String shareBody = "Menu of the Food " +
                        "\n";
                String shareSub = "Restraunt id:112320";
                a.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                a.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(a, "Share Using"));
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "9830867851";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
               callIntent.setData(Uri.parse("tel:"+url));
                startActivity(callIntent);
                //Toast.makeText(Menuitem.this, "calling feature", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
