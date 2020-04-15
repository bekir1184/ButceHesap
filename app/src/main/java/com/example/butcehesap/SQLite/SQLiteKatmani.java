package com.example.butcehesap.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteKatmani extends SQLiteOpenHelper {


    public SQLiteKatmani(Context context){
        super(context,"HarcamaTablo",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="create table HarcamaTablo (id integer primary key autoincrement, aciklama text," +
                "tutar integer ,kategori text,tarih text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists HarcamaTablo ");
    }

}
