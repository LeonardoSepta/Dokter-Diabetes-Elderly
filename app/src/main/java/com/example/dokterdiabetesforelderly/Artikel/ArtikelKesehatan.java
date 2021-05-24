package com.example.dokterdiabetesforelderly.Artikel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class ArtikelKesehatan extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    Button dropDownMenu;
    private RecyclerView recyclerViewArtikel;
    private ArrayList<ModelArtikel> listArtikel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_kesehatan);

        recyclerViewArtikel = findViewById(R.id.listArtikelKesehatan);
        recyclerViewArtikel.setHasFixedSize(true);
        listArtikel.addAll(ArtikelKesehatanData.getListData());
        showRecyclerListArtikel();

        /*//menu resource file dropdownartikel
        dropDownMenu = findViewById(R.id.ddMenuArtikelKesehatan);
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
                                startActivity(new Intent(ArtikelKesehatan.this,Artikel.class));
                                return true;
                            case R.id.artikelKesehatan:
                                return true;
                            case R.id.artikelInfoDiabetes:
                                startActivity(new Intent(ArtikelKesehatan.this,ArtikelInfoDiabetes.class));
                                return true;
                        }
                        Toast.makeText(getApplicationContext(), "Kamu sudah memilih kategori Artikel" + menuItem.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });*/
    }

    private void showRecyclerListArtikel(){
        recyclerViewArtikel.setLayoutManager(new LinearLayoutManager(this));
        ArtikelAdapter artikelAdapter = new ArtikelAdapter(listArtikel);
        recyclerViewArtikel.setAdapter(artikelAdapter);


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    public void back(View view) {
        Intent intent = new Intent(ArtikelKesehatan.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}