package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PertanyaanKonsultasi extends AppCompatActivity {
    private Button Konsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan_konsultasi);

        Konsultasi = (Button) findViewById(R.id.buatpertanyaan);
        Konsultasi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                closePertanyaan();
            }
        });

    }
    public void closePertanyaan(){
        Intent intent = new Intent(PertanyaanKonsultasi.this, Konsultasi.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}