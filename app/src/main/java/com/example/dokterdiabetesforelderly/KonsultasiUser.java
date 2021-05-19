package com.example.dokterdiabetesforelderly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KonsultasiUser extends AppCompatActivity {
    private Button buatKonsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_user);
        buatKonsultasi = (Button) findViewById(R.id.buatkonsultasi);
        buatKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPertanyaanKonsultasi();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navkonsultasi);
        bottomNavigationView.setSelectedItemId(R.id.konsultasiuser);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.konsultasiuserlain:
                        startActivity(new Intent(KonsultasiUser.this, Konsultasi.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.konsultasiuser:
                        return true;
                }
                return false;
            }
        });
    }

    public void OpenPertanyaanKonsultasi (){
        Intent intent = new Intent(KonsultasiUser.this, PertanyaanKonsultasi.class);
        startActivity(intent);
    }
    public void back(View view) {
        finish();
    }
}