package com.example.siddharth.metroticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Netbanking extends AppCompatActivity {
    TextView t1,t2;
    Spinner spn1;
    EditText username,pass,amount;
    Button bt1;
    ArrayAdapter<CharSequence> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbanking);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        spn1= (Spinner) findViewById(R.id.spinner1);
        username= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.pass);
        amount= (EditText) findViewById(R.id.amount);
        bt1= (Button) findViewById(R.id.bt1);

        adapter1=ArrayAdapter.createFromResource(this,R.array.bank_names,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn1.setAdapter(adapter1);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Bank:   "+parent.getItemAtPosition(position)+"  is selected",Toast.LENGTH_LONG).show();




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String amt=amount.getText().toString();
                String p=pass.getText().toString();


                if (uname.equals("")||amt.equals("")||amt.equals(""))
                {
                    if (uname.equals(""))
                    {
                        username.setError("ENTER YOUR BANK ID");
                    }
                    if (p.equals(""))
                    {
                        pass.setError("ENTER YOUR BANK PASSWORD");
                    }
                    if (amt.equals(""))
                    {
                        amount.setError("AMOUNT TO BE PAID");
                    }
                    Toast.makeText(Netbanking.this, "TRANSCATION UNSUCCESSFULL!!!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Netbanking.this,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(Netbanking.this, "TRANSCATION SUCCESSFULL!!!!\n" +
                            "TICKET BOOKED", Toast.LENGTH_SHORT).show();


                }

            }
        });

    }
}
