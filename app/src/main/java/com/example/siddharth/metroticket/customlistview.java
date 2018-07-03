package com.example.siddharth.metroticket;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

/**
 * Created by Siddharth on 30-09-2017.
 */

public class customlistview extends ArrayAdapter<String> {

    private  String[] names;
    private String[] id;

    private Integer[] imgid;
    private Activity context;






    public customlistview( Activity context,  String[] names,String[] id,Integer[] imgid) {
        super(context,R.layout.googleaccount,names);
        this.context=context;
        this.names=names;
        this.id=id;
        this.imgid=imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            r=layoutInflater.inflate(R.layout.googleaccount,null,true);

            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);


            String strings = names[position];
            Character first=Character.valueOf(strings.charAt(0));
            ColorGenerator generator=ColorGenerator.MATERIAL;
            int color=generator.getRandomColor();
            TextDrawable drawable= (TextDrawable) TextDrawable.builder().buildRound(String.valueOf(first),color);
            viewHolder.imageView1.setImageDrawable(drawable);









        }
        else {
            viewHolder = (ViewHolder) r.getTag ();
        }











        viewHolder.textView2.setText(names[position]);
        viewHolder.textView4.setText(id[position]);


        return r;
    }
    class ViewHolder {
        TextView textView4, textView2;
        ImageView imageView1;


        ViewHolder(View v) {

            textView2 = (TextView) v.findViewById(R.id.textView2_name);
            textView4 = (TextView) v.findViewById(R.id.textView4_id);
            imageView1 = (ImageView) v.findViewById(R.id.imageView);










        }
    }

}

