package com.example.siddharth.metroticket;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    SelectImageHelper selectImageHelper;
    ImageView imageView;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        selectImageHelper = new SelectImageHelper(this, imageView);
        imageView = (ImageView) findViewById(R.id.image);

        String imageUrl = getIntent().getStringExtra("uri");

        Uri uri  = Uri.parse(imageUrl);

        imageView.setImageURI(uri);

    }
}
