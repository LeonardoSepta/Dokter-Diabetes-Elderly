package com.example.dokterdiabetesforelderly.Resep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class Resep extends AppCompatActivity {
    private RecyclerView recyclerViewResep;
    private final ArrayList<ModelResep> listResep = new ArrayList<>();
    AutoCompleteTextView searchdata;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep);

        //recycler
        recyclerViewResep = findViewById(R.id.listResep);
        recyclerViewResep.setHasFixedSize(true);

        listResep.addAll(ResepData.getListData());
        showRecyclerListResep();

        //search data
        /*ArrayList<ModelResep> arrayList = new ArrayList<>();*/
        searchdata = findViewById(R.id.searchResep);


    }

    private void showRecyclerListResep() {
        recyclerViewResep.setLayoutManager(new LinearLayoutManager(this));
        ResepAdapter resepAdapter = new ResepAdapter(listResep);
        recyclerViewResep.setAdapter(resepAdapter);
    }

    public void back(View view) {
        finish();
        /*Intent intent = new Intent(Resep.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);*/
    }
}