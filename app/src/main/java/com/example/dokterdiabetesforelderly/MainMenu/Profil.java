package com.example.dokterdiabetesforelderly.MainMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ApplicationExitInfo;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dokterdiabetesforelderly.MainActivity;
import com.example.dokterdiabetesforelderly.Pesan.Pesan;
import com.example.dokterdiabetesforelderly.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profil extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.profil);
        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.beranda:
                        startActivity(new Intent(Profil.this, MainMenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.pesan:
                        startActivity(new Intent(Profil.this, Pesan.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
                        return true;
                }
                return false;
            }
        });
        
        
    }

    public void exitApp(View view) {
        showAlertDialog();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Tutup Aplikasi ini ? ")
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        exit();
                        finish();
                        System.exit(0);

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    
    
    public  void exit(){
        Intent intent = new Intent(Profil.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    /*public void exit(View view) {
        startActivity(new Intent(Profil.this, MainActivity.class));
        finish();
    }*/
}