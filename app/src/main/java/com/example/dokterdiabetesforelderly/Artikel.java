package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Artikel extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{
    Button dropDownMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);
        //menu resource file dropdownartikel
        dropDownMenu = findViewById(R.id.ddMenuArtikel);
        dropDownMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //declare popupMenu
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),dropDownMenu);
                popupMenu.getMenuInflater().inflate(R.menu.dropdownartikel,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mainArtikel:
                                return true;
                            case R.id.artikelKesehatan:
                                startActivity(new Intent(Artikel.this,ArtikelKesehatan.class));
                                return true;
                            case R.id.artikelInfoDiabetes:
                                startActivity(new Intent(Artikel.this,ArtikelInfoDiabetes.class));
                                return true;
                        }
                        Toast.makeText(getApplicationContext(), "Kamu sudah memilih kategori Artikel" + menuItem.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
    public void back(View view) {
        Intent intent = new Intent(Artikel.this, MainMenu.class);
        startActivity(intent);

    }
}