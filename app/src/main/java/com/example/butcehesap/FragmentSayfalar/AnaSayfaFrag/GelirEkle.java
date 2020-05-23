package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.MainActivity;
import com.example.butcehesap.Model.Gelir;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.GelirVeriKatmani;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GelirEkle extends DialogFragment {
    View rootView;
    MaterialSpinner materialSpinner ;
    EditText aciklama,tutar;
    Button ekle;
    String kategori;
    GelirVeriKatmani veriKatmani;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_gelir_ekle, null);
        materialSpinner =rootView.findViewById(R.id.spinner);
        aciklama =rootView.findViewById(R.id.aciklama);
        tutar=rootView.findViewById(R.id.Tutar);
        ekle =rootView.findViewById(R.id.ekle);
        veriKatmani=new GelirVeriKatmani(getContext());
        veriKatmani.ac();

        materialSpinner.setItems("Seçiniz","Maaş","Diğer");

        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                kategori=item.toString();
            }
        });

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aciklmaStr=aciklama.getText().toString();
                String tutarStr=tutar.getText().toString();
                int tutarInt=Integer.parseInt(tutarStr);
                if(!TextUtils.isEmpty(aciklmaStr) && !TextUtils.isEmpty(tutarStr)){
                    Gelir gelir =new Gelir(aciklmaStr,kategori,tutarInt,sistemSaati());
                    veriKatmani.gelirEkle(gelir);
                    aciklama.setText("");
                    tutar.setText("");
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);


                }
                else{
                    Snackbar.make(rootView,"Gelir eklenemedi tüm alanları doldurunuz",Snackbar.LENGTH_LONG).show();

                }
            }
        });



        return  rootView;
    }
    public  String sistemSaati(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy/");
        System.out.println(simpleDateFormat.format(new Date()));

        return simpleDateFormat.format(new Date());

    }
}
