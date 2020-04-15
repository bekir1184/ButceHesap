package com.example.butcehesap.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.butcehesap.Model.Gelir;

import java.util.ArrayList;
import java.util.List;

public class GelirVeriKatmani {
    SQLiteKatmaniGelir bdb;
    SQLiteDatabase db;
    public GelirVeriKatmani(Context context){
        bdb = new SQLiteKatmaniGelir(context);
    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }
    public void kapat(){
        bdb.close();
    }

    public void gelirEkle(Gelir gelir){

        ContentValues contentValues = new ContentValues();
        contentValues.put("aciklama",gelir.getAciklama());
        contentValues.put("tutar",gelir.getTutar());
        contentValues.put("kategori",gelir.getKategori());
        contentValues.put("tarih",gelir.getTarih());

        db.insert("GelirTablo",null,contentValues);

    }
    public void gelirSil(Gelir gelir){
        db.delete("GelirTablo","id="+gelir.getId(),null);

    }
    public void toabloSil(){
        db.delete("GelirTablo","tutar > 0",null);
    }

    public List<Gelir> listele (){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        List<Gelir> liste = new ArrayList<>();

        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("GelirTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id =cursor.getInt(0);
            String aciklma=cursor.getString(1);
            int tutar =cursor.getInt(2);
            String kategori =cursor.getString(3);
            String tarih =cursor.getString(4);

            Gelir gelir = new Gelir(id,aciklma,kategori,tutar,tarih);
            liste.add(gelir);
            cursor.moveToNext();
        }

        cursor.close();


        return liste;
    }
    public int gelirToplam(){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        int toplam=0;
        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("GelirTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int tutar =cursor.getInt(2);
            toplam+=tutar;
            cursor.moveToNext();
        }

        cursor.close();

        return toplam;
    }
    public int gelirToplam(String kat){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        int toplam=0;
        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("GelirTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int tutar =cursor.getInt(2);
            toplam+=tutar;
            cursor.moveToNext();
        }

        cursor.close();

        return toplam;
    }


}
