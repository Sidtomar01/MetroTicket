package com.example.siddharth.metroticket;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Checking extends AppCompatActivity {
    TextView textview;
    EditText edittext,edittext1;
    Button button1,button2,button3,button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        textview= (TextView) findViewById(R.id.textview);
        edittext= (EditText) findViewById(R.id.edittext);
        edittext1= (EditText) findViewById(R.id.edittext1);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String text=edittext.getText().toString();
                Mydatabase mydatabase=new Mydatabase(Checking.this);
                SQLiteDatabase sqLiteDatabase=mydatabase.getReadableDatabase();
                String WhereClause= UserRegister.email+"= '"+text+"'";
                Cursor cursor = UserRegister.select(sqLiteDatabase, WhereClause);
                while(cursor.moveToNext()) {
                    Intent intent = new Intent(Checking.this, Show_ticket.class);

                    String name = cursor.getString(1);
                    String fname = cursor.getString(2);
                    String mname = cursor.getString(3);
                    String mobilenum = cursor.getString(4);
                    String e = cursor.getString(5);
                    String pass = cursor.getString(6);
                    String confpasswd = cursor.getString(7);
                    String amount = cursor.getString(8);

                    startActivity(intent);
                }

            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String text=edittext1.getText().toString();
                Mydatabase mydatabase=new Mydatabase(Checking.this);
                SQLiteDatabase sqLiteDatabase=mydatabase.getReadableDatabase();
                String WhereClause= UserRegister.email+"= '"+text+"'";
                Cursor cursor = UserRegister.select(sqLiteDatabase, WhereClause);
                while(cursor.moveToNext()) {
                    Intent intent = new Intent(Checking.this, Show_ticket2.class);

                    String name = cursor.getString(1);
                    String fname = cursor.getString(2);
                    String mname = cursor.getString(3);
                    String mobilenum = cursor.getString(4);
                    String e = cursor.getString(5);
                    String pass = cursor.getString(6);
                    String confpasswd = cursor.getString(7);
                    String amount = cursor.getString(8);

                    startActivity(intent);
                }
            }
        });








        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Checking.this,Fine.class);
                startActivity(intent);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Checking.this,Fine.class);
                startActivity(intent);

            }
        });

    }
}
