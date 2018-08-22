package com.project.ravi.projecct;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPass extends AppCompatActivity implements View.OnClickListener {
    EditText editUsername,editName,editAge;
    Button butPass;
    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        editUsername=(EditText) findViewById(R.id.editUserf);
        editName=(EditText) findViewById(R.id.editNamef);
        editAge=(EditText) findViewById(R.id.editAgef);
        butPass=(Button) findViewById(R.id.change_password);
        butPass.setOnClickListener(this);
        db=openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS account(name VARCHAR,age VARCHAR,username VARCHAR,pass VARCHAR,sex VARCHAR);");}
    public void onClick(View view)
    {
        if(editUsername.getText().toString().trim().length()==0||editAge.getText().toString().trim().length()==0||editName.getText().toString().trim().length()==0)
        {
            showMessage("Error","Enter All The Above Fields");
            return;
        }
        Cursor c=db.rawQuery("SELECT * FROM account WHERE username='"+editUsername.getText()+"' and name='"+editName.getText()+"'and age='"+editAge.getText()+"'",null);

        if(c.moveToFirst())
        {
            Intent i2=new Intent(ForgetPass.this,NewPass.class);
            startActivity(i2);
        }
        else
        {
            showMessage("Error","Invalid Details--Account Doesn't Exist--");
        }
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
