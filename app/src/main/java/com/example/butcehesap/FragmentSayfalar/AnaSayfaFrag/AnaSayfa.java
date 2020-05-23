package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter.KaydirAdapter;
import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter.Sayfa;
import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter.SayfaAdapter;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Grafik;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Grafik2;
import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.example.butcehesap.SQLite.YilVeriKatmani;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class AnaSayfa extends androidx.fragment.app.Fragment {
    View rootView;
    VeriKatmani veriKatmani;
    YilVeriKatmani yilVeriKatmani;
    GelirVeriKatmani gelirVeriKatmani;
    ViewPager viewPager ;
    LinearLayout sliderDotspanel;
    RecyclerView recyclerView;
    LineChart lineChart;
    LineChart lineChart1;

    ImageButton ayar;
    Button gelirEkle,giderEkle,gelirGrafik,giderGrafik;

    int toplamGider;
    int toplamGelir;
    int kalanPara;
    int market;
    int akaryakit;
    int giyim;
    int fatura;
    int diger;

    private int dotscount;
    private ImageView[] dots;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_ana_sayfa, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.harcamalarRec);
        yilVeriKatmani=new YilVeriKatmani(getContext());
        veriKatmani =new VeriKatmani(getContext());
        gelirVeriKatmani=new GelirVeriKatmani(getContext());
        lineChart =rootView.findViewById(R.id.chart);
        lineChart1 =rootView.findViewById(R.id.chart1);
        ayar = rootView.findViewById(R.id.ayarlar);
        gelirEkle = rootView.findViewById(R.id.gelirEkle);
        giderEkle = rootView.findViewById(R.id.giderEkle);
        gelirGrafik = rootView.findViewById(R.id.gelirGrafik);
        giderGrafik = rootView.findViewById(R.id.giderGrafik);
        //*****************************Veri tabanı işlemleri***************************************

        toplamGider = veriKatmani.harcamaToplam();
        toplamGelir = gelirVeriKatmani.gelirToplam();
        kalanPara = toplamGelir - toplamGider ;

        market = veriKatmani.harcamaToplam("Market");
        akaryakit = veriKatmani.harcamaToplam("Akaryakıt");
        giyim = veriKatmani.harcamaToplam("Giyim");
        fatura = veriKatmani.harcamaToplam("Fatura");
        diger = veriKatmani.harcamaToplam("Diğer");

        List<Gelir> gelirs = gelirVeriKatmani.listele();
        List<Harcama> harcamas  = veriKatmani.listele();


        //**************************** Grafik Gorunumleri ******************************************



        final ArrayList<Entry> gelir = new ArrayList<>();

        for(int i =0 ; i < gelirs.size() ; i ++ ){
            gelir.add(new Entry(i, gelirs.get(i).getTutar()));
        }

        final ArrayList<Entry> gider = new ArrayList<>();

        for(int i =0 ; i < harcamas.size() ; i ++ ){
            gider.add(new Entry(i, harcamas.get(i).getTutar()));
        }


        LineDataSet lineDataSet = new LineDataSet(gelir,"Gelir");
        LineDataSet giderDataSet = new LineDataSet(gider,"Gider");

        lineDataSet.setLineWidth(5);
        lineDataSet.setDrawValues(false);
        lineDataSet.disableDashedHighlightLine();
        lineDataSet.setColor(Color.rgb(42,57,94));
        lineDataSet.disableDashedLine();
        lineDataSet.setCircleColor(Color.rgb(42,57,94));
        lineDataSet.setCircleHoleColor(Color.rgb(42,57,94));
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.rgb(42,57,94));

        giderDataSet.setLineWidth(5);
        giderDataSet.setDrawValues(false);
        giderDataSet.disableDashedHighlightLine();
        giderDataSet.setColor(Color.rgb(42,57,94));
        giderDataSet.disableDashedLine();
        giderDataSet.setCircleColor(Color.rgb(42,57,94));
        giderDataSet.setCircleHoleColor(Color.rgb(42,57,94));
        giderDataSet.setDrawFilled(true);
        giderDataSet.setFillColor(Color.rgb(42,57,94));

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData lineData = new LineData(dataSets);

        ArrayList<ILineDataSet> dataSets1 = new ArrayList<>();
        dataSets1.add(giderDataSet);
        LineData lineData1 = new LineData(dataSets1);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftAxis1 = lineChart1.getAxisLeft();
        leftAxis1.setEnabled(false);
        YAxis rightAxis1 = lineChart1.getAxisRight();
        rightAxis1.setEnabled(false);
        XAxis xAxis1 = lineChart1.getXAxis();
        xAxis1.setEnabled(false);

        lineChart.setDescription(null);
        lineChart.setTouchEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false);
        lineChart.setData(lineData);
        lineChart.invalidate();

        lineChart1.setDescription(null);
        lineChart1.setTouchEnabled(false);
        lineChart1.setDrawGridBackground(false);
        lineChart1.setDrawBorders(false);
        lineChart1.setData(lineData1);
        lineChart1.invalidate();
        //*****************************************************************************************


        //**********************RecyclerView Kaydirmali harcama kategorileri **********************
        ArrayList<Sayfa> sayfas =new ArrayList<>();
        sayfas.add(new Sayfa(R.drawable.ic_shopping_cart_black_24dp,"Market",market+""));
        sayfas.add(new Sayfa(R.drawable.ic_directions_car_black_24dp,"Akaryakit",akaryakit+""));
        sayfas.add(new Sayfa(R.drawable.ic_content_cut_black_24dp,"Giyim",giyim+""));
        sayfas.add(new Sayfa(R.drawable.ic_assignment_black_24dp,"Fatura",fatura+""));
        sayfas.add(new Sayfa(R.drawable.ic_content_paste_black_24dp,"Diğer",diger+""));

        SayfaAdapter sayfaAdapter = new SayfaAdapter(getContext(),sayfas);
        recyclerView.setAdapter(sayfaAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);



        //**************************** ViewPager Kaydırma ****************************************
        viewPager =rootView.findViewById(R.id.viewPagerAna);

        sliderDotspanel = rootView.findViewById(R.id.dots);
        String baslik[] ={"Kalan Para","Toplam Gider","Toplam Gelir"};
        String para[] ={kalanPara+"",toplamGider+"",toplamGelir+""};
        KaydirAdapter kaydirAdapter = new KaydirAdapter(getContext(),baslik,para);
        viewPager.setAdapter(kaydirAdapter);


        dotscount = kaydirAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.default_indicator));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.selected_indicator));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.default_indicator));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.selected_indicator));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //******************Button tıklanma ***************************
        ayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ayarlat ayarlat = new Ayarlat();
                ayarlat.show(getFragmentManager(),null);
            }
        });
        gelirGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grafik2 grafik2 =new Grafik2();
                grafik2.show(getFragmentManager(),null);
            }
        });
        giderGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grafik grafik = new Grafik();
                grafik.show(getFragmentManager(),null);
            }
        });

        gelirEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GelirEkle gelirEkle = new GelirEkle();
                gelirEkle.show(getFragmentManager(),null);
            }
        });
        giderEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HarcamaEkle harcamaEkle = new HarcamaEkle();
                harcamaEkle.show(getFragmentManager(),null);
            }
        });



        return rootView;


    }





}
