package com.example.butcehesap.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.butcehesap.Model.Harcama;

import java.util.ArrayList;
import java.util.List;

public class VeriKatmani {
    SQLiteDatabase db;
    SQLiteKatmani bdb;

    public VeriKatmani(Context context){
        bdb = new SQLiteKatmani(context);
    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }
    public void kapat(){
        bdb.close();
    }
    public void harcamaEkle(Harcama harcama){
        ContentValues values = new ContentValues();
        values.put("aciklama",harcama.getAciklama());
        values.put("tutar",harcama.getTutar());
        values.put("kategori",harcama.getKategori());
        values.put("tarih",harcama.getTarih());

        db.insert("HarcamaTablo",null,values);
    }
    public void harcamaSil(String gelen){
        System.out.println(gelen+"2");
        db.delete("HarcamaTablo","aciklana =?"+gelen , null);
    }
    public List<Harcama> listele (){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        List<Harcama> liste = new ArrayList<>();

        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("HarcamaTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id =cursor.getInt(0);
            String aciklma=cursor.getString(1);
            int tutar =cursor.getInt(2);
            String kategori =cursor.getString(3);
            String tarih =cursor.getString(4);

            Harcama harcama = new Harcama(id,aciklma,kategori,tutar,tarih);
            liste.add(harcama);
            cursor.moveToNext();
        }

        cursor.close();


        return liste;
    }
    public void toabloSil(){
        db.delete("HarcamaTablo","tutar > 0",null);
    }


    public List<Harcama> listele (String kategoriG){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        List<Harcama> liste = new ArrayList<>();

        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("HarcamaTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id =cursor.getInt(0);
            String aciklma=cursor.getString(1);
            int tutar =cursor.getInt(2);
            String kategori =cursor.getString(3);
            String tarih =cursor.getString(4);

            if(kategori.equals(kategoriG)){
                Harcama harcama = new Harcama(id,aciklma,kategori,tutar,tarih);
                liste.add(harcama);
            }

            cursor.moveToNext();
        }

        cursor.close();


        return liste;
    }
    public int harcamaToplam(){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        int toplam=0;
        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("HarcamaTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int tutar =cursor.getInt(2);
            toplam+=tutar;
            cursor.moveToNext();
        }

        cursor.close();


        return toplam;
    }
    public int harcamaToplam(String kategori){
        String kolonlar []= {"id","aciklama","tutar","kategori","tarih"};
        int toplam=0;
        db =bdb.getReadableDatabase();
        Cursor cursor =db.query("HarcamaTablo",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            if(cursor.getString(3).equals(kategori)){
                int tutar =cursor.getInt(2);
                toplam+=tutar;
            }

            cursor.moveToNext();
        }

        cursor.close();


        return toplam;
    }



}
