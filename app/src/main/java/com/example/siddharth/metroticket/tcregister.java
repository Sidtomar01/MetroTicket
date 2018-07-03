package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.specials.out.TakingOffAnimator;

public class tcregister extends AppCompatActivity {
    ImageView imageView;
    EditText name,id_no,passwd,confpasswd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcregister);
        imageView= (ImageView) findViewById(R.id.imageView);

        name= (EditText) findViewById(R.id.name);
        id_no= (EditText) findViewById(R.id.id_no);
        passwd= (EditText) findViewById(R.id.passwd);
        confpasswd= (EditText) findViewById(R.id.confpasswd);
        btn= (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam=name.getText().toString();
                String id=id_no.getText().toString();
                String pass=passwd.getText().toString();
                String conpass=confpasswd.getText().toString();


                if(nam.equals("")||id.equals("")||pass.equals("")||conpass.equals(""))
                {
                    if(nam.equals(""))
                    {
                        name.setError("ENTER NAME");
                    }
                    if(id.equals(""))
                    {

                        id_no.setError("ENTER YOUR ID");
                    }
                    if(pass.equals(""))
                    {
                        passwd.setError("ENTER PASSWORD");
                    }
                    if(conpass.equals(""))
                    {
                        confpasswd.setError("ENTER CONFIRM PASSWORD");

                    }

                    Toast.makeText(tcregister.this, "UNSUCCESSFULL REGISTERATION", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(pass.equals(conpass))
                    {
                        if(id_no.length()>=4)
                        {



                            Mydatabase1 myDatabase1=new Mydatabase1(tcregister.this);
                            SQLiteDatabase sqlitedatabase=myDatabase1.getWritableDatabase();
                            ContentValues cv=new ContentValues();
                            cv.put(userregister1.name,nam);
                            cv.put(userregister1.id_no,id);
                            cv.put(userregister1.passwd,pass);
                            cv.put(userregister1.confpasswd,conpass);


                        long i =   userregister1.insert(sqlitedatabase,cv);
                            if (i>0)
                            {
                                Toast.makeText(tcregister.this, "REGISTERATION SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(tcregister.this,tclogin.class);
                                startActivity(intent);
                                name.setText(null);
                                id_no.setText(null);
                                passwd.setText(null);
                                confpasswd.setText(null);
                            }

                        }
                        else{
                            Toast.makeText(tcregister.this, "ID IS INVALID", Toast.LENGTH_SHORT).show();
                            id_no.setText(null);
                        }

                    }
                    else{

                        Toast.makeText(tcregister.this, "YOUR PASSWORD DOES NOT MATCH ", Toast.LENGTH_SHORT).show();
                        passwd.setText(null);
                        confpasswd.setText(null);

                    }


                }
            }
        });


    }
}
