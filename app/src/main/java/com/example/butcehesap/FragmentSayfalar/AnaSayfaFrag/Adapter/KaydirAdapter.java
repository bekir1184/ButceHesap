package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.butcehesap.R;

public class KaydirAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private String baslik [] ;
    private String para [] ;
    public KaydirAdapter(Context context ,String baslik[] ,String para[]){
        this.baslik=baslik;
        this.context=context;
        this.para=para;
    }
    @Override
    public int getCount() {
        return baslik.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.yillik_item, null);

        TextView basText =view.findViewById(R.id.baslik);
        TextView paraText =view.findViewById(R.id.paramiktari);

        basText.setText(baslik[position]);
        paraText.setText(para[position]+"");


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
