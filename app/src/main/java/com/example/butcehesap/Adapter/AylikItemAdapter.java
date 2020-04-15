package com.example.butcehesap.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AylikItemAdapter extends ArrayAdapter<Harcama> {
    Activity activity;
    List<Harcama> list;
    private LayoutInflater layoutInflater;

    public AylikItemAdapter(Activity activity,List<Harcama> list){
        super(activity,R.layout.harcama_item);
        this.activity=activity;
        this.list=list;
        layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if(convertView ==null){
            convertView=layoutInflater.inflate(R.layout.harcama_item,null);
            holder=new ViewHolder();
            holder.tutar =convertView.findViewById(R.id.para);
            holder.aciklama=convertView.findViewById(R.id.aciklama);
            holder.gun=convertView.findViewById(R.id.gun);
            holder.ay=convertView.findViewById(R.id.ay);
            holder.yil=convertView.findViewById(R.id.yil);
            holder.button=convertView.findViewById(R.id.button);

            convertView.setTag(holder);
        }
        else{
            holder =(ViewHolder) convertView.getTag();
        }
        final Harcama harcama =getItem(position);

        if(harcama != null){
            String tutarStr=Integer.toString(harcama.getTutar());
            holder.tutar.setText(tutarStr);

            holder.aciklama.setText(harcama.getAciklama());
            String tarihStr=harcama.getTarih();
            System.out.println(tarihStr);
            String []tarih= tarihStr.split("/");
            holder.gun.setText(tarih[0]);
            holder.ay.setText(tarih[1]);
            holder.yil.setText(tarih[2]);
            final View finalConvertView = convertView;
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(holder.aciklama.getText().toString());
                    builder.setMessage("Silmek istiyor musun ?");
                    builder.setNegativeButton("Hayır", null);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            VeriKatmani veriKatmani = new VeriKatmani(getContext());
                            System.out.println(holder.aciklama.getText().toString());
                            veriKatmani.harcamaSil(holder.aciklama.getText().toString());
                            Snackbar.make(finalConvertView,"Silindi",Snackbar.LENGTH_LONG).show();
                        }
                    });
                    builder.show();
                }
            });







        }

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Harcama getItem(int position) {
        return list.get(position);
    }
    public class ViewHolder{
        TextView tutar,aciklama,gun,ay,yil;
        Button button;
    }
}
