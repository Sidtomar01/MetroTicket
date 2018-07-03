package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class TrainPass extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Spinner sp1,sp2;
    Button butt;
    ArrayAdapter<CharSequence> adap1,adap2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_pass);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
         t5= (TextView) findViewById(R.id.t5);
        sp1= (Spinner) findViewById(R.id.sp1);
        sp2= (Spinner) findViewById(R.id.sp2);


        butt= (Button) findViewById(R.id.bttn1);
        SharedPreferences sharedPreferences =getSharedPreferences("myprefrences",MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        final String name=    sharedPreferences.getString("name",null);
        t1.setText(name);




        adap2= ArrayAdapter.createFromResource(TrainPass.this,R.array.destination,android.R.layout.simple_spinner_item);
        adap2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adap2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Destination : "+parent.getItemAtPosition(position)+ "  is selected",Toast.LENGTH_LONG).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });











        adap1=ArrayAdapter.createFromResource(TrainPass.this,R.array.source,android.R.layout.simple_spinner_item);
        adap1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adap1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Source:   "+parent.getItemAtPosition(position)+"  is selected",Toast.LENGTH_LONG).show();




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });












        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrainPass.this,Payment_info.class);
                startActivity(intent);
                String source=sp1.getSelectedItem().toString();
                String destination=sp2.getSelectedItem().toString();
                String pass=" TRAVELLER HAVE A PASS";

                SharedPreferences sharedPreferences81=getSharedPreferences("myprefrences81",MODE_PRIVATE);
                SharedPreferences.Editor editor5=sharedPreferences81.edit();
                editor5.putString("sou",source);
                editor5.putString("des",destination);
                editor5.putString("name",name);
                editor5.putString("pass",pass);
                editor5.commit();





                Toast.makeText(TrainPass.this, "Pass valid", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void Select_Ticket(View view)
    {
        boolean checked=((RadioButton)view).isChecked();
       switch (view.getId())
       {
           case R.id.monthly:
               if(checked)
               {
                   float amount=2500;
                   String amt=String.valueOf(amount);

                   t5.setText(amt);
               }
               else
               {
                   t5.setEnabled(true);

               }
               break;

           case R.id.quaterly:
               if(checked)

               {
                   float amount=5000;
                   String amt=String.valueOf(amount);

                   t5.setText(amt);
               }
               else
               {
                   t5.setEnabled(true);
               }
               break;

           case R.id.yearly:
               if(checked)
               {
                   float amount=8000;
                   String amt=String.valueOf(amount);

                   t5.setText(amt);
               }
               else
               {
                   t5.setEnabled(true);
               }
               break;

       }
    }

}
