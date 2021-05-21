package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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