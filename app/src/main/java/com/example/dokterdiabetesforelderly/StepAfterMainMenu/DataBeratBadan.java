package com.example.dokterdiabetesforelderly.StepAfterMainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dokterdiabetesforelderly.BeratBadanBMI.BeratBadan;
import com.example.dokterdiabetesforelderly.R;

public class DataBeratBadan extends AppCompatActivity {
    Button DataBB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_berat_badan);
        DataBB = (Button) findViewById(R.id.databeratbadan);
        DataBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanberatbadan();
            }
        });
    }

    public void simpanberatbadan() {
        Intent intent = new Intent (DataBeratBadan.this, BeratBadan.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}