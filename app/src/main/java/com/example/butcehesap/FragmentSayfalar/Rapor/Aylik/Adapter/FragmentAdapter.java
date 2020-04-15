package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Akaryakit;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Diger;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Fatura;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Giyim;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Market;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private String [] tabTitle={"Market", "Akaryakit","Fatura","Giyim","Diğer"};
    Context context;

    public FragmentAdapter(FragmentManager fm, Context context ) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                return new Market();
            case 1 :
                return new Akaryakit();
            case 2 :

                return new Fatura();
            case 3 :

                return  new Giyim();
            case 4 :

                return new Diger();

            default:

                return new Giyim();

        }
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {


        return tabTitle[position];
    }

}
