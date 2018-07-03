package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.siddharth.metroticket.UserRegister.amount;
import static com.example.siddharth.metroticket.UserRegister.name;
import static com.example.siddharth.metroticket.UserRegister.origid;

public class Add_balance extends AppCompatActivity {
    EditText e1,e2,e31,e32,e4,e5;
    TextView t0,t1,t2,t3,t4,t5,t6;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        t0= (TextView) findViewById(R.id.t0);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);
        t6= (TextView) findViewById(R.id.t6);
        e1= (EditText) findViewById(R.id.e1);
        e2= (EditText) findViewById(R.id.e2);
        e31= (EditText) findViewById(R.id.e31);
        e32= (EditText) findViewById(R.id.e32);
        e4= (EditText) findViewById(R.id.e4);
        e5= (EditText) findViewById(R.id.e5);
        bt1= (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String crdnum=e1.getText().toString();
                String cvvnum=e2.getText().toString();
                String month=e31.getText().toString();
                String year=e32.getText().toString();

                String nam=e4.getText().toString();
                String amt=e5.getText().toString();
                SharedPreferences sharedPreferences =getSharedPreferences("myprefrences",MODE_PRIVATE);
                String name=sharedPreferences.getString("name",null);
                t4.setText(nam);

                if(crdnum.equals("")||cvvnum.equals("")||month.equals("")||name.equals("")||amt.equals("")||year.equals(""))
                {
                    if(crdnum.equals(""))
                    {
                        e1.setError("ENTER CARD NUMBER");
                    }
                    if(cvvnum.equals(""))
                    {
                        e2.setError("ENTER CVV NUMBER");
                    }
                    if(month.equals(""))
                    {

                        e31.setError("ENTER MONTH");

                    }
                    if(year.equals(""))
                    {
                        e32.setError("ENTER YEAR");
                    }
                    if(nam.equals(""))
                    {
                        e4.setError("ENTER CARDHOLDER NAME");


                    }
                    if(amt.equals(""))
                    {

                        e5.setError("ENTER AMOUNT");
                    }
                    Toast.makeText(Add_balance.this, "UNSUCCESFUL TRANSACTION", Toast.LENGTH_SHORT).show();





                }
                else
                {
                    if(crdnum.length()==16)
                    {
                        if(cvvnum.length()==3)
                        {
                            if(month.length()<=2)
                            {


                                if(year.length()<=4) {


                                    Intent intent=new Intent(Add_balance.this,Dashboard.class);

                                    Toast.makeText(Add_balance.this, "PAYMENT Successfull!!!", Toast.LENGTH_SHORT).show();

                                    startActivity(intent);






                                }
                                else
                                {
                                    Toast.makeText(Add_balance.this, "PLEASE ENTER VALID YEAR", Toast.LENGTH_SHORT).show();
                                }


                            }
                            else
                            {
                                Toast.makeText(Add_balance.this, "MONTH IS NOT CORRECT", Toast.LENGTH_SHORT).show();
                            }





                        }
                        else
                        {
                            Toast.makeText(Add_balance.this, "PLEASE CHECK CVV NUMBER", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {

                        Toast.makeText(Add_balance.this, "PLEASE CHECK 16 DIGIT CARD NUMBER ", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });




    }
}
