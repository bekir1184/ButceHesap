package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Akaryakit;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Diger;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Fatura;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Giyim;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Kategoriler.Market;
import com.example.butcehesap.R;

import java.util.ArrayList;

public class SayfaAdapter extends RecyclerView.Adapter<SayfaAdapter.MyViewHolder> {

    ArrayList<Sayfa> sayfaList;
    LayoutInflater inflater;
    Context context ;
    public SayfaAdapter(Context context, ArrayList<Sayfa> sayfaList) {
        inflater = LayoutInflater.from(context);
        this.context=context;
        this.sayfaList = sayfaList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.anasayfa_kaydir, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sayfa selectedSayfa = sayfaList.get(position);
        holder.setData(selectedSayfa, position);

    }

    @Override
    public int getItemCount() {
        return sayfaList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView kategori, para;
        ImageView icon;
        Button button ;

        public MyViewHolder(View itemView) {
            super(itemView);
            kategori = (TextView) itemView.findViewById(R.id.baslik);
            para = (TextView) itemView.findViewById(R.id.paraMiktari);
            icon = (ImageView) itemView.findViewById(R.id.iconResim);
            button = itemView.findViewById(R.id.button);


        }

        public void setData(Sayfa selectedSayfa, int position) {

            this.kategori.setText(selectedSayfa.getKategori());
            this.para.setText(selectedSayfa.getPara());
            this.icon.setImageResource(selectedSayfa.getIcon());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    switch (kategori.getText().toString()){
                        case "Market":
                            Market market = new Market();
                            market.show(manager,null);
                            break;
                        case "Akaryakit":
                            Akaryakit akaryakit = new Akaryakit();
                            akaryakit.show(manager,null);
                            break;
                        case "Giyim":
                            Giyim giyim = new Giyim();
                            giyim.show(manager,null);
                            break;
                        case "Fatura":
                            Fatura fatura = new Fatura();
                            fatura.show(manager,null);
                            break;
                        case "Diğer":
                            Diger diger = new Diger();
                            diger.show(manager,null);
                            break;
                    }
                }
            });


        }


        @Override
        public void onClick(View v) {


        }


    }
}
