package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show_ticket extends AppCompatActivity {
    TextView t1;
    Button bt1,bt2,bt3,bt4,button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket);
        t1= (TextView) findViewById(R.id.t1);
        bt1= (Button) findViewById(R.id.bt1);
        bt2= (Button) findViewById(R.id.bt2);
        bt3= (Button) findViewById(R.id.bt3);
        bt4= (Button) findViewById(R.id.bt4);
        button11= (Button) findViewById(R.id.button11);



        SharedPreferences sharedPreferences4=getSharedPreferences("myprefrences4",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences4.edit();
       String n= sharedPreferences4.getString("name",null);
        String s=sharedPreferences4.getString("source",null);
        String d=sharedPreferences4.getString("destination",null);
        String da=sharedPreferences4.getString("Date",null);

        bt1.setText(n);
        bt2.setText(s);
        bt3.setText(d);;
        bt4.setText(da);




       /*SharedPreferences sharedPreferences8=getSharedPreferences("myprefrences8",MODE_PRIVATE);
        SharedPreferences.Editor editor5=sharedPreferences8.edit();
        String name=sharedPreferences8.getString("name",null);
        String so=sharedPreferences8.getString("source",null);
        String de=sharedPreferences8.getString("destination",null);
        String pass=sharedPreferences8.getString("pass",null);
        bt1.setText(name);
        bt2.setText(so);
        bt3.setText(d);
        bt4.setText(da);*/



        if(n.equals("")||s.equals("")||d.equals("")||da.equals(""))
            Toast.makeText(this, "IMPOSE FINE", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "USER IS VALID!! HE HAS BOOKED TICKET\n "+s+"-"+d, Toast.LENGTH_SHORT).show();





        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Show_ticket.this,  Checking.class);
                startActivity(intent);



            }
        });

    }
}
