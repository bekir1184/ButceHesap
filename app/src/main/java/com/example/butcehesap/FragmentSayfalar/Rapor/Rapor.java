package com.example.butcehesap.FragmentSayfalar.Rapor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Aylik;
import com.example.butcehesap.R;
import com.gigamole.navigationtabstrip.NavigationTabStrip;


public class Rapor extends Fragment {
    View rootView;
    NavigationTabStrip navigationTabStrip;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_rapor, container, false);
        setFragment(new Aylik());
        navigationTabStrip=rootView.findViewById(R.id.nts);
        navigationTabStrip.setTitles("Aylik","Yillik");
        navigationTabStrip.setTabIndex(0,true);

        navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                if(index ==0){
                    setFragment(new Aylik());
                }
                if(index ==1){
                    setFragment(new Yillik());
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
        fragmentTransaction.replace(R.id.frame3,fragment);
        fragmentTransaction.commit();
    }


}
