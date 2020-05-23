package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.butcehesap.Adapter.AylikGiderAdapter;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;

import java.util.List;


public class AylikGider extends Fragment {
    View rootView;
    List<Harcama> liste ;
    VeriKatmani veriKatmani;
    TextView toplam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_aylik_gider, container, false);
        veriKatmani =new VeriKatmani(getContext());
        toplam=rootView.findViewById(R.id.toplam);
        liste =veriKatmani.listele();
        toplam.setText(veriKatmani.harcamaToplam()+"");
        ListView listView =rootView.findViewById(R.id.listeView);
        AylikGiderAdapter aylikItemAdapter =new AylikGiderAdapter(getActivity(),liste);
        listView.setAdapter(aylikItemAdapter);
        return rootView;
    }


}
