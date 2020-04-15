package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Adapter.FragmentAdapter;
import com.example.butcehesap.R;
import com.google.android.material.tabs.TabLayout;


public class AylikGider extends Fragment {
    View rootView;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_aylik_gider, container, false);

        viewPager =rootView.findViewById(R.id.viewPager);
        tabLayout =rootView.findViewById(R.id.tab_lay);
        viewPager.setAdapter(new FragmentAdapter(getActivity().getSupportFragmentManager(),getContext()));
        tabLayout.setupWithViewPager(viewPager);


        return rootView;
    }


}
