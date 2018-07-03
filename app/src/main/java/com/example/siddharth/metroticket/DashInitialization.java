package com.example.siddharth.metroticket;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class DashInitialization extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.hide();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //BACKGROUND ANIMATION

        configSplash.setBackgroundColor(R.color.sid1);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);

        //logo

        configSplash.setLogoSplash(R.drawable.logo2);
        configSplash.setAnimLogoSplashDuration(5000);
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce);

        //title



        configSplash.setTitleSplash("OPENING DASHBORD....");
        configSplash.setTitleTextColor(R.color.colorPrimary);
        configSplash.setTitleTextSize(20f);
        configSplash.setAnimTitleDuration(4000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);




    }

    @Override
    public void animationsFinished() {
       Intent intent=new Intent(DashInitialization.this,Dashboard.class);
        startActivity(intent);

    }
}
