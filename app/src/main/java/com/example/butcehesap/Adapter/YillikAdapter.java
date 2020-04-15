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

import com.example.butcehesap.Model.Yillikitem;
import com.example.butcehesap.R;

import java.util.List;

public class YillikAdapter extends ArrayAdapter<Yillikitem> {
    Activity activity;
    List<Yillikitem> list;
    private LayoutInflater layoutInflater;

    public YillikAdapter(Activity activity,List<Yillikitem> list){
        super(activity, R.layout.yillikitem);
        this.activity=activity;
        this.list=list;
        layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        YillikAdapter.ViewHolder holder;
        if(convertView ==null){
            convertView=layoutInflater.inflate(R.layout.yillikitem,null);
            holder=new YillikAdapter.ViewHolder();
            holder.ayAdi=convertView.findViewById(R.id.ayAdi);
            holder.gelir=convertView.findViewById(R.id.toplamGelir);
            holder.gider=convertView.findViewById(R.id.toplamGider);
            holder.akaryakitToplam=convertView.findViewById(R.id.akaryakitToplam);
            holder.faturaToplam=convertView.findViewById(R.id.faturaToplam);
            holder.giyimToplam=convertView.findViewById(R.id.giyimToplam);
            holder.maasToplam=convertView.findViewById(R.id.maasToplam);
            holder.marketToplam=convertView.findViewById(R.id.marketToplam);
            holder.gelirDigerToplam=convertView.findViewById(R.id.gelirDigerToplam);
            holder.giderDigerToplam=convertView.findViewById(R.id.digerGiderToplam);
            convertView.setTag(holder);
        }
        else{
            holder =(YillikAdapter.ViewHolder) convertView.getTag();
        }
        Yillikitem yillikitem =getItem(position);

        if(yillikitem != null){
            holder.gider.setText(yillikitem.getGider()+"₺");
            holder.gelir.setText(yillikitem.getGelir()+"₺");
            holder.giyimToplam.setText(yillikitem.getGiyim()+"₺");
            holder.marketToplam.setText(yillikitem.getMarket()+"₺");
            holder.faturaToplam.setText(yillikitem.getFatura()+"₺");
            holder.akaryakitToplam.setText(yillikitem.getAkaryakit()+"₺");
            holder.giderDigerToplam.setText(yillikitem.getDiger()+"₺");
            holder.gelirDigerToplam.setText(yillikitem.getDigerGelir()+"₺");
            holder.maasToplam.setText(yillikitem.getMass()+"₺");
            holder.ayAdi.setText(yillikitem.getAyAdi());

        }

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Nullable
    @Override
    public Yillikitem getItem(int position) {
        return list.get(position);
    }

    public class ViewHolder{
        TextView ayAdi,gelir,gider,maasToplam,gelirDigerToplam,marketToplam,faturaToplam,akaryakitToplam,giyimToplam,giderDigerToplam;

    }
}
