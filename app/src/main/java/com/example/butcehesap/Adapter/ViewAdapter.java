package com.example.butcehesap.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.AnaSayfa;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Aylik;
import com.example.butcehesap.FragmentSayfalar.Rapor.Yillik.Yillik;

public class ViewAdapter extends FragmentStatePagerAdapter {
    private int sayfaSayisi =3;
    Context context;

    public ViewAdapter(FragmentManager fm, Context context ) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                return new AnaSayfa();
            case 1 :
                return new Aylik();
            case 2 :
                return new Yillik();

            default:
                return  new AnaSayfa();
        }
    }

    @Override
    public int getCount() {
        return sayfaSayisi;
    }

}