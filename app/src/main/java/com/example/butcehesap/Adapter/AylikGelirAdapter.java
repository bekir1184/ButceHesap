package com.example.butcehesap.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;

import java.util.List;

public class AylikGelirAdapter  extends ArrayAdapter<Gelir> {
    Activity activity;
    List<Gelir> list;
    private LayoutInflater layoutInflater;

    public AylikGelirAdapter(Activity activity,List<Gelir> list){
        super(activity, R.layout.geliritem);
        this.activity=activity;
        this.list=list;
        layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AylikGelirAdapter.ViewHolder holder;
        if(convertView ==null){
            convertView=layoutInflater.inflate(R.layout.geliritem,null);
            holder=new AylikGelirAdapter.ViewHolder();
            holder.tutar =convertView.findViewById(R.id.para);
            holder.aciklama=convertView.findViewById(R.id.aciklama);
            holder.gun=convertView.findViewById(R.id.gun);
            holder.ay=convertView.findViewById(R.id.ay);
            holder.yil=convertView.findViewById(R.id.yil);
            holder.kategori=convertView.findViewById(R.id.kategori);
            convertView.setTag(holder);
        }
        else{
            holder =(AylikGelirAdapter.ViewHolder) convertView.getTag();
        }
        Gelir harcama =getItem(position);

        if(harcama != null){
            String tutarStr=Integer.toString(harcama.getTutar());
            holder.tutar.setText(tutarStr);

            holder.kategori.setText(harcama.getKategori());

            holder.aciklama.setText(harcama.getAciklama());
            String tarihStr=harcama.getTarih();
            System.out.println(tarihStr);
            String []tarih= tarihStr.split("/");
            holder.gun.setText(tarih[0]);
            holder.ay.setText(tarih[1]);
            holder.yil.setText(tarih[2]);








        }

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Gelir getItem(int position) {
        return list.get(position);
    }
    public class ViewHolder{
        TextView tutar,kategori,aciklama,gun,ay,yil;

    }
}
