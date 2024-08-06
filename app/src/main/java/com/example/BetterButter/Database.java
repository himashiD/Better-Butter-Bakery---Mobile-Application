package com.example.BetterButter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table customer(fullname text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table admin(fullname text,email text,password text)";
        sqLiteDatabase.execSQL(qry2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Add any necessary logic for database schema changes during an upgrade
    }

    public void Csignup(String fullname, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("fullname", fullname);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("customer", null, cv);
        db.close();
    }

    public int Csignin(String email, String password) {
        int result = 0;
        String[] str = new String[]{email, password};
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from customer where email=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        c.close();  // Close the cursor to avoid potential resource leaks
        return result;
    }


    public void Fsignup(String fullname, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("fullname", fullname);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("admin", null, cv);
        db.close();
    }

    public int Fsignin(String email, String password) {
        int result = 0;
        String[] str = new String[]{email, password};
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from admin where email=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        c.close();  // Close the cursor to avoid potential resource leaks
        return result;
    }
}



