package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.Konsultasi.PertanyaanKonsultasi;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class KonsultasiDiet extends AppCompatActivity {
    //initialize variable
    RecyclerView listKonsulDiet, listKonsulOlahraga;
    private final ArrayList<ModelKonsultasi> listKonsultasi = new ArrayList<>();
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_diet);

        //assignt variable
        listKonsulDiet = findViewById(R.id.listKonsultasi);
        listKonsulDiet.setHasFixedSize(true);
        listKonsultasi.addAll(KonsultasiDataDiet.getListData());
        showRecyclerListKonsultasi();


        /*openOlahraga = findViewById(R.id.tabOlahraga);*/


     /*   Button buatKonsultasi = findViewById(R.id.buatkonsultasi);
        buatKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPertanyaanKonsultasi();
            }
        });*/

        /*BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navkonsultasi);
        bottomNavigationView.setSelectedItemId(R.id.konsulsemua);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.konsulsemua:
                        return true;
                    case R.id.konsuldiet:
                        *//*startActivity(new Intent(KonsultasiDiet.this, KonsultasiUser.class));
                        overridePendingTransition(0,0);*//*
                        return true;
                    case R.id.konsulolahraga:
                        *//*startActivity(new Intent(KonsultasiDiet.this, KonsultasiUser.class));
                        overridePendingTransition(0,0);*//*
                        return true;
                   *//* case R.id.konsuldiabetes:
                        *//**//*startActivity(new Intent(KonsultasiDiet.this, KonsultasiUser.class));
                        overridePendingTransition(0,0);*//**//*
                        return true;
                    case R.id.konsulhealthy:
                       *//**//* startActivity(new Intent(KonsultasiDiet.this, KonsultasiUser.class));
                        overridePendingTransition(0,0);*//**//*
                        return true;*//*
                }
                return false;
            }
        });*/
    }

    private void MasukKonsulOlahraga() {
        Intent intent = new Intent(KonsultasiDiet.this, KonsultasiOlahraga.class);
        startActivity(intent);
    }

    private void showRecyclerListKonsultasi(){
        listKonsulDiet.setLayoutManager(new LinearLayoutManager(this));
        KonsultasiAdapter konsultasiAdapter = new KonsultasiAdapter(listKonsultasi);
        listKonsulDiet.setAdapter(konsultasiAdapter);

    }

    public void OpenPertanyaanKonsultasi (){
        Intent intent = new Intent(KonsultasiDiet.this, PertanyaanKonsultasi.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(KonsultasiDiet.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void masukKonsulDokter(View view) {
        Intent intent = new Intent(KonsultasiDiet.this, PertanyaanKonsultasi.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void masukKonsulOlahraga(View view) {
        Intent intent = new Intent(KonsultasiDiet.this, KonsultasiOlahraga.class);
        startActivity(intent);

    }


}