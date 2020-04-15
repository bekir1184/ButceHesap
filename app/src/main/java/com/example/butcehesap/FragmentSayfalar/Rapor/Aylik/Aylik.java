package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.butcehesap.Adapter.AylikItemAdapter;
import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.GelirEkle;
import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.HarcamaEkle;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.List;


public class Aylik extends Fragment {
    View rootView;
    NavigationTabStrip navigationTabStrip;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_aylik, container, false);
        setFragment(new AylikGider());
        navigationTabStrip=rootView.findViewById(R.id.nts);
        navigationTabStrip.setTitles("Gider","Gelir");
        navigationTabStrip.setTabIndex(0,true);

        navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                if(index ==0){
                    setFragment(new AylikGider());
                }
                if(index ==1){
                    setFragment(new AylikGelir());
                }

            }

            @Override
            public void onEndTabSelected(String title, int index) {

            }
        });


        return rootView;
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.aylikFrame,fragment);
        fragmentTransaction.commit();
    }


}
