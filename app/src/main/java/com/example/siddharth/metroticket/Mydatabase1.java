package com.example.siddharth.metroticket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Siddharth on 01-10-2017.
 */

public class Mydatabase1 extends SQLiteOpenHelper {
    public static String MYDATABASE="mydatab.db";
    public static int   VERSION=1;


    public Mydatabase1(Context context) {
        super(context, MYDATABASE,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userregister1.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
