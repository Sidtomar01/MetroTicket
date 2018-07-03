package com.example.siddharth.metroticket;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Siddharth on 30-09-2017.
 */



public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources={R.drawable.m1,R.drawable.m3,R.drawable.m4,R.drawable.m5};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx=ctx;
    }




    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(image_resources[position]);
        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}

