package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.butcehesap.Adapter.AylikItemAdapter;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;

import java.util.List;


public class Giyim extends Fragment {
    View rootView;
    List<Harcama> liste ;
    VeriKatmani veriKatmani;
    TextView toplam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_giyim, container, false);
        veriKatmani =new VeriKatmani(getContext());
        liste =veriKatmani.listele("Giyim");

        toplam=rootView.findViewById(R.id.toplam);
        toplam.setText(veriKatmani.harcamaToplam("Giyim")+"₺");

        ListView listView =rootView.findViewById(R.id.giyimListe);
        AylikItemAdapter aylikItemAdapter =new AylikItemAdapter(getActivity(),liste);
        listView.setAdapter(aylikItemAdapter);

        return rootView;
    }

}
