package com.example.butcehesap.FragmentSayfalar.Rapor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.butcehesap.Adapter.YillikAdapter;
import com.example.butcehesap.Model.Yillikitem;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.YilVeriKatmani;

import java.util.List;


public class Yillik extends Fragment {
    View rootView;
    YilVeriKatmani yilVeriKatmani;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_yillik, container, false);
        yilVeriKatmani =new YilVeriKatmani(getContext());
        ListView listView = rootView.findViewById(R.id.yillikListe);
        List<Yillikitem> liste =yilVeriKatmani.listele();
        YillikAdapter adapter = new YillikAdapter(getActivity(),liste);

        listView.setAdapter(adapter);


        return rootView;
    }


}
