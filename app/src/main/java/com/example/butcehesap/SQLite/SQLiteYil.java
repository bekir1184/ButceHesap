package com.example.butcehesap.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteYil extends SQLiteOpenHelper {

    public SQLiteYil(Context context){
        super(context,"YilTablo",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="create table YilTablo (id integer primary key autoincrement, ayAdi text," +
                "tutarGelir integer ,tutarGider integer ,marke integer ,akaryakit integer ,giyim integer ," +
                "fatura integer ,diger integer,maas integer ,gelirDiger integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists YilTablo ");
    }
}
