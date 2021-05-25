package com.example.dokterdiabetesforelderly.Resep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.Artikel.ArtikelAdapter;
import com.example.dokterdiabetesforelderly.Artikel.ArtikelData;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class Resep extends AppCompatActivity {
    private RecyclerView recyclerViewResep;
    private ArrayList<ModelResep> listResep = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep);

        recyclerViewResep = findViewById(R.id.listResep);
        recyclerViewResep.setHasFixedSize(true);

        listResep.addAll(ResepData.getListData());
        showRecyclerListResep();
    }

    private void showRecyclerListResep() {
        recyclerViewResep.setLayoutManager(new LinearLayoutManager(this));
        ResepAdapter resepAdapter = new ResepAdapter(listResep);
        recyclerViewResep.setAdapter(resepAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(Resep.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}