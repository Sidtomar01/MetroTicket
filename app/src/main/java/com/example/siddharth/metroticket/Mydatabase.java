package com.example.siddharth.metroticket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Siddharth on 30-09-2017.
 */

public class Mydatabase extends SQLiteOpenHelper {
    public static String MYDATABASE="mydata.db";
    public static int VERSION=1;

    public Mydatabase(Context context) {
        super(context, MYDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(UserRegister.table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
