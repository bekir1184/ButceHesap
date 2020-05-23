package com.example.butcehesap.FragmentSayfalar.Rapor.Yillik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;


public class YilEkrani extends DialogFragment {
    View rootView;
    TextView ayAdi,market,akaryakit,giyim,fatura,digerGider,maas,digerGelir;
    int marketS,akaryakitS,giyimS,faturaS,digerGiderS,maasS,digerGelirS;
    String ayAdiS;
    BarChart barChart;
    public YilEkrani(String ayAdiS, int marketS, int akaryakitS, int giyimS, int faturaS, int digerGiderS, int maasS, int digerGelirS) {
        this.ayAdiS = ayAdiS;
        this.marketS = marketS;
        this.akaryakitS = akaryakitS;
        this.giyimS = giyimS;
        this.faturaS = faturaS;
        this.digerGiderS = digerGiderS;
        this.maasS = maasS;
        this.digerGelirS = digerGelirS;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.ekranyil, null);
        ayAdi =rootView.findViewById(R.id.ayAdi);
        market =rootView.findViewById(R.id.marketToplam);
        akaryakit =rootView.findViewById(R.id.akaryakitToplam);
        giyim =rootView.findViewById(R.id.giyimToplam);
        fatura =rootView.findViewById(R.id.faturaToplam);
        digerGider= rootView.findViewById(R.id.giderDigerToplam);
        maas=rootView.findViewById(R.id.maasToplam);
        digerGelir = rootView.findViewById(R.id.gelirDigerToplam);
        barChart = rootView.findViewById(R.id.chart);


        ayAdi.setText(ayAdiS);
        market.setText(marketS+" ₺");
        akaryakit.setText(marketS+" ₺");
        giyim.setText(giyimS+" ₺");
        fatura.setText(faturaS+" ₺");
        digerGelir.setText(digerGelirS+" ₺");
        digerGider.setText(digerGiderS+" ₺");
        maas.setText(maasS+" ₺");

        //BarChart
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.setFitBars(true);


        Description desc ;
        Legend L;

        L = barChart.getLegend();
        desc = barChart.getDescription();
        desc.setText("");
        L.setEnabled(false);

         String kat[] = {"","Market","Akaryakıt","Giyim","Fatura","Dıger(gelir)","Maas","Dıger"};

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Mar");
        xAxisLabel.add("Aka");
        xAxisLabel.add("Giy");
        xAxisLabel.add("Fat");
        xAxisLabel.add("Dıg");
        xAxisLabel.add("Maas");
        xAxisLabel.add("Gelir");

        YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(kat));


        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);

        leftAxis.setTextSize(10f);
        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setDrawGridLines(false);

        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawLabels(false);

        ArrayList<BarEntry> barCharts = new ArrayList<>();
        barCharts.add(new BarEntry(1,marketS));
        barCharts.add(new BarEntry(2,akaryakitS));
        barCharts.add(new BarEntry(3,giyimS));
        barCharts.add(new BarEntry(4,faturaS));
        barCharts.add(new BarEntry(5,digerGiderS));
        barCharts.add(new BarEntry(6,maasS));
        barCharts.add(new BarEntry(7,digerGelirS));

        BarDataSet barDataSet = new BarDataSet(barCharts,"");
        barDataSet.setColors(Color.rgb(29,161,242));

        barDataSet.setDrawIcons(true);
        barDataSet.setValueTextColor(Color.WHITE);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.6f);

        barChart.setData(barData);
        barChart.setScaleEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.animateXY(2000, 2000);
        barChart.setDrawBorders(false);
        barChart.setDescription(desc);
        barChart.setDrawValueAboveBar(true);








        return rootView;
    }

}
