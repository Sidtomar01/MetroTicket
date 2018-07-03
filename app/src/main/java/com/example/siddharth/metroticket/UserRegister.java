package com.example.siddharth.metroticket;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Siddharth on 30-09-2017.
 */

public class UserRegister {
    public static String table="CREATE TABLE `user_login` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`fname`\tTEXT,\n" +
            "\t`mname`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`mobilenum`\tTEXT,\n" +
            "\t`passwd`\tTEXT,\n" +
            "\t`confpasswd`\tTEXT,\n" +
            "\t`amount`\tTEXT\n" +
            ");";
    public  static String origid="id";
    public  static String name="name";
    public static String fname="fname";
    public static String mname="mname";
    public static String mobilenum="mobilenum";
    public static String email="email";
    public static String passwd="passwd";
    public static String amount="amount";
    public static String user_login="user_login";


    public static long insert(SQLiteDatabase sqLiteDatabase, ContentValues cv) {

        return sqLiteDatabase.insert(user_login,null,cv);
    }

    public static Cursor select(SQLiteDatabase sqLiteDatabase, String whereClause) {
        return sqLiteDatabase.query(user_login, null, whereClause, null, null, null, null);
    }

    public static long update(SQLiteDatabase sqLiteDatabase, ContentValues cv, String whereclause) {

        return sqLiteDatabase.update(user_login,cv,whereclause,null);
    }
}