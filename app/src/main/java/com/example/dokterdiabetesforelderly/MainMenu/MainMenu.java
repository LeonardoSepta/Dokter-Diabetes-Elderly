package com.example.dokterdiabetesforelderly.MainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.dokterdiabetesforelderly.Pesan.Pesan;
import com.example.dokterdiabetesforelderly.R;
import com.example.dokterdiabetesforelderly.StepAfterMainMenu.DataBeratBadan;
import com.example.dokterdiabetesforelderly.StepAfterMainMenu.DataGlukosa;
import com.example.dokterdiabetesforelderly.StepAfterMainMenu.Datacarbocalculator;
import com.example.dokterdiabetesforelderly.StepAfterMainMenu.ListKategoriArtikel;
import com.example.dokterdiabetesforelderly.StepAfterMainMenu.Shop;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {
    private CardView Artikel, BeratBadan, CarboCalculator, Glukosa, Konsultasi, Loading, Login, Registrasi, Resep, Shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.beranda);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.beranda:
                        return true;
                    case R.id.pesan:
                        Intent intentpesan = new Intent(MainMenu.this, Pesan.class);
                        intentpesan.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentpesan);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
//                     Intent Profil = new Intent(Mainmenu.this, Profil.class);
                        Intent intentprofil = new Intent(MainMenu.this, Profil.class);
                        intentprofil.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentprofil);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        Shop = (CardView) findViewById(R.id.Shop);
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenShop();
            }
        });

        Konsultasi = (CardView) findViewById(R.id.menuKonsultasi);
        Konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenKonsultasi();
            }
        });

        Artikel = (CardView) findViewById(R.id.menuArtikel);
        Artikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenArtikel();
            }
        });

        Resep = (CardView) findViewById(R.id.Resep);
        Resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenResep();
            }
        });

        CarboCalculator = (CardView) findViewById(R.id.carboCalcuator);
        CarboCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCarboCalculator();
            }
        });

        BeratBadan = (CardView) findViewById(R.id.Weight);
        BeratBadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBeratBadan();
            }
        });

        Glukosa = (CardView) findViewById(R.id.Glukosa);
        Glukosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGlukosa();
            }
        });

    }

    public void OpenKonsultasi (){
        Intent intent = new Intent(MainMenu.this, com.example.dokterdiabetesforelderly.Konsultasi.Konsultasi.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void OpenArtikel (){
        Intent intent = new Intent(MainMenu.this, ListKategoriArtikel.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void OpenResep (){
        Intent intent = new Intent( MainMenu.this, com.example.dokterdiabetesforelderly.Resep.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void OpenCarboCalculator (){
        Intent intent = new Intent(MainMenu.this, Datacarbocalculator.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void OpenBeratBadan (){
        Intent intent = new Intent(MainMenu.this, DataBeratBadan.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void OpenGlukosa (){
        Intent intent = new Intent(MainMenu.this, DataGlukosa.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void OpenShop (){
        Intent intent = new Intent(MainMenu.this, Shop.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}