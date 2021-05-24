package com.example.dokterdiabetesforelderly.StepAfterMainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dokterdiabetesforelderly.Glukosa.Glukosa;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;

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