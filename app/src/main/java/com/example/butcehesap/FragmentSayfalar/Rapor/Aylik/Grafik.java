package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Grafik extends DialogFragment {
    View rootView;
    VeriKatmani veriKatmani;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.grafik_fragment,null);
        veriKatmani=new VeriKatmani(getContext());
        setupPie();

        return  rootView;
    }
    public void setupPie(){
        int fatura=0;
        int market=0;
        int akaryakit=0;
        int giyim=0;
        int diger=0;
        List<Harcama> list=veriKatmani.listele();
        for (int i =0 ; i<list.size() ;i++){
            switch (list.get(i).getKategori()){
                case "Market":
                    market+=list.get(i).getTutar();
                    break;
                case "Giyim" :
                    giyim+=list.get(i).getTutar();
                    break;
                case "Fatura" :
                    fatura+=list.get(i).getTutar();
                    break;
                case "Akaryakıt":
                    akaryakit+=list.get(i).getTutar();
                    break;
                case "Diğer":
                    diger+=list.get(i).getTutar();
                    break;

                default:
                    diger+=list.get(i).getTutar();
            }
        }

        List<PieEntry> veriler = new ArrayList<>();
        veriler.add(new PieEntry(fatura,"Fatura"));
        veriler.add(new PieEntry(market,"Market"));
        veriler.add(new PieEntry(akaryakit,"Akaryakıt"));
        veriler.add(new PieEntry(giyim,"Giyim"));
        veriler.add(new PieEntry(diger,"Diğer"));

        PieDataSet pieDataSet = new PieDataSet(veriler,"Giderler");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setLabel("Aylık Giderler");
        PieData pieData =new PieData(pieDataSet);
        PieChart pieChart = rootView.findViewById(R.id.pieGrap);

        pieChart.setCenterText("Gider");
        pieChart.setCenterTextSize(20);
        pieChart.setData(pieData);
        pieChart.animateY(1000);
        pieChart.invalidate();

    }
}
