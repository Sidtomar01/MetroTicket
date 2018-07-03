package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button login,register;
    EditText editpassword,editusername;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register= (Button) findViewById(R.id.register);
        login= (Button) findViewById(R.id.login);



        editpassword=(EditText) findViewById(R.id.editpassword);
        editusername= (EditText) findViewById(R.id.editusername);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,registeration.class);
                startActivity(intent);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editusername.getText().toString();
                String passwd=editpassword.getText().toString();

                Mydatabase mydatabase=new Mydatabase(MainActivity.this);
                SQLiteDatabase sqLiteDatabase=mydatabase.getReadableDatabase();
                String WhereClause= UserRegister.email+"= '"+email+"' and "+ UserRegister.passwd+"= '"+passwd+"'";
                Cursor cursor = UserRegister.select(sqLiteDatabase, WhereClause);
                while(cursor.moveToNext())
                {
                    String origid=cursor.getString(0);
                    String name=cursor.getString(1);
                    String fname=cursor.getString(2);
                    String mname=cursor.getString(3);
                    String mobilenum=cursor.getString(4);
                    String e=cursor.getString(5);
                    String pass=cursor.getString(6);
                    String confpasswd=cursor.getString(7);
                    String amount=cursor.getString(8);


                    Intent intent=new Intent(MainActivity.this,DashInitialization.class);
                    SharedPreferences sharedPreferences =getSharedPreferences("myprefrences",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("name",name);
                    editor.putString("fname",fname);
                    editor.putString("mobilenum",mobilenum);
                    editor.putString("email",e);
                    editor.putString("amount",amount);
                    editor.putString("passwd",pass);
                    editor.commit();
                    startActivity(intent);


                }


            }
        });
    }


}