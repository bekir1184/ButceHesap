package com.example.butcehesap.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteKatmaniGelir extends SQLiteOpenHelper {

    public SQLiteKatmaniGelir(Context context){
        super(context,"GelirTablo",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Sql = "create table GelirTablo(id integer primary key autoincrement, aciklama text,tutar integer ,kategori text,tarih text)";
        sqLiteDatabase.execSQL(Sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists GelirTablo ");
    }

}
