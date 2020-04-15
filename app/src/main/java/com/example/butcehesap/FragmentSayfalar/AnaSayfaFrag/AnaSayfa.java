package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Grafik;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Grafik2;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Akaryakit;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Diger;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Fatura;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Giyim;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Market;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.example.butcehesap.SQLite.YilVeriKatmani;


public class AnaSayfa extends androidx.fragment.app.Fragment {
    View rootView;
    SwipeRefreshLayout swipeRefreshLayout;
    Button gider,gelir,marketButton,akaryakitButton,giyimButton,faturaButton,digerButton;
    Button grafikAc,grafik;
    ImageButton ayar;
    VeriKatmani veriKatmani;
    YilVeriKatmani yilVeriKatmani;
    GelirVeriKatmani gelirVeriKatmani;
    TextView gelirText,giderText,kalanText,matketToplam,akaryakitToplam,giyimToplam,faturToplam,dıgerToplam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_ana_sayfa, container, false);
        ayar =rootView.findViewById(R.id.ayarlar);
        gider=rootView.findViewById(R.id.giderEkle);
        gelir=rootView.findViewById(R.id.gelirEkle);
        grafikAc =rootView.findViewById(R.id.grafik);
        gelirText=rootView.findViewById(R.id.gelirT);
        giderText=rootView.findViewById(R.id.giderT);
        kalanText=rootView.findViewById(R.id.kalanPara);
        matketToplam=rootView.findViewById(R.id.marketToplam);
        akaryakitToplam=rootView.findViewById(R.id.akaryakitToplam);
        giyimToplam=rootView.findViewById(R.id.giyimToplam);
        faturToplam=rootView.findViewById(R.id.faturaToplam);
        dıgerToplam=rootView.findViewById(R.id.digerToplam);
        marketButton=rootView.findViewById(R.id.marketButton);
        akaryakitButton=rootView.findViewById(R.id.akaryakitButton);
        giyimButton=rootView.findViewById(R.id.giyimButton);
        faturaButton=rootView.findViewById(R.id.faturaButton);
        digerButton=rootView.findViewById(R.id.digerButton);
        swipeRefreshLayout=rootView.findViewById(R.id.swipeRef);

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new Market());
            }
        });
        akaryakitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setFragment(new Akaryakit());
            }
        });
        giyimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new Giyim());
            }
        });
        faturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new Fatura());
            }
        });
        digerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new Diger());
            }
        });

        yilVeriKatmani=new YilVeriKatmani(getContext());
        veriKatmani =new VeriKatmani(getContext());
        gelirVeriKatmani=new GelirVeriKatmani(getContext());
        grafik=rootView.findViewById(R.id.grafik2);



         gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HarcamaEkle ekle = new HarcamaEkle();
                ekle.show(getFragmentManager(),null);
            }
        });
        gelir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GelirEkle gelirEkle = new GelirEkle();
                gelirEkle.show(getFragmentManager(),null);
            }
        });
        ayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ayarlat ayarlat= new Ayarlat();
                ayarlat.show(getFragmentManager(),null);
            }
        });
        grafikAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(rootView);

            }
        });
        grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grafik2 grafik2= new Grafik2();
                grafik2.show(getFragmentManager(),null);

            }
        });





        gelirText.setText(gelirVeriKatmani.gelirToplam()+"₺");
        giderText.setText(veriKatmani.harcamaToplam()+"₺");
        kalanText.setText(gelirVeriKatmani.gelirToplam()-veriKatmani.harcamaToplam()+"₺");
        matketToplam.setText(veriKatmani.harcamaToplam("Market")+"₺");
        giyimToplam.setText(veriKatmani.harcamaToplam("Giyim")+"₺");
        faturToplam.setText(veriKatmani.harcamaToplam("Fatura")+"₺");
        akaryakitToplam.setText(veriKatmani.harcamaToplam("Akaryakıt")+"₺");
        dıgerToplam.setText(veriKatmani.harcamaToplam("Diğer")+"₺");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 textGuncelle();
             }
         });

        return rootView;


    }
    public void textGuncelle(){
            gelirText.setText(gelirVeriKatmani.gelirToplam()+"₺");
            giderText.setText(veriKatmani.harcamaToplam()+"₺");
            kalanText.setText(gelirVeriKatmani.gelirToplam()-veriKatmani.harcamaToplam()+"₺");
            matketToplam.setText(veriKatmani.harcamaToplam("Market")+"₺");
            giyimToplam.setText(veriKatmani.harcamaToplam("Giyim")+"₺");
            faturToplam.setText(veriKatmani.harcamaToplam("Fatura")+"₺");
            akaryakitToplam.setText(veriKatmani.harcamaToplam("Akaryakıt")+"₺");
            dıgerToplam.setText(veriKatmani.harcamaToplam("Diğer")+"₺");
            swipeRefreshLayout.setRefreshing(false);
    }





    public void  showDialog(View view){
        Grafik grafik = new Grafik();
        grafik.show(getFragmentManager(),"Grafik");

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }




}
