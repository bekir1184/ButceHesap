package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.MainActivity;
import com.example.butcehesap.Model.Harcama;
import com.example.butcehesap.R;
import com.example.butcehesap.SQLite.VeriKatmani;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HarcamaEkle extends DialogFragment {

    View rootView;
    MaterialSpinner materialSpinner;
    Button ekleButton;
    EditText aciklama,tutar;
    private String kategori;
    VeriKatmani veriKatmani;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_harcama_ekle, null);
        materialSpinner =rootView.findViewById(R.id.spinner);
        ekleButton =rootView.findViewById(R.id.ekle);
        aciklama =rootView.findViewById(R.id.aciklama);

        aciklama.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    if(aciklama.getText().length()>20){

                        Resources resources = getResources();
                        Drawable drawable = resources.getDrawable(R.drawable.ic_error_outline_black_24dp); // hata mesajı iconu
                        int ht = drawable.getIntrinsicHeight();
                        int wt = drawable.getIntrinsicWidth();
                        drawable.setBounds(0,0,wt,ht);
                        aciklama.setError("Sanki biraz uzun oldu",drawable);

                    }

                }
            }
        });

        tutar =rootView.findViewById(R.id.Tutar);
        veriKatmani = new VeriKatmani(getContext());
        veriKatmani.ac();

        materialSpinner.setItems("Seçiniz","Market","Giyim","Fatura","Akaryakıt","Diğer");
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                kategori =item.toString();
            }
        });
            ekleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String aciklamaStr = aciklama.getText().toString();
                    String tutarStr =tutar.getText().toString();
                    int tutarInt =Integer.parseInt(tutarStr);

                    if(!TextUtils.isEmpty(aciklamaStr) && !TextUtils.isEmpty(tutarStr)){
                        Harcama harcama = new Harcama(aciklamaStr,kategori,tutarInt,sistemSaati());
                        veriKatmani.harcamaEkle(harcama);
                        aciklama.setText("");
                        tutar.setText("");
                        Intent intent = new Intent(getContext(),MainActivity.class);
                        startActivity(intent);

                    }
                    else{
                        Snackbar.make(rootView,"Eksik alan var harcama eklenemedi",Snackbar.LENGTH_LONG).show();
                        aciklama.setText("");
                        tutar.setText("");
                    }




                }
            });






        return rootView;
    }


    public  String sistemSaati(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy/");
        System.out.println(simpleDateFormat.format(new Date()));

        return simpleDateFormat.format(new Date());

    }


}
