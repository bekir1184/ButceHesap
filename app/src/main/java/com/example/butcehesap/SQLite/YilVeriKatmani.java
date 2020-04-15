package com.example.butcehesap.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.butcehesap.Model.Yillikitem;

import java.util.ArrayList;
import java.util.List;

public class YilVeriKatmani {
    SQLiteDatabase db;
    SQLiteYil bdb;
    public YilVeriKatmani(Context context){
        bdb = new SQLiteYil(context);
    }
    public void ac(){
        db=bdb.getWritableDatabase();
    }
    public void kapat(){
        bdb.close();
    }

    public void yilEkle(Yillikitem yillikitem){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ayAdi",yillikitem.getAyAdi());
        contentValues.put("tutarGelir",yillikitem.getGelir());
        contentValues.put("tutarGider",yillikitem.getGider());
        contentValues.put("marke",yillikitem.getMarket());
        contentValues.put("akaryakit",yillikitem.getAkaryakit());
        contentValues.put("giyim",yillikitem.getGiyim());
        contentValues.put("fatura",yillikitem.getFatura());
        contentValues.put("diger",yillikitem.getDiger());
        contentValues.put("maas",yillikitem.getMass());
        contentValues.put("gelirDiger",yillikitem.getDigerGelir());

        db.insert("YilTablo",null,contentValues);

    }
    public List<Yillikitem> listele (){
        String kolonlar []= {"id","ayAdi","tutarGelir","tutarGider","marke","akaryakit","giyim","fatura","diger","maas","gelirDiger"};
        List<Yillikitem> liste = new ArrayList<>();
        //TODO : sqlite tobloda market columunun olmadigini idda ediyor
        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("YilTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id =cursor.getInt(0);
            String ayAdi=cursor.getString(1);
            int tutarGelir =cursor.getInt(2);
            int tutarGider =cursor.getInt(3);
            int marke =cursor.getInt(4);
            int akaryakit =cursor.getInt(5);
            int giyim =cursor.getInt(6);
            int fatura =cursor.getInt(7);
            int diger =cursor.getInt(8);
            int maas =cursor.getInt(9);
            int gelirDiger =cursor.getInt(10);
            Yillikitem yillikitem = new Yillikitem(ayAdi,tutarGider,tutarGelir,marke,akaryakit,giyim,fatura,diger,gelirDiger,maas);
            liste.add(yillikitem);
            cursor.moveToNext();
        }

        cursor.close();


        return liste;
    }

}
