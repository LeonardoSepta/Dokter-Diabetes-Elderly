package com.example.dokterdiabetesforelderly.StepAfterMainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.R;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void back(View view) {
        finish();
    }

    public void menuArtikel(View view) {
    }
}