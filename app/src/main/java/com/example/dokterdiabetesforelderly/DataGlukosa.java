package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataGlukosa extends AppCompatActivity {
    private Button masukanDataGlukosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_glukosa);
        masukanDataGlukosa = (Button) findViewById(R.id.dataglukosa);
        masukanDataGlukosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masukanData();
            }
        });
    }

    public void masukanData(){
        Intent intent = new Intent(DataGlukosa.this, Glukosa.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(DataGlukosa.this, MainMenu.class);
        startActivity(intent);
    }
}