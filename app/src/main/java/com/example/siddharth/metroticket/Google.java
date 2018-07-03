package com.example.siddharth.metroticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Google extends AppCompatActivity {
    ListView listview;
    String[] names={"Vivek_vihar","Vivek_vihar","Vivek_vihar","Vivek_vihar","Vivek_vihar","Vivek_vihar","Sindhi_camp","Sindhi_camp",
            "Sindhi_camp","Sindhi_camp","Sindhi_amp","Mansarovar","Mansarovar","Mansarovar","Mansarovar","Railway_Station","Railway_Station",
            "Railway_Station","Badi_chaupar","Badi_chaupar","Civil_lines"};
    String[] id={"Sindhi_camp","Mansarovar","Railway_station","Badi_chaupar","Civil_lines","Ram_nagar","Mansarovar",
            "Railway_station","Badi_chaupar","Civil_lines","Ram_nagar", "Railway_station",
            "Badi_chaupar","Civil_lines","Ram_nagar","Badi_chaupar","Civil_lines","Ram_nagar",
            "Civil_lines","Ram_nagar", "Ram_nagar"};
    Integer[] imgid= {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        listview= (ListView) findViewById(R.id.listview);
        customlistview customlistview=new customlistview(Google.this,names,id,imgid);
        listview.setAdapter(customlistview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position , long k) {
              Intent intent =new Intent(Google.this,Display_ticket.class);
                SharedPreferences sharedPrefrences=getSharedPreferences("myprefrences1",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPrefrences.edit();
                editor.putString("names",names[position]);
                editor.putString("id",id[position]);
                editor.commit();
                startActivity(intent);




            }
        });

    }

    public  String[] getName() {


        return names;
    }
}
