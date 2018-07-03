package com.example.siddharth.metroticket;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Display_ticket extends AppCompatActivity {
    TextView txt1,txt4,bt2;
    Button btn;
    Spinner spn1,spn2;
    ArrayAdapter<CharSequence> adapter1,adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ticket);
        txt1= (TextView) findViewById(R.id.txt1);
        spn1= (Spinner) findViewById(R.id.spinner1);
        spn2= (Spinner) findViewById(R.id.spinner2);
        txt4= (TextView) findViewById(R.id.txt4);
        bt2= (TextView) findViewById(R.id.bt2);
        btn= (Button) findViewById(R.id.btn);

        Calendar calendar=Calendar.getInstance();

        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);
        adapter2=ArrayAdapter.createFromResource(this,R.array.destination,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn2.setAdapter(adapter2);
        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Destination : "+parent.getItemAtPosition(position)+ "  is selected",Toast.LENGTH_LONG).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter1=ArrayAdapter.createFromResource(this,R.array.source,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn1.setAdapter(adapter1);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Source:   "+parent.getItemAtPosition(position)+"  is selected",Toast.LENGTH_LONG).show();




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });





        SharedPreferences sharedPreferences = getSharedPreferences("myprefrences", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        txt1.setText(name);
        SharedPreferences sharedPreferences1 = getSharedPreferences("myprefrences1", MODE_PRIVATE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= txt1.getText().toString();
                String source=spn1.getSelectedItem().toString();
                String destination=spn2.getSelectedItem().toString();
                String amt2= txt4.getText().toString();
                String Date=bt2.getText().toString();
                SharedPreferences sharedPreferences5=getSharedPreferences("myprefrences5",MODE_PRIVATE);
                SharedPreferences.Editor editor5=sharedPreferences5.edit();
                editor5.putString("amt2",amt2);
                editor5.commit();
                SharedPreferences sharedPreferences4=getSharedPreferences("myprefrences4",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences4.edit();
                editor.putString("name",name);
                editor.putString("source",source);
                editor.putString("destination",destination);
                editor.putString("Date",Date);
                editor.commit();







                    Intent intent=new Intent(Display_ticket.this,Deciderpaymrnt.class);

                Toast.makeText(Display_ticket.this, "Ticket booked\n"+source+"-"+destination, Toast.LENGTH_SHORT).show();



               /* NotificationCompat.Builder builder=new NotificationCompat.Builder(Display_ticket.this);
                builder.setContentTitle("BOOKING STATUS");
                builder.setContentText("TICKET HAS BEEN BOOKED");
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
                builder.setSmallIcon(R.mipmap.ic_launcher);*/




                    startActivity(intent);


















            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Display_ticket.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        bt2.setText(dayOfMonth + "/" + (month+1) + "/" + year);


                    }
                }, year, month, day);

                datePickerDialog.show();



            }


        });

    }
}
