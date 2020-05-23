package com.example.butcehesap.FragmentSayfalar.Rapor.Aylik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.butcehesap.R;


public class Aylik extends Fragment {
    View rootView;
    Button gelir ;
    Button gider ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_aylik, container, false);
        setFragment(new AylikGelir());
        gelir = rootView.findViewById(R.id.gelir);
        gider = rootView.findViewById(R.id.gider);

        gelir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gider.setBackgroundColor(Color.rgb(64,85,140));
                gelir.setBackgroundColor(Color.rgb(29,161,242));
                setFragment(new AylikGelir());
            }
        });
        gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gelir.setBackgroundColor(Color.rgb(64,85,140));
                gider.setBackgroundColor(Color.rgb(29,161,242));
                setFragment(new AylikGider());
            }
        });


        return rootView;
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.aylikFrame,fragment);
        fragmentTransaction.commit();
    }


}
