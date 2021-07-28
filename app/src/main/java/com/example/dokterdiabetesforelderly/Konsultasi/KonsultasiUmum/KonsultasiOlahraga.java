package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.Konsultasi.PertanyaanKonsultasi;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class KonsultasiOlahraga extends AppCompatActivity {
    RecyclerView listDataKonsultasi;
    private final ArrayList<ModelKonsultasi> listKonsultasi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_olahraga);

        listDataKonsultasi = findViewById(R.id.listKonsultasi);
        listDataKonsultasi.setHasFixedSize(true);
        listKonsultasi.addAll(KonsultasiDataOlahraga.getListData());
        showRecyclerListKonsultasi();

    }

    private void showRecyclerListKonsultasi() {
        listDataKonsultasi.setLayoutManager(new LinearLayoutManager(this));
        KonsultasiAdapter konsultasiAdapter = new KonsultasiAdapter(listKonsultasi);
        listDataKonsultasi.setAdapter(konsultasiAdapter);
    }

    public void back(View view) {
        finish();
    }

    public void masukKonsulDokter(View view) {
        Intent intent = new Intent(KonsultasiOlahraga.this, PertanyaanKonsultasi.class);
        startActivity(intent);
    }
}