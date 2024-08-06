package com.example.BetterButter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database name
    private static final String DATABASE_NAME = "Sweetcake_db";
    //Table Table name
    private static final String TABLE_NAME = "classiccake";
    //Table Columns
    private static final String ID = "id";
    private static final String cakename = "cakename";
    private static final String cakeid = "cakeid";
    private static final String cakeweight = "cakeweight";
    private static final String cakecolors = "cakecolors";
    private static final String cakenote = "cakenote";
    private static final String cakeprice = "cakeprice";
    private static final String cakeqty = "cakeqty";
    private static final String created_at = "created_at";


    //Table birthday
    private static final String TABLE_NAME1 = "birthdaycake";
    //Table Columns
    private static final String BID = "bid";
    private static final String bcakename = "bcakename";
    private static final String bcakeid = "bcakeid";
    private static final String bcakeweight = "cakeweight";
    private static final String bcakecolors = "bcakecolors";
    private static final String bcakenote = "bcakenote";
    private static final String bcakeprice = "bcakeprice";
    private static final String bcakeqty = "bcakeqty";
    private static final String bcreated_at = "bcreated_at";


    //Table Wedding
    private static final String TABLE_NAME2 = "weddingcake";
    //Table Columns
    private static final String WID = "wid";
    private static final String wcakename = "wcakename";
    private static final String wcakeid = "wcakeid";
    private static final String wcakeweight = "wcakeweight";
    private static final String wcakecolors = "wcakecolors";
    private static final String wcakenote = "wcakenote";
    private static final String wcakeprice = "wcakeprice";
    private static final String wcakeqty = "wcakeqty";
    private static final String wcreated_at = "wcreated_at";



    //Table Anniversary
    private static final String TABLE_NAME3 = "anniversary";
    //Table Columns
    private static final String AID = "aid";
    private static final String acakename = "acakename";
    private static final String acakeid = "acakeid";
    private static final String acakeweight = "acakeweight";
    private static final String acakecolors = "acakecolors";
    private static final String acakenote = "acakenote";
    private static final String acakeprice = "acakeprice";
    private static final String acakeqty = "acakeqty";
    private static final String acreated_at = "acreated_at";




    //Table Newbaby
    private static final String TABLE_NAME4 = "newbaby";
    //Table Columns
    private static final String NID = "nid";
    private static final String ncakename = "ncakename";
    private static final String ncakeid = "ncakeid";
    private static final String ncakeweight = "ncakeweight";
    private static final String ncakecolors = "ncakecolors";
    private static final String ncakenote = "ncakenote";
    private static final String ncakeprice = "ncakeprice";
    private static final String ncakeqty = "ncakeqty";
    private static final String ncreated_at = "ncreated_at";




    //Table other
    private static final String TABLE_NAME5 = "other";
    //Table Columns
    private static final String OID = "oid";
    private static final String ocakename = "ocakename";
    private static final String ocakeid = "ocakeid";
    private static final String ocakeweight = "ocakeweight";
    private static final String ocakecolors = "ocakecolors";
    private static final String ocakenote = "ocakenote";
    private static final String ocakeprice = "ocakeprice";
    private static final String ocakeqty = "ocakeqty";
    private static final String ocreated_at = "ocreated_at";




    //Table order
    private static final String TABLE_NAME6 = "orderproduct";
    //Table Columns
    private static final String ORID = "orid";
    private static final String orproductname = "orproductname";
    private static final String orproductid = "orproductid";
    private static final String orproductflavour = "orproductflavour";
    private static final String orproductqty = "orproductqty";
    private static final String orcusname = "orcusname";
    private static final String orcuscontact = "orcuscontact";
    private static final String orstatus = "orstatus";
    private static final String orcreated_at = "orcreated_at";


    //Feedback
    private static final String TABLE_NAME7 = "feedback";
    //Table Columns
    private static final String FID = "fid";
    private static final String feedusername = "feedusername";
    private static final String feednotes = "feednotes";
    private static final String feedstatus = "feedstatus";
    private static final String created_atf = "created_atf";





    //creating table query
    public DatabaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_query = "CREATE TABLE if not EXISTS " + TABLE_NAME +
                "(" +
                ID + " INTEGER PRIMARY KEY ," +
                cakename + " TEXT ," +
                cakeid + " TEXT ," +
                cakeweight + " TEXT ," +
                cakecolors + " TEXT ," +
                cakenote + " TEXT ," +
                cakeprice + " TEXT ," +
                cakeqty + " TEXT ," +
                created_at + " TEXT " +
                ")";

        db.execSQL(table_query);


        String birthday_query = "CREATE TABLE if not EXISTS " + TABLE_NAME1 +
                "(" +
                BID + " INTEGER PRIMARY KEY ," +
                bcakename + " TEXT ," +
                bcakeid + " TEXT ," +
                bcakeweight + " TEXT ," +
                bcakecolors + " TEXT ," +
                bcakenote + " TEXT ," +
                bcakeprice + " TEXT ," +
                bcakeqty + " TEXT ," +
                bcreated_at + " TEXT " +
                ")";

        db.execSQL(birthday_query);


        String wedding_query = "CREATE TABLE if not EXISTS " + TABLE_NAME2 +
                "(" +
                WID + " INTEGER PRIMARY KEY ," +
                wcakename + " TEXT ," +
                wcakeid + " TEXT ," +
                wcakeweight + " TEXT ," +
                wcakecolors + " TEXT ," +
                wcakenote + " TEXT ," +
                wcakeprice + " TEXT ," +
                wcakeqty + " TEXT ," +
                wcreated_at + " TEXT " +
                ")";

        db.execSQL(wedding_query);


        String anniversary_query = "CREATE TABLE if not EXISTS " + TABLE_NAME3 +
                "(" +
                AID + " INTEGER PRIMARY KEY ," +
                acakename + " TEXT ," +
                acakeid + " TEXT ," +
                acakeweight + " TEXT ," +
                acakecolors + " TEXT ," +
                acakenote + " TEXT ," +
                acakeprice + " TEXT ," +
                acakeqty + " TEXT ," +
                acreated_at + " TEXT " +
                ")";

        db.execSQL(anniversary_query);


        String newbaby_query = "CREATE TABLE if not EXISTS " + TABLE_NAME4 +
                "(" +
                NID + " INTEGER PRIMARY KEY ," +
                ncakename + " TEXT ," +
                ncakeid + " TEXT ," +
                ncakeweight + " TEXT ," +
                ncakecolors + " TEXT ," +
                ncakenote + " TEXT ," +
                ncakeprice + " TEXT ," +
                ncakeqty + " TEXT ," +
                ncreated_at + " TEXT " +
                ")";

        db.execSQL(newbaby_query);


        String other_query = "CREATE TABLE if not EXISTS " + TABLE_NAME5 +
                "(" +
                OID + " INTEGER PRIMARY KEY ," +
                ocakename + " TEXT ," +
                ocakeid + " TEXT ," +
                ocakeweight + " TEXT ," +
                ocakecolors + " TEXT ," +
                ocakenote + " TEXT ," +
                ocakeprice + " TEXT ," +
                ocakeqty + " TEXT ," +
                ocreated_at + " TEXT " +
                ")";

        db.execSQL(other_query);


        String order_query = "CREATE TABLE if not EXISTS " + TABLE_NAME6 +
                "(" +
                ORID + " INTEGER PRIMARY KEY ," +
                orproductname + " TEXT ," +
                orproductid + " TEXT ," +
                orproductflavour + " TEXT ," +
                orproductqty + " TEXT ," +
                orcusname + " TEXT ," +
                orcuscontact + " TEXT ," +
                orstatus + " TEXT ," +
                orcreated_at + " TEXT " +
                ")";

        db.execSQL(order_query);


        String feedtable_query = "CREATE TABLE if not EXISTS " + TABLE_NAME7 +
                "(" +
                FID + " INTEGER PRIMARY KEY ," +
                feedusername + " TEXT ," +
                feednotes + " TEXT ," +
                feedstatus + " TEXT ," +
                created_atf + " TEXT " +
                ")";

        db.execSQL(feedtable_query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME7);

    }


    public void addclassic(Classiccupcakesclass classiccupcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(cakename, classiccupcakesclass.getCakename());
        contentValues.put(cakeid, classiccupcakesclass.getCakeid());
        contentValues.put(cakeweight, classiccupcakesclass.getCakeweight());
        contentValues.put(cakecolors, classiccupcakesclass.getCakecolors());
        contentValues.put(cakenote, classiccupcakesclass.getCakenote());
        contentValues.put(cakeprice, classiccupcakesclass.getCakeprice());
        contentValues.put(cakeqty, classiccupcakesclass.getCakeqty());
        contentValues.put(created_at, classiccupcakesclass.getCreated_at());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public Classiccupcakesclass getclassic(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID, cakename, cakeid, cakeweight, cakecolors, cakenote, cakeprice, cakeqty, created_at}, ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Classiccupcakesclass classiccupcakesclass = new Classiccupcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return classiccupcakesclass;
    }

    public List<Classiccupcakesclass> getAllclassic() {
        List<Classiccupcakesclass> classiccupcakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Classiccupcakesclass classiccupcakesclass = new Classiccupcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                classiccupcakesclassList.add(classiccupcakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return classiccupcakesclassList;
    }

    public int updateclassic(Classiccupcakesclass classiccupcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cakename, classiccupcakesclass.getCakename());
        contentValues.put(cakeid, classiccupcakesclass.getCakeid());
        contentValues.put(cakeweight, classiccupcakesclass.getCakeweight());
        contentValues.put(cakecolors, classiccupcakesclass.getCakecolors());
        contentValues.put(cakenote, classiccupcakesclass.getCakenote());
        contentValues.put(cakeprice, classiccupcakesclass.getCakeprice());
        contentValues.put(cakeqty, classiccupcakesclass.getCakeqty());
        return db.update(TABLE_NAME, contentValues, ID + "=?", new String[]{String.valueOf(classiccupcakesclass.getId())});
    }

    public void deleteclassic(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + "=?", new String[]{id});
        db.close();
    }

    public int getTotal() {
        String query = "SELECT * from " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }


    //birthday
    public void addbirthday(Birthdaycakesclass birthdaycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(bcakename, birthdaycakesclass.getBcakename());
        contentValues.put(bcakeid, birthdaycakesclass.getBcakeid());
        contentValues.put(bcakeweight, birthdaycakesclass.getBcakeweight());
        contentValues.put(bcakecolors, birthdaycakesclass.getBcakecolors());
        contentValues.put(bcakenote, birthdaycakesclass.getBcakenote());
        contentValues.put(bcakeprice, birthdaycakesclass.getBcakeprice());
        contentValues.put(bcakeqty, birthdaycakesclass.getBcakeqty());
        contentValues.put(bcreated_at, birthdaycakesclass.getBCreated_at());
        db.insert(TABLE_NAME1, null, contentValues);
        db.close();
    }

    public Birthdaycakesclass getbirthday(int bid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME1, new String[]{BID, bcakename, bcakeid, bcakeweight, bcakecolors, bcakenote, bcakeprice, bcakeqty, bcreated_at}, BID + " = ?", new String[]{String.valueOf(bid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Birthdaycakesclass birthdaycakesclass = new Birthdaycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return birthdaycakesclass;
    }

    public List<Birthdaycakesclass> getAllbirthday() {
        List<Birthdaycakesclass> birthdaycakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Birthdaycakesclass birthdaycakesclass = new Birthdaycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                birthdaycakesclassList.add(birthdaycakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return birthdaycakesclassList;
    }

    public int updatebirthday(Birthdaycakesclass birthdaycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(bcakename, birthdaycakesclass.getBcakename());
        contentValues.put(bcakeid, birthdaycakesclass.getBcakeid());
        contentValues.put(bcakeweight, birthdaycakesclass.getBcakeweight());
        contentValues.put(bcakecolors, birthdaycakesclass.getBcakecolors());
        contentValues.put(bcakenote, birthdaycakesclass.getBcakenote());
        contentValues.put(bcakeprice, birthdaycakesclass.getBcakeprice());
        contentValues.put(bcakeqty, birthdaycakesclass.getBcakeqty());
        return db.update(TABLE_NAME1, contentValues, BID + "=?", new String[]{String.valueOf(birthdaycakesclass.getBid())});
    }

    public void deletebirthday(String bid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME1, BID + "=?", new String[]{bid});
        db.close();
    }

    public int getTotalb() {
        String query = "SELECT * from " + TABLE_NAME1;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }



    //Wedding
    public void addwedding(Weddingcakesclass weddingcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(wcakename, weddingcakesclass.getWcakename());
        contentValues.put(wcakeid, weddingcakesclass.getWcakeid());
        contentValues.put(wcakeweight, weddingcakesclass.getWcakeweight());
        contentValues.put(wcakecolors, weddingcakesclass.getWcakecolors());
        contentValues.put(wcakenote, weddingcakesclass.getWcakenote());
        contentValues.put(wcakeprice, weddingcakesclass.getWcakeprice());
        contentValues.put(wcakeqty, weddingcakesclass.getWcakeqty());
        contentValues.put(wcreated_at, weddingcakesclass.getWcreated_at());
        db.insert(TABLE_NAME2, null, contentValues);
        db.close();
    }

    public Weddingcakesclass getwedding(int wid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME2, new String[]{WID, wcakename, wcakeid, wcakeweight, wcakecolors, wcakenote, wcakeprice, wcakeqty, wcreated_at}, WID + " = ?", new String[]{String.valueOf(wid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Weddingcakesclass weddingcakesclass = new Weddingcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return weddingcakesclass;
    }

    public List<Weddingcakesclass> getAllwedding() {
        List<Weddingcakesclass> weddingcakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Weddingcakesclass weddingcakesclass = new Weddingcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                weddingcakesclassList.add(weddingcakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return weddingcakesclassList;
    }

    public int updatewedding(Weddingcakesclass weddingcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(wcakename, weddingcakesclass.getWcakename());
        contentValues.put(wcakeid, weddingcakesclass.getWcakeid());
        contentValues.put(wcakeweight, weddingcakesclass.getWcakeweight());
        contentValues.put(wcakecolors, weddingcakesclass.getWcakecolors());
        contentValues.put(wcakenote, weddingcakesclass.getWcakenote());
        contentValues.put(wcakeprice, weddingcakesclass.getWcakeprice());
        contentValues.put(wcakeqty, weddingcakesclass.getWcakeqty());
        return db.update(TABLE_NAME2, contentValues, WID + "=?", new String[]{String.valueOf(weddingcakesclass.getWid())});
    }

    public void deletewedding(String wid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME2, WID + "=?", new String[]{wid});
        db.close();
    }

    public int getTotalw() {
        String query = "SELECT * from " + TABLE_NAME2;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }




    //anniversary
    public void addanniversary(Anniversarycakesclass anniversarycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(acakename, anniversarycakesclass.getAcakename());
        contentValues.put(acakeid, anniversarycakesclass.getAcakeid());
        contentValues.put(acakeweight, anniversarycakesclass.getAcakeweight());
        contentValues.put(acakecolors, anniversarycakesclass.getAcakecolors());
        contentValues.put(acakenote, anniversarycakesclass.getAcakenote());
        contentValues.put(acakeprice, anniversarycakesclass.getAcakeprice());
        contentValues.put(acakeqty, anniversarycakesclass.getAcakeqty());
        contentValues.put(acreated_at, anniversarycakesclass.getAcreated_at());
        db.insert(TABLE_NAME3, null, contentValues);
        db.close();
    }

    public Anniversarycakesclass getanniversary(int aid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME3, new String[]{AID, acakename, acakeid, acakeweight, acakecolors, acakenote, acakeprice, acakeqty, acreated_at}, AID + " = ?", new String[]{String.valueOf(aid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Anniversarycakesclass anniversarycakesclass = new Anniversarycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return anniversarycakesclass;
    }

    public List<Anniversarycakesclass> getAllanniversary() {
        List<Anniversarycakesclass> anniversarycakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Anniversarycakesclass anniversarycakesclass = new Anniversarycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                anniversarycakesclassList.add(anniversarycakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return anniversarycakesclassList;
    }

    public int updateanniversary(Anniversarycakesclass anniversarycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(acakename, anniversarycakesclass.getAcakename());
        contentValues.put(acakeid, anniversarycakesclass.getAcakeid());
        contentValues.put(acakeweight, anniversarycakesclass.getAcakeweight());
        contentValues.put(acakecolors, anniversarycakesclass.getAcakecolors());
        contentValues.put(acakenote, anniversarycakesclass.getAcakenote());
        contentValues.put(acakeprice, anniversarycakesclass.getAcakeprice());
        contentValues.put(acakeqty, anniversarycakesclass.getAcakeqty());
        return db.update(TABLE_NAME3, contentValues, AID + "=?", new String[]{String.valueOf(anniversarycakesclass.getAid())});
    }

    public void deleteanniversary(String aid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME3, AID + "=?", new String[]{aid});
        db.close();
    }

    public int getTotala() {
        String query = "SELECT * from " + TABLE_NAME3;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }





    //newbaby
    public void addnewbaby(Newbabycakesclass newbabycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ncakename, newbabycakesclass.getNcakename());
        contentValues.put(ncakeid, newbabycakesclass.getNcakeid());
        contentValues.put(ncakeweight, newbabycakesclass.getNcakeweight());
        contentValues.put(ncakecolors, newbabycakesclass.getNcakecolors());
        contentValues.put(ncakenote, newbabycakesclass.getNcakenote());
        contentValues.put(ncakeprice, newbabycakesclass.getNcakeprice());
        contentValues.put(ncakeqty, newbabycakesclass.getNcakeqty());
        contentValues.put(ncreated_at, newbabycakesclass.getNcreated_at());
        db.insert(TABLE_NAME4, null, contentValues);
        db.close();
    }

    public Newbabycakesclass getnewbaby(int nid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME4, new String[]{NID, ncakename, ncakeid, ncakeweight, ncakecolors, ncakenote, ncakeprice, ncakeqty, ncreated_at}, NID + " = ?", new String[]{String.valueOf(nid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Newbabycakesclass newbabycakesclass = new Newbabycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return newbabycakesclass;
    }

    public List<Newbabycakesclass> getAllnewbaby() {
        List<Newbabycakesclass> newbabycakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Newbabycakesclass newbabycakesclass = new Newbabycakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                newbabycakesclassList.add(newbabycakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return newbabycakesclassList;
    }

    public int updatenewbaby(Newbabycakesclass newbabycakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ncakename, newbabycakesclass.getNcakename());
        contentValues.put(ncakeid, newbabycakesclass.getNcakeid());
        contentValues.put(ncakeweight, newbabycakesclass.getNcakeweight());
        contentValues.put(ncakecolors, newbabycakesclass.getNcakecolors());
        contentValues.put(ncakenote, newbabycakesclass.getNcakenote());
        contentValues.put(ncakeprice, newbabycakesclass.getNcakeprice());
        contentValues.put(ncakeqty, newbabycakesclass.getNcakeqty());
        return db.update(TABLE_NAME4, contentValues, NID + "=?", new String[]{String.valueOf(newbabycakesclass.getNid())});
    }

    public void deletenewbaby(String nid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME4, NID + "=?", new String[]{nid});
        db.close();
    }

    public int getTotaln() {
        String query = "SELECT * from " + TABLE_NAME4;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }





    //other
    public void addother(Othercupcakesclass othercupcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ocakename, othercupcakesclass.getOcakename());
        contentValues.put(ocakeid, othercupcakesclass.getOcakeid());
        contentValues.put(ocakeweight, othercupcakesclass.getOcakeweight());
        contentValues.put(ocakecolors, othercupcakesclass.getOcakecolors());
        contentValues.put(ocakenote, othercupcakesclass.getOcakenote());
        contentValues.put(ocakeprice, othercupcakesclass.getOcakeprice());
        contentValues.put(ocakeqty, othercupcakesclass.getOcakeqty());
        contentValues.put(ocreated_at, othercupcakesclass.getOcreated_at());
        db.insert(TABLE_NAME5, null, contentValues);
        db.close();
    }

    public Othercupcakesclass getother(int oid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME5, new String[]{OID, ocakename, ocakeid, ocakeweight, ocakecolors, ocakenote, ocakeprice, ocakeqty, ocreated_at}, OID + " = ?", new String[]{String.valueOf(oid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Othercupcakesclass othercupcakesclass = new Othercupcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return othercupcakesclass;
    }

    public List<Othercupcakesclass> getAllother() {
        List<Othercupcakesclass> othercupcakesclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Othercupcakesclass othercupcakesclass = new Othercupcakesclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                othercupcakesclassList.add(othercupcakesclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return othercupcakesclassList;
    }

    public int updateother(Othercupcakesclass othercupcakesclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ocakename, othercupcakesclass.getOcakename());
        contentValues.put(ocakeid, othercupcakesclass.getOcakeid());
        contentValues.put(ocakeweight, othercupcakesclass.getOcakeweight());
        contentValues.put(ocakecolors, othercupcakesclass.getOcakecolors());
        contentValues.put(ocakenote, othercupcakesclass.getOcakenote());
        contentValues.put(ocakeprice, othercupcakesclass.getOcakeprice());
        contentValues.put(ocakeqty, othercupcakesclass.getOcakeqty());
        return db.update(TABLE_NAME5, contentValues, OID + "=?", new String[]{String.valueOf(othercupcakesclass.getOid())});
    }

    public void deleteother(String oid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME5, OID + "=?", new String[]{oid});
        db.close();
    }

    public int getTotalo() {
        String query = "SELECT * from " + TABLE_NAME5;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }





    //order
    public void addorder(Orderproductclass orderproductclass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(orproductname, orderproductclass.getOrproductname());
        contentValues.put(orproductid, orderproductclass.getOrproductid());
        contentValues.put(orproductflavour, orderproductclass.getOrproductflavour());
        contentValues.put(orproductqty, orderproductclass.getOrproductqty());
        contentValues.put(orcusname, orderproductclass.getOrcusname());
        contentValues.put(orcuscontact, orderproductclass.getOrcuscontact());
        contentValues.put(orstatus, orderproductclass.getOrstatus());
        contentValues.put(orcreated_at, orderproductclass.getOrcreated_at());
        db.insert(TABLE_NAME6, null, contentValues);
        db.close();
    }

    public Orderproductclass getorder(int orid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME6, new String[]{ORID, orproductname, orproductid, orproductflavour, orproductqty, orcusname, orcuscontact, orstatus, orcreated_at}, ORID + " = ?", new String[]{String.valueOf(orid)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Orderproductclass orderproductclass = new Orderproductclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        db.close();
        return orderproductclass;
    }

    public List<Orderproductclass> getAllorder() {
        List<Orderproductclass> orderproductclassList = new ArrayList<>();
        String query = "SELECT * from " + TABLE_NAME6;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Orderproductclass orderproductclass = new Orderproductclass(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                orderproductclassList.add(orderproductclass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return orderproductclassList;
    }

    public int updateorder(Orderproductclass orderproductclass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(orproductname, orderproductclass.getOrproductname());
        contentValues.put(orproductid, orderproductclass.getOrproductid());
        contentValues.put(orproductflavour, orderproductclass.getOrproductflavour());
        contentValues.put(orproductqty, orderproductclass.getOrproductqty());
        contentValues.put(orcusname, orderproductclass.getOrcusname());
        contentValues.put(orcuscontact, orderproductclass.getOrcuscontact());
        contentValues.put(orstatus, orderproductclass.getOrstatus());
        return db.update(TABLE_NAME6, contentValues, ORID + "=?", new String[]{String.valueOf(orderproductclass.getOrid())});
    }

    public void deleteorder(String orid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME6, ORID + "=?", new String[]{orid});
        db.close();
    }

    public int getTotalor() {
        String query = "SELECT * from " + TABLE_NAME6;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }




    //Feedbacks
    public void addfeedback (FeedbackClass feedbackClass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(feedusername,feedbackClass.getFeedusername());
        contentValues.put(feednotes,feedbackClass.getFeednotes());
        contentValues.put(feedstatus,feedbackClass.getFeedstatus());
        contentValues.put(created_atf,feedbackClass.getCreated_atf());
        db.insert(TABLE_NAME7, null,contentValues);
        db.close();
    }

    public FeedbackClass getfeedback (int fid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME7,new String[]{FID,feedusername,feednotes,feedstatus,created_atf},FID+" = ?",new String[]{String.valueOf(fid)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        FeedbackClass feedbackClass=new FeedbackClass(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        db.close();
        return feedbackClass;
    }

    public List<FeedbackClass> getAllfeedback(){
        List<FeedbackClass> feedbackClassList=new ArrayList<>();
        String query="SELECT * from "+TABLE_NAME7;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                FeedbackClass feedbackClass=new FeedbackClass(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                feedbackClassList.add(feedbackClass);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return feedbackClassList;
    }
    public int updatefeedback (FeedbackClass feedbackClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(feedusername, feedbackClass.getFeedusername());
        contentValues.put(feednotes, feedbackClass.getFeednotes());
        contentValues.put(feedstatus, feedbackClass.getFeedstatus());
        return db.update(TABLE_NAME7, contentValues, FID+ "=?",new String[]{String.valueOf(feedbackClass.getFid())});
    }

    public void deletefeedback (String fid){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME7,FID+"=?",new String[]{fid});
        db.close();
    }

    public int getTotalfeedback (){
        String query="SELECT * from "+TABLE_NAME7;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }

}