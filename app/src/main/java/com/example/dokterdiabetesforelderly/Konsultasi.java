package com.example.dokterdiabetesforelderly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Konsultasi extends AppCompatActivity {
    private Button buatKonsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);
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
    public void OpenPertanyaanKonsultasi (){
        Intent intent = new Intent(Konsultasi.this, PertanyaanKonsultasi.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(Konsultasi.this, MainMenu.class);
        startActivity(intent);
    }
}