package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.butcehesap.Adapter.AylikGelirAdapter;
import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;

import java.util.List;


public class AylikGelir extends Fragment {
    View rootView;
    List<Gelir> liste ;
    GelirVeriKatmani veriKatmani;
    TextView toplam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_aylik_gelir, container, false);

        veriKatmani =new GelirVeriKatmani(getContext());
        toplam=rootView.findViewById(R.id.toplam);
        liste =veriKatmani.listele();
        toplam.setText(veriKatmani.gelirToplam()+"");
        ListView listView =rootView.findViewById(R.id.listeView);
        AylikGelirAdapter aylikItemAdapter =new AylikGelirAdapter(getActivity(),liste);
        listView.setAdapter(aylikItemAdapter);


        return rootView;
    }


}
