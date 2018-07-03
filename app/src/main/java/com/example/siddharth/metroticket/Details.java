package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import static com.example.siddharth.metroticket.UserRegister.name;

public class Details extends AppCompatActivity {
    TextView tx1,tx2,tx3,tx4,tx5;
    ImageView imageView;
    SelectImageHelper helper;
    static final int cam_request=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tx1= (TextView) findViewById(R.id.tx1);
        tx2= (TextView) findViewById(R.id.tx2);
        tx3= (TextView) findViewById(R.id.tx3);
        tx4= (TextView) findViewById(R.id.tx4);
        tx5= (TextView) findViewById(R.id.tx5);
        imageView= (ImageView) findViewById(R.id.imageView);

        helper = new SelectImageHelper(this, imageView);


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());

        SharedPreferences sharedPreferences=getSharedPreferences("myprefrences",MODE_PRIVATE);
        String n=sharedPreferences.getString("name",null);
        String fn=sharedPreferences.getString("fname",null);
        String mn=sharedPreferences.getString("mname",null);
        String mo=sharedPreferences.getString("mobilenum",null);
        String amount=sharedPreferences.getString("amount",null);
        String e=sharedPreferences.getString("e",null);
        String pass=sharedPreferences.getString("passwd",null);





            tx1.setText(n);
            tx2.setText(fn);
            tx3.setText(mo);
            tx4.setText(amount);
            tx5.setText(pass);














       /* SharedPreferences sharedPreferences6=getSharedPreferences("myprefrences6",MODE_PRIVATE);
        SharedPreferences .Editor editor1=sharedPreferences6.edit();
        String AMTLEFT=sharedPreferences6.getString("amtleft",null);
        tx4.setText(AMTLEFT);*/










        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.selectImageOption();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {

        Log.d("1234", "onActivityResult: "+result);
       String path="My Files/Images/temp1.jpg";
       // String storageDir = Environment.getExternalStorageDirectory().getAbsolutePath()+"/temp1.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, final @NonNull String[] permissions, final @NonNull int[] grantResults) {
        helper.handleGrantedPermisson(requestCode, grantResults);   // call this helper class method
    }


}
