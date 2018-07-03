package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Siddharth on 01-10-2017.
 */

public class userregister1
{
   public static String CREATE_TABLE="CREATE TABLE `tc_register` (\n" +
           "\t`sno`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
           "\t`name`\tTEXT,\n" +
           "\t`id_no`\tTEXT,\n" +
           "\t`passwd`\tTEXT,\n" +
           "\t`confpasswd`\tTEXT\n" +
           ");";

    public  static  String name="name";
    public  static  String id_no="id_no";
    public static  String passwd="passwd";
    public static String confpasswd="confpasswd";
    public static String tc_register="tc_register";


    public static long insert(SQLiteDatabase sqlitedatabase, ContentValues cv) {
        return sqlitedatabase.insert(tc_register,null,cv);
    }


    public static Cursor select(SQLiteDatabase sqlitedatabase, String WhereClause) {
        return sqlitedatabase.query(tc_register,null,WhereClause,null,null,null,null);
    }
}
