package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.MainActivity;
import com.example.butcehesap.Model.Yillikitem;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.example.butcehesap.SQLite.YilVeriKatmani;

public class Ayarlat extends DialogFragment {
    View view;
    Button evet,hayir;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ayarlat, null);
        evet = view.findViewById(R.id.evet);
        hayir = view.findViewById(R.id.hayir);

        evet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktar(getContext());
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        hayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
    public void aktar(Context context) {
        GelirVeriKatmani gelirVeriKatmani = new GelirVeriKatmani(context);
        VeriKatmani harcamaVeriKatmani = new VeriKatmani(context);
        YilVeriKatmani yilVeriKatmani = new YilVeriKatmani(context);

        int market = harcamaVeriKatmani.harcamaToplam("Market");
        int akaryakit = harcamaVeriKatmani.harcamaToplam("Akaryakıt");
        int giyim = harcamaVeriKatmani.harcamaToplam("Giyim");
        int fatura = harcamaVeriKatmani.harcamaToplam("Fatura");
        int diger = harcamaVeriKatmani.harcamaToplam("Diğer");
        int toplamGider = harcamaVeriKatmani.harcamaToplam();
        int toplamGelir = gelirVeriKatmani.gelirToplam();
        int maas = gelirVeriKatmani.gelirToplam("Maaş");
        int gelirDiger = gelirVeriKatmani.gelirToplam("Diğer");
        String ayAdi;
        if (harcamaVeriKatmani.listele().isEmpty()) {
            ayAdi = "Isimsiz";
        } else {
            ayAdi = harcamaVeriKatmani.listele().get(0).getTarih().split("/")[1];
        }


        gelirVeriKatmani.toabloSil();
        harcamaVeriKatmani.toabloSil();

        yilVeriKatmani.ac();
        Yillikitem yillikitem = new Yillikitem(ayAdi, toplamGider, toplamGelir, market, akaryakit, giyim, fatura, diger, gelirDiger, maas);
        yilVeriKatmani.yilEkle(yillikitem);
    }
}
