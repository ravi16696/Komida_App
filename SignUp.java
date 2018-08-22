package com.project.ravi.projecct;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText editName, editAge, editUsername, editPass, editCpass;
    Button signup;
    RadioGroup radioGroup;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editName = (EditText) findViewById(R.id.editText);
        editAge = (EditText) findViewById(R.id.editText2);
        editUsername = (EditText) findViewById(R.id.editText3);
        editPass = (EditText) findViewById(R.id.editText4);
        editCpass = (EditText) findViewById(R.id.editText5);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        signup = (Button) findViewById(R.id.button4);
        signup.setOnClickListener(this);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        db = openOrCreateDatabase("AccountDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS account(name VARCHAR,age VARCHAR,username VARCHAR,pass VARCHAR,sex VARCHAR);");

    }

    public void onClick(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        if (editName.getText().toString().trim().length() == 0 ||

                editAge.getText().toString().trim().length() == 0 ||

                editUsername.getText().toString().trim().length() == 0
                || editPass.getText().toString().trim().length() == 0 ||
                editCpass.getText().toString().trim().length() == 0 ||
                selectedId == -1) {
            showMessage("Error", "Please enter all values");
            return;
        }
        if (editCpass.getText().toString().trim().length() != editPass.getText().toString().trim().length()) {
            showMessage("Error", "Password doesn't match!!");
            return;
        }
        Cursor c = db.rawQuery("SELECT * FROM account WHERE username='" + editUsername.getText() + "'", null);

        if (c.moveToFirst()) {
            showMessage("Error", "Username Already Exists");
        } else {
            db.execSQL("INSERT INTO account VALUES('" + editName.getText() + "','" + editAge.getText() + "','" + editUsername.getText() + "','" + editPass.getText() + "','" + radioButton.getText() + "');");
            Toast.makeText(this, "Account Creation Sucessfull", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);
        }
    }

    public void showMessage(String title, String message)

    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);

        builder.setMessage(message);

        builder.show();

    }

}