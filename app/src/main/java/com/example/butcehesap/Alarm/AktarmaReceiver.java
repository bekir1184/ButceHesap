package com.example.butcehesap.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.butcehesap.Model.Yillikitem;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.example.butcehesap.SQLite.YilVeriKatmani;

public class AktarmaReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        aktar(context);



    }

    private void aktar(Context context){
        GelirVeriKatmani gelirVeriKatmani = new GelirVeriKatmani(context);
        VeriKatmani harcamaVeriKatmani = new VeriKatmani(context);
        YilVeriKatmani yilVeriKatmani = new YilVeriKatmani(context);

        int market=harcamaVeriKatmani.harcamaToplam("Market");
        int akaryakit =harcamaVeriKatmani.harcamaToplam("Akaryakıt");
        int giyim =harcamaVeriKatmani.harcamaToplam("Giyim");
        int fatura =harcamaVeriKatmani.harcamaToplam("Fatura");
        int diger = harcamaVeriKatmani.harcamaToplam("Diğer");
        int toplamGider =harcamaVeriKatmani.harcamaToplam();
        int toplamGelir =gelirVeriKatmani.gelirToplam();
        int maas =gelirVeriKatmani.gelirToplam("Maaş");
        int gelirDiger =gelirVeriKatmani.gelirToplam("Diğer");
        String ayAdi;
        if(harcamaVeriKatmani.listele().isEmpty()){
            ayAdi="Isimsiz";
        }
        else{
            ayAdi=harcamaVeriKatmani.listele().get(0).getTarih().split("/")[1];
        }



        gelirVeriKatmani.toabloSil();
        harcamaVeriKatmani.toabloSil();

        yilVeriKatmani.ac();
        Yillikitem yillikitem = new Yillikitem(ayAdi,toplamGider,toplamGelir,market,akaryakit,giyim,fatura,diger,gelirDiger,maas);
        yilVeriKatmani.yilEkle(yillikitem);



    }
}
