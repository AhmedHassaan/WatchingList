package com.example.lenovo.watchinglist.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "watching";
    SQLiteDatabase DB;
    public DBHelper(Context context){ super(context,DBName,null,1); }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table watchingnow (name text, type text, myep integer, totalep text)");
        db.execSQL("create table watched (name text, type text)");
        db.execSQL("create table needtowatch (name text, type text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists watchingnow");
        db.execSQL("drop table if exists watched");
        db.execSQL("drop table if exists needtowatch");
        onCreate(db);
    }

    public Cursor getWatchingNow(){
        DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("select name, type, myep from watchingnow",new String[]{});
        if(cursor != null)
            cursor.moveToFirst();
        DB.close();
        return cursor;
    }
    public Cursor getWatched(){
        DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("select name, type from watched",new String[]{});
        if(cursor != null)
            cursor.moveToFirst();
        DB.close();
        return cursor;
    }
    public Cursor getNeedToWatch(){
        DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("select name, type from needtowatch",new String[]{});
        if(cursor != null)
            cursor.moveToFirst();
        DB.close();
        return cursor;
    }
    public void addWatchingNow(String name, String type, String totalep){
        DB = getWritableDatabase();
        DB.execSQL("insert into watchingnow (name,category,myep,totalep) values" +
                "(?,?,1,?)",new Object[]{name,type,totalep});
        DB.close();
    }
    public void addWatched(String name, String type, String totalep){
        DB = getWritableDatabase();
        DB.execSQL("insert into watched (name,category,totalep) values" +
                "(?,?,?)",new Object[]{name,type,totalep});
        DB.close();
    }
    public void addNeedToWatch(String name, String type, String totalep){
        DB = getWritableDatabase();
        DB.execSQL("insert into needtowatch (name,category,totalep) values" +
                "(?,?,?)",new Object[]{name,type,totalep});
        DB.close();
    }
    public void updateEp(String name, int myEp){
        DB = getWritableDatabase();
        DB.execSQL("update watchingnow set myep = ? where name like ?",new Object[]{name,myEp});
    }
}
