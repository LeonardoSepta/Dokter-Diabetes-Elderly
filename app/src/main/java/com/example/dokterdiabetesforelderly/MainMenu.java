package com.example.dokterdiabetesforelderly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {
    private CardView Artikel, BeratBadan, CarboCalculator, Glukosa, Konsultasi, Loading, Login, Registrasi, Resep;

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
                        startActivity(new Intent(MainMenu.this, Pesan.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
//                     Intent Profil = new Intent(Mainmenu.this, Profil.class);
                        startActivity(new Intent(MainMenu.this, Profil.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
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
        Intent intent = new Intent(MainMenu.this, Konsultasi.class);
        startActivity(intent);
    }

    public void OpenArtikel (){
        Intent intent = new Intent(MainMenu.this, ListKategoriArtikel.class);
        startActivity(intent);
    }

    public void OpenResep (){
        Intent intent = new Intent( MainMenu.this, Resep.class);
        startActivity(intent);
    }


    public void OpenCarboCalculator (){
        Intent intent = new Intent(MainMenu.this, Datacarbocalculator.class);
        startActivity(intent);
    }
    public void OpenBeratBadan (){
        Intent intent = new Intent(MainMenu.this, DataBeratBadan.class);
        startActivity(intent);
    }

    public void OpenGlukosa (){
        Intent intent = new Intent(MainMenu.this, DataGlukosa.class);
        startActivity(intent);
    }
}