package com.project.ravi.projecct;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText editUsername,editPass;
    Button butForget,butSignin,butSignup;
    SQLiteDatabase db;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "mypref";
    public static final String Username = "nameKey";
    public static final String Password = "emailKey";
    public static int f=0;
    public static String users="";
    public static String names;
    public static String ages;
    public static String sexs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUsername=(EditText) findViewById(R.id.loginuser);
        editPass=(EditText) findViewById(R.id.loginpass);
        butForget=(Button) findViewById(R.id.loginforget);
        butSignin=(Button) findViewById(R.id.loginsignin);
        butSignup=(Button) findViewById(R.id.loginsignup);
        butForget.setOnClickListener(this);
        butSignin.setOnClickListener(this);
        butSignup.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Username)) {
            editUsername.setText(sharedPreferences.getString(Username, ""));
        }
        if (sharedPreferences.contains(Password)) {
            editPass.setText(sharedPreferences.getString(Password, ""));

        }
        db=openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS account(name VARCHAR,age VARCHAR,username VARCHAR,pass VARCHAR,sex VARCHAR);");}
    @Override
  /* public void onBackPressed() {

        Intent i1=new Intent(Login.this,MainActivity.class);
        startActivity(i1);
    }*/

    public void onClick(View view)
    {
        if(view==butForget)
        {
            Intent intent=new Intent(Login.this,ForgetPass.class);
            startActivity(intent);
        }
        if(view==butSignup)
        {
            Intent i=new Intent(Login.this,SignUp.class);
            startActivity(i);
        }
        if(view==butSignin)
        {
            if(editUsername.getText().toString().trim().length()==0||editPass.getText().toString().trim().length()==0)
            {
                showMessage("Error","Enter Both Username And Password");
                users="";
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM account WHERE username='"+editUsername.getText()+"' and pass='"+editPass.getText()+"'",null);

            if(c.moveToFirst())
            {

                f=1;
                String n = editUsername.getText().toString();
                String e = editPass.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Username, n);
                editor.putString(Password, e);
                editor.commit();
                //String s=editUsername.getText().toString().trim();
                users = c.getString(2);
                names = c.getString(0);
                ages = c.getString(1);
                sexs = c.getString(4);
                addNotification();

                Intent i2=new Intent(Login.this,MainActivity.class);
                //i2.putExtra("username",s);
               startActivity(i2);

            }
            else
            {
                showMessage("Error","Invalid Username or Password");
                users="";
            }
        }

    }
    private void addNotification() {
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.k_logo)
                .setContentTitle("KOMIDA")
                .setContentText("Thanks For Signing In");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
    public void showMessage(String title,String message)

    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);

        builder.setMessage(message);
        builder.show();

    }
}


