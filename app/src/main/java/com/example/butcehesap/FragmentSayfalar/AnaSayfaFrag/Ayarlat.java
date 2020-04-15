package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.butcehesap.Alarm.AktarmaReceiver;
import com.example.butcehesap.R;
import com.example.butcehesap.StaticAySonu;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.IOException;
import java.util.Calendar;

public class Ayarlat extends DialogFragment {
    View view;
    Button button;
    int gun;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ayarlat, null);
        button =view.findViewById(R.id.button);
        MaterialSpinner materialSpinner =view.findViewById(R.id.spinner);
        materialSpinner.setItems("1","2","3","4","5","6","7","8","9","10","11"
        ,"12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
        try {
            materialSpinner.setSelectedIndex(StaticAySonu.getAySonu(getContext())-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                gun= Integer.parseInt((item.toString()));
                Snackbar.make(view,item+" seçildi",Snackbar.LENGTH_LONG).show();
                StaticAySonu.setAySonu(Integer.parseInt(item.toString()),getContext());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktarilmaGunuAyarla(gun);
            }
        });

        return view;
    }

    private void aktarilmaGunuAyarla(int gun) {
        Calendar calNow = Calendar.getInstance();
        Calendar calendar = (Calendar) calNow.clone();

        calendar.set(Calendar.DAY_OF_MONTH,gun);
        calendar.set(Calendar.HOUR_OF_DAY,24);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);


        Toast.makeText(getActivity(),"Aktarilacak gun ayarlandi",Toast.LENGTH_LONG).show();


        Intent intent = new Intent(getContext(), AktarmaReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,0);
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }


}
