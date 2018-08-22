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
import android.widget.Toast;

public class NewPass extends AppCompatActivity implements View.OnClickListener{
    EditText editPass,editCpass,editUsername;
    Button submit;
    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpass);
        editUsername=(EditText) findViewById(R.id.editUsern);
        editPass=(EditText) findViewById(R.id.editPassn);
        editCpass=(EditText) findViewById(R.id.editPassn1);
        submit=(Button) findViewById(R.id.submit1);
        submit.setOnClickListener(this);
        db=openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS account(name VARCHAR,age VARCHAR,username VARCHAR,pass VARCHAR,sex VARCHAR);");}
    public void onClick(View view)
    {
        if(editUsername.getText().toString().trim().length()==0||editPass.getText().toString().trim().length()==0||editCpass.getText().toString().trim().length()==0)
        {
            showMessage("Error","Enter All The Above Fields");
            return;
        }
        if( editCpass.getText().toString().trim().length()!= editPass.getText().toString().trim().length())
        {
            showMessage("Error","Password doesn't match!!");
            return;
        }
        Cursor c=db.rawQuery("SELECT * FROM account WHERE username='"+editUsername.getText()+"'",null);

        if(c.moveToFirst())
        {
            db.execSQL("UPDATE account SET pass='"+editPass.getText()+"' WHERE username='"+editUsername.getText()+"'");
            Toast.makeText(this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(NewPass.this,Login.class);
            startActivity(i);
        }
        else
        {
            showMessage("Error","Invalid Username");
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
