package com.example.butcehesap.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.butcehesap.FragmentSayfalar.Rapor.Yillik.YilEkrani;
import com.example.butcehesap.Model.Yillikitem;
import com.example.butcehesap.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
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
            holder.pieChart =convertView.findViewById(R.id.chart);
            holder.ayAdi=convertView.findViewById(R.id.ayAdi);
            holder.gelir=convertView.findViewById(R.id.toplamGelir);
            holder.gider=convertView.findViewById(R.id.toplamGider);
            holder.kalanPara=convertView.findViewById(R.id.kalanPara);
            holder.gitB=convertView.findViewById(R.id.gitB);
            convertView.setTag(holder);
        }
        else{
            holder =(YillikAdapter.ViewHolder) convertView.getTag();
        }
        final Yillikitem yillikitem =getItem(position);

        if(yillikitem != null){
            holder.gider.setText(yillikitem.getGider()+"₺");
            holder.gelir.setText(yillikitem.getGelir()+"₺");
            holder.kalanPara.setText(yillikitem.getGelir()-yillikitem.getGider()+"₺");
            holder.ayAdi.setText(yillikitem.getAyAdi());


            holder.gitB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YilEkrani yilEkrani = new YilEkrani(
                            yillikitem.getAyAdi(),
                            yillikitem.getMarket(),
                            yillikitem.getAkaryakit(),
                            yillikitem.getGiyim(),
                            yillikitem.getFatura(),
                            yillikitem.getDiger(),
                            yillikitem.getMass(),
                            yillikitem.getDigerGelir()
                            );
                    FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                    yilEkrani.show(manager,null);

                }
            });

            //*************************************************************************************
            holder.pieChart.setUsePercentValues(true);
            holder.pieChart.getDescription().setEnabled(false);
            holder.pieChart.setDragDecelerationFrictionCoef(0.95f);

            holder.pieChart.setDrawEntryLabels(false);
            holder.pieChart.setDrawHoleEnabled(true);
            holder.pieChart.setHoleColor(Color.rgb(64,85,140))  ;
            holder.pieChart.setTransparentCircleRadius(61f);

            ArrayList<PieEntry> yValues = new ArrayList<>();
            yValues.add(new PieEntry(yillikitem.getGelir()-yillikitem.getGider(),"Kalan Para"));
            yValues.add(new PieEntry(yillikitem.getGider(),"Harcanan Para"));


            PieDataSet dataSet = new PieDataSet(yValues,"");
            dataSet.setSliceSpace(3f);
            dataSet.setValueTextSize(0);
            dataSet.setSelectionShift(5f);
            dataSet.setColors(Color.rgb(42,57,94),Color.rgb(29,161,242));



            PieData pieData = new PieData(dataSet);
            pieData.setValueTextSize(0);

            pieData.setValueTextColor(Color.WHITE);
            holder.pieChart.animateY(1000);
            holder.pieChart.setData(pieData);

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
        TextView ayAdi,gelir,gider,kalanPara;
        Button gitB;
        PieChart pieChart;

    }
}
