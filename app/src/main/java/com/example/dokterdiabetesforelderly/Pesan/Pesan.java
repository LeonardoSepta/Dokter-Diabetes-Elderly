package com.example.dokterdiabetesforelderly.Pesan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.MainMenu.Profil;
import com.example.dokterdiabetesforelderly.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Pesan extends AppCompatActivity {
    RecyclerView recyclerViewPesan;
    private ArrayList<ModelPesan> listDataPesan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        recyclerViewPesan = findViewById(R.id.listPesan);
        recyclerViewPesan.setHasFixedSize(true);
        listDataPesan.addAll(PesanData.getListData());
        showRecyclerListPesan();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.pesan);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.beranda:
                        Intent intentberanda = new Intent(Pesan.this, MainMenu.class);
                        intentberanda.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentberanda);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.pesan:
                        return true;
                    case R.id.profil:
//                     Intent Profil = new Intent(Mainmenu.this, Profil.class);
                        Intent intentprofil = new Intent(Pesan.this, Profil.class);
                        intentprofil.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentprofil);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    private void showRecyclerListPesan(){
        recyclerViewPesan.setLayoutManager(new LinearLayoutManager(this));
        PesanAdapter pesanAdapter = new PesanAdapter(listDataPesan);
        recyclerViewPesan.setAdapter(pesanAdapter);
    }

    public void back(View view) {
        finish();
    }
}