package com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.DataAdapterSarapan;
import com.example.dokterdiabetesforelderly.CarboCalculator.Carbocalculator;
import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tambahsarapan extends AppCompatActivity implements DataAdapterSarapan.OnRecycleListener{
    private RecyclerView sarapan;
    private DatabaseReference mydb,dbDataSarapan;
    //private ArrayList<PoolData> listArray;
    //private ArrayList<GetDataIntent> data;
    private ArrayList<PoolData> listArray;
    //private CarboCalAdapter adapter;
    private DataAdapterSarapan sarapanAdapter;
    //private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahsarapan);

        sarapan = findViewById(R.id.sarapan);
        sarapan.setLayoutManager(new LinearLayoutManager(this));
        sarapan.setHasFixedSize(true);
        mydb = FirebaseDatabase.getInstance().getReference();
        listArray = new ArrayList<PoolData>();
        dbDataSarapan = FirebaseDatabase.getInstance().getReference().child("DataSarapan");

        CheckData();
        AmbilDataFirebase();
    }

    private void CheckData() {
        if (listArray != null){
            listArray.clear();
            if (sarapanAdapter != null){
                sarapanAdapter.notifyDataSetChanged();
            }
        }
        listArray = new ArrayList<>();
    }

    private void AmbilDataFirebase() {
        Query query = mydb.child("sarapan");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckData();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                sarapanAdapter = new DataAdapterSarapan(getApplicationContext(),listArray);
                sarapan.setAdapter(sarapanAdapter);
                sarapanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onRecycleListener(int position) {
        Log.d("TAG", "onRecycleListener: clicked");
        PoolData poolData = listArray.get(position);

        String posisiData = String.valueOf(position);
        Intent intent = new Intent(getApplicationContext(), Carbocalculator.class);
        intent.putExtra("posisiData", posisiData);
        intent.putExtra("Nama", poolData.getNama());
        intent.putExtra("Carbo", poolData.getCarbo());
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }

    /*public void savesarapan(View view) {
        finish();
    }*/
}