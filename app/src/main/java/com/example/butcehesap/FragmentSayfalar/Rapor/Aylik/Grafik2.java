package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


public class Grafik2 extends DialogFragment {
    View rootView;
    GelirVeriKatmani veriKatmani;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_grafik2, null);
        veriKatmani = new GelirVeriKatmani(getContext());
        setupPie();

        return rootView;
    }
    public void setupPie(){
        int maas=0;
        int diger=0;
        List<Gelir> list=veriKatmani.listele();
        for (int i =0 ; i<list.size() ;i++){
            switch (list.get(i).getKategori()){
                case "Maaş":
                    maas+=list.get(i).getTutar();
                    break;
                case "Diğer" :
                    diger+=list.get(i).getTutar();
                    break;
                default:
                    diger+=list.get(i).getTutar();
            }
        }

        List<PieEntry> veriler = new ArrayList<>();
        veriler.add(new PieEntry(maas,"Maaş"));
        veriler.add(new PieEntry(diger,"Diğer"));

        PieDataSet pieDataSet = new PieDataSet(veriler,"Giderler");
        pieDataSet.setColors(Color.rgb(100,86,255),Color.rgb(255,176,86),Color.rgb(241,255,86),Color.rgb(255,86,241),Color.rgb(255,134,86));
        pieDataSet.setLabel("Aylık Gelirler");
        PieData pieData =new PieData(pieDataSet);

        PieChart pieChart = rootView.findViewById(R.id.pieGrap);

        pieChart.setCenterText("Gelir");
        pieChart.setCenterTextSize(20);
        pieChart.setData(pieData);
        pieChart.animateY(1500);
        pieChart.invalidate();

    }

}
