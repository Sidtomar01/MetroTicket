package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registeration extends AppCompatActivity {

    final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private
    EditText editname,editfname,editmname,editmobilenum,editemail,editpasswd,editconfpasswd,editamount;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;


    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);
        t6= (TextView) findViewById(R.id.t6);
        t7= (TextView) findViewById(R.id.t7);
        t8= (TextView) findViewById(R.id.t8);
        t9= (TextView) findViewById(R.id.t9);



        editname= (EditText) findViewById(R.id.editname);
        editfname= (EditText) findViewById(R.id.editfname);
        editmname= (EditText) findViewById(R.id.editmname);
        editmobilenum= (EditText) findViewById(R.id.editmobilenum);
        editemail= (EditText) findViewById(R.id.editemail);
        editpasswd= (EditText) findViewById(R.id.editpasswd);
        editconfpasswd= (EditText) findViewById(R.id.editconfpasswd);
        register= (Button) findViewById(R.id.register);
        editamount= (EditText) findViewById(R.id.editamount);






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editname.getText().toString();
                String fname=editfname.getText().toString();
                String mname=editmname.getText().toString();
                String mobilenum=editmobilenum.getText().toString();
                String email=editemail.getText().toString();
                String passwd=editpasswd.getText().toString();
                String confpasswd=editconfpasswd.getText().toString();
                String amount=editamount.getText().toString();





                if(name.equals("")||fname.equals("")||mname.equals("")
                        ||mobilenum.equals("")||email.equals("")
                        ||passwd.equals("")||confpasswd.equals("")||amount.equals("")) {
                    if (name.equals("")) {
                        editname.setError("ENTER NAME");
                    }
                    if (fname.equals("")) {
                        editfname.setError("ENTER  FATHER'S NAME");
                    }
                    if (mname.equals("")) {
                        editmname.setError("ENTER  MOTHER'S NAME");
                    }
                    if (mobilenum.equals("")) {
                        editmobilenum.setError("ENTER MOBILE NUMBER ");
                    }
                    if (email.equals("")) {
                        editemail.setError("ENTER EMAIL ACCOUNT");
                    }

                    if (passwd.equals("")) {
                        editpasswd.setError("ENTER PASSWORD");
                    }
                    if (confpasswd.equals("")) {
                        editconfpasswd.setError("ENTER CONFIRM PASSWORD");
                    }
                    if(amount.equals(""))
                    {
                        editamount.setError("ENTER AMOUNT");
                    }
                    Toast.makeText(registeration.this, "REGISTRATION UNSUCCESFULL ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(passwd.equals(confpasswd))

                    {

                        if(mobilenum.length()==10)
                        {

                            if(email.matches(EMAIL_PATTERN))
                            {

                                Mydatabase mydatabase=new Mydatabase(registeration.this);
                                SQLiteDatabase sqLiteDatabase=mydatabase.getWritableDatabase();
                                ContentValues cv=new ContentValues();
                                cv.put(UserRegister.name,name);
                                cv.put(UserRegister.fname,fname);
                                cv.put(UserRegister.mname,mname);
                                cv.put(UserRegister.fname,fname);
                                cv.put(UserRegister.mobilenum,mobilenum);
                                cv.put(UserRegister.email,email);
                                cv.put(UserRegister.passwd,passwd);
                                cv.put(UserRegister.amount,amount);


                           long id=UserRegister.insert(sqLiteDatabase,cv);
                                if(id>0) {


                                    Toast.makeText(registeration.this, "SUCCESSFULLY REGISTERED", Toast.LENGTH_SHORT).show();
                                    editname.setText(null);
                                    editfname.setText(null);
                                    editmname.setText(null);
                                    editmobilenum.setText(null);
                                    editpasswd.setText(null);
                                    editconfpasswd.setText(null);
                                    editemail.setText(null);
                                    editamount.setText(null);


                                    Intent intent = new Intent(registeration.this, MainActivity.class);
                                    startActivity(intent);


                                }

                            }
                            else
                            {


                                Toast.makeText(registeration.this, "PLEASE CHECK YOUR EMAIL ID", Toast.LENGTH_SHORT).show();
                            }


                        }

                        else
                        {

                            Toast.makeText(registeration.this, "PLEASE ENTER VALID MOBILE NUMBER", Toast.LENGTH_SHORT).show();
                            editmobilenum.setText(null);

                        }
                    }
                    else
                    {
                        Toast.makeText(registeration.this, "PLEASE CHECK YOUR PASSWORD", Toast.LENGTH_SHORT).show();
                        editconfpasswd.setText(null);
                        editpasswd.setError(null);
                        editpasswd.setText(null);

                    }



                }







            }



        });
    }


}


