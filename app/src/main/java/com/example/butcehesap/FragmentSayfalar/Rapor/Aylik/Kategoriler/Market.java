package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.butcehesap.Adapter.AylikItemAdapter;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;

import java.util.List;

public class Market extends Fragment {
    View rootView;
    List<Harcama> liste ;
    VeriKatmani veriKatmani;
    TextView toplam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_market, container, false);
        veriKatmani =new VeriKatmani(getContext());
        liste =veriKatmani.listele("Market");
        toplam=rootView.findViewById(R.id.toplam);
        toplam.setText(veriKatmani.harcamaToplam("Market")+"₺");
        ListView listView =rootView.findViewById(R.id.marketListe);
        AylikItemAdapter aylikItemAdapter =new AylikItemAdapter(getActivity(),liste);
        listView.setAdapter(aylikItemAdapter);

        return rootView;
    }


}
