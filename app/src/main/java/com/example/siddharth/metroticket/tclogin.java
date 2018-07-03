package com.example.siddharth.metroticket;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tclogin extends AppCompatActivity {

    Button login,register;
    EditText password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tclogin);
        password= (EditText) findViewById(R.id.password);
        username= (EditText) findViewById(R.id.username);
        login= (Button) findViewById(R.id.login);
        register= (Button) findViewById(R.id.register);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tclogin.this,tcregister.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String passwd=password.getText().toString();



               Mydatabase1 mydatabase1=new Mydatabase1(tclogin.this);
                SQLiteDatabase sqlitedatabase=mydatabase1.getReadableDatabase();
                String WhereClause= userregister1.name+"= '"+user+"' and "+ userregister1.passwd+"= '"+passwd+"'";
                Cursor cursor=userregister1.select(sqlitedatabase,WhereClause);


                while(cursor.moveToNext())
                {

                    String n=cursor.getString(1);
                    String i=cursor.getString(2);
                    String p=cursor.getString(3);
                    String cp=cursor.getString(4);
                    Intent intent=new Intent(tclogin.this,Checking.class);
                    startActivity(intent);

                }







            }
        });


    }
}
