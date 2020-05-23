package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.Adapter.AylikGiderAdapter;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;

import java.util.List;

public class Diger extends DialogFragment {
    View rootView;
    List<Harcama> liste ;
    VeriKatmani veriKatmani;
    TextView toplam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_diger, null);
        veriKatmani =new VeriKatmani(getContext());
        liste =veriKatmani.listele("Diğer");

        toplam=rootView.findViewById(R.id.toplam);
        toplam.setText(veriKatmani.harcamaToplam("Diğer")+"₺");

        ListView listView =rootView.findViewById(R.id.digerListe);
        AylikGiderAdapter aylikItemAdapter =new AylikGiderAdapter(getActivity(),liste);
        listView.setAdapter(aylikItemAdapter);

        return rootView;
    }

}
