package com.example.butcehesap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.AnaSayfa;
import com.example.butcehesap.FragmentSayfalar.Rapor.Aylik.Aylik;
import com.example.butcehesap.FragmentSayfalar.Rapor.Yillik;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView ;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Servis başlat



        setFragment(new AnaSayfa());

        bottomNavigationView =findViewById(R.id.nav_bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if ("Ana Sayfa".equals(menuItem.getTitle())) {
                    setFragment(new AnaSayfa());
                    return true;
                }
                if ("Aylık".equals(menuItem.getTitle())) {
                    setFragment(new Aylik());
                    return true;
                }
                if ("Yıllık".equals(menuItem.getTitle())) {
                    setFragment(new Yillik());
                    return true;
                }
                return false;
            }
        });






    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.ic_warning_black_24dp).setTitle("Uygulamadan Çık")
                .setMessage("Çıkmak istediğinize emin misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }).setNegativeButton("Hayır", null).show();
    }
}
