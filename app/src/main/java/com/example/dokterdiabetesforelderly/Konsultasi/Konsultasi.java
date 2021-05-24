package com.example.dokterdiabetesforelderly.Konsultasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiAdapter;
import com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiData;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Konsultasi extends AppCompatActivity {
    private Button buatKonsultasi;
    RecyclerView listDataKonsultasi;
    private ArrayList<ModelKonsultasi> listKonsultasi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);

        listDataKonsultasi = findViewById(R.id.listKonsultasi);
        listDataKonsultasi.setHasFixedSize(true);
        listKonsultasi.addAll(KonsultasiData.getListData());
        showRecyclerListKonsultasi();


        buatKonsultasi = (Button) findViewById(R.id.buatkonsultasi);
        buatKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPertanyaanKonsultasi();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navkonsultasi);
        bottomNavigationView.setSelectedItemId(R.id.konsultasiuserlain);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.konsultasiuserlain:
                        return true;
                    case R.id.konsultasiuser:
                        startActivity(new Intent(Konsultasi.this, KonsultasiUser.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void showRecyclerListKonsultasi(){
        listDataKonsultasi.setLayoutManager(new LinearLayoutManager(this));
        KonsultasiAdapter konsultasiAdapter = new KonsultasiAdapter(listKonsultasi);
        listDataKonsultasi.setAdapter(konsultasiAdapter);

    }

    public void OpenPertanyaanKonsultasi (){
        Intent intent = new Intent(Konsultasi.this, PertanyaanKonsultasi.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(Konsultasi.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}