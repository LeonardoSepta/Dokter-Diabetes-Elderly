package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Datacarbocalculator extends AppCompatActivity {
    Button masukanDataCarbo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datacarbocalculator);

        masukanDataCarbo = (Button) findViewById(R.id.datacarbocal);
        masukanDataCarbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masukanData();
            }
        });
    }
    public void masukanData(){
        Intent intent = new Intent(Datacarbocalculator.this, Carbocalculator.class);
        startActivity(intent);
    }
    public void back(View view) {
        finish();
    }
}