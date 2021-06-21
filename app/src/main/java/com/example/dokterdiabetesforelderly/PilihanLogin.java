package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.LoginLansia.Login;
import com.example.dokterdiabetesforelderly.LoginUmum.LoginUmum;

public class PilihanLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_login);
    }

    public void opsiLansia(View view) {
        Intent intent = new Intent(PilihanLogin.this, Login.class);
        startActivity(intent);
    }

    public void opsiKeluarga(View view) {
        Intent intent = new Intent(PilihanLogin.this, LoginUmum.class);
        startActivity(intent);
    }
}