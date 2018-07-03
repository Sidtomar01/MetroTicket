package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Payment_info extends AppCompatActivity {
    TextView t1;
    Button bt1,bt2,bt3,bt4,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);
        t1= (TextView) findViewById(R.id.t1);
        bt1= (Button) findViewById(R.id.bt1);
        bt2= (Button) findViewById(R.id.bt2);
        bt3= (Button) findViewById(R.id.bt3);
        bt4= (Button) findViewById(R.id.bt4);

        SharedPreferences sharedPreferences81=getSharedPreferences("myprefrences81",MODE_PRIVATE);
        SharedPreferences.Editor editor5=sharedPreferences81.edit();

        String s=sharedPreferences81.getString("source",null);
        String d=sharedPreferences81.getString("destination",null);
        String da=sharedPreferences81.getString("pass",null);
        SharedPreferences sharedPreferences =getSharedPreferences("myprefrences",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String n= sharedPreferences.getString("name",null);


        bt1.setText(n);
        bt2.setText(s);
        bt3.setText(d);;
        bt4.setText(da);




    }
    public void Select_Ticket(View view)
    {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.monthly:
                if(checked)
                {
                    Intent intent=new Intent(Payment_info.this,Add_balance.class);

                    startActivity(intent);
                }

                break;

            case R.id.quaterly:
                if(checked)

                {
                    Intent intent=new Intent(Payment_info.this,Add_balance.class);
                    startActivity(intent);
                }

                break;

            case R.id.yearly:
                if(checked)
                {
                    Intent intent=new Intent(Payment_info.this,Netbanking.class);
                    startActivity(intent);
                }

                break;

        }
    }
}
