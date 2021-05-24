package com.example.dokterdiabetesforelderly.StepAfterMainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.Artikel.Artikel;
import com.example.dokterdiabetesforelderly.Artikel.ArtikelInfoDiabetes;
import com.example.dokterdiabetesforelderly.Artikel.ArtikelKesehatan;
import com.example.dokterdiabetesforelderly.R;

public class ListKategoriArtikel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kategori_artikel);
    }

    public void back(View view) {
        finish();
    }

    public void semuaArtikel(View view) {
        Intent intent = new Intent(ListKategoriArtikel.this, Artikel.class);
        startActivity(intent);
    }

    public void artikelInfoDiabetes(View view) {
        Intent intent = new Intent(ListKategoriArtikel.this, ArtikelInfoDiabetes.class);
        startActivity(intent);
    }

    public void artikelKesehatan(View view) {
        Intent intent = new Intent(ListKategoriArtikel.this, ArtikelKesehatan.class);
        startActivity(intent);
    }
}