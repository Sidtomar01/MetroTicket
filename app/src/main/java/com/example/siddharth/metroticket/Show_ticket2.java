package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show_ticket2 extends AppCompatActivity {
    TextView t1;
    Button bt11,bt21,bt31,bt41,button11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket2);
        t1= (TextView) findViewById(R.id.t1);
        bt11= (Button) findViewById(R.id.bt11);
        bt21= (Button) findViewById(R.id.bt21);
        bt31= (Button) findViewById(R.id.bt31);
        bt41= (Button) findViewById(R.id.bt41);
        button11= (Button) findViewById(R.id.button11);


        SharedPreferences sharedPreferences81=getSharedPreferences("myprefrences81",MODE_PRIVATE);
        SharedPreferences.Editor editor5=sharedPreferences81.edit();
        String n= sharedPreferences81.getString("name",null);
        String s1=sharedPreferences81.getString("sou",null);
        String d1=sharedPreferences81.getString("des",null);
        String da1=sharedPreferences81.getString("pass",null);
        SharedPreferences sharedPreferences =getSharedPreferences("myprefrences",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();


        bt11.setText(n);
        bt21.setText(s1);
        bt31.setText(d1);;
        bt41.setText(da1);


            Toast.makeText(this, "USER IS VALID!! HE HAS BOOKED TICKET\n "+s1+"-"+d1, Toast.LENGTH_SHORT).show();





        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Show_ticket2.this,  Checking.class);
                startActivity(intent);



            }
        });
    }
}
