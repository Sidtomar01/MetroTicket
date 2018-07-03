package com.example.siddharth.metroticket;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Fine extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    EditText e1,e2,e3,e4,e5,e6;
    Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);

        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);
        t6= (TextView) findViewById(R.id.t6);
        e1= (EditText) findViewById(R.id.e1);
        e2= (EditText) findViewById(R.id.e2);
        e3= (EditText) findViewById(R.id.e3);
        e4= (EditText) findViewById(R.id.e4);
        e5= (EditText) findViewById(R.id.e5);
        butt= (Button) findViewById(R.id.butt);
        Calendar calendar=Calendar.getInstance();

        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);
        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Fine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        e4.setText(dayOfMonth + "/" + (month+1) + "/" + year);


                    }
                }, year, month, day);

                datePickerDialog.show();



            }


        });



        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String source=e2.getText().toString();
                String destination=e3.getText().toString();
                String date=e4.getText().toString();
                String amount=e5.getText().toString();


                if(name.equals("")||source.equals("")||destination.equals("")||date.equals("")||amount.equals(""))
                {
                    if(name.equals(""))
                    {
                        e1.setError("Enter Name");

                    }
                    if(source.equals(""))
                    {

                        e2.setError("Enter Source Station");
                    }

                    if(destination.equals(""))
                    {
                        e3.setError("Enter Destination");
                    }
                    if (date.equals(""))
                    {
                        e4.setError("Enter Date");
                    }
                    if(amount.equals(""))
                    {

                        e5.setError("Enter the paybale amount");
                    }

                    Toast.makeText(Fine.this, "PLEASE FILL ALL THE DETAILS", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(Fine.this, "Fine imposed:-" +amount, Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Fine.this,Checking.class);
                    startActivity(intent);

                }
            }
        });




    }
}
