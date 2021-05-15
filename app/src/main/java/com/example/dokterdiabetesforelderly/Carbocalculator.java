package com.example.dokterdiabetesforelderly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Carbocalculator extends AppCompatActivity {
    private RecyclerView listSarapan, listMknSiang, listMknMlm;
    private DatabaseReference mydb, mknsiang, mknmalam;
    DatabaseReference sarapanDB;
    //private ArrayList<PoolData> listArray;
    //private ArrayList<GetDataIntent> data;
    private ArrayList<PoolData> listArray, listMakanSiang, listMakanMalam;
    //private CarboCalAdapter adapter;
    private DataAdapterMknMalam makanMalam;
    private DataAdapter sarapan;
    private DataAdapterMknSiang makanSiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbocalculator);

        mydb = FirebaseDatabase.getInstance().getReference();

        mknmalam = FirebaseDatabase.getInstance().getReference();
        mknsiang = FirebaseDatabase.getInstance().getReference();
        sarapanDB = FirebaseDatabase.getInstance().getReference("DataSarapan");

        listArray = new ArrayList<PoolData>();
        listSarapan = findViewById(R.id.listSarapan);
        listSarapan.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listSarapan.setNestedScrollingEnabled(false);
        listSarapan.setHasFixedSize(true);

        listMakanSiang = new ArrayList<PoolData>();
        listMknSiang = findViewById(R.id.listMakanSiang);
        listMknSiang.setLayoutManager(new LinearLayoutManager(this));
        listMknSiang.setNestedScrollingEnabled(false);
        listMknSiang.setHasFixedSize(true);

        listMakanMalam = new ArrayList<PoolData>();
        listMknMlm = findViewById(R.id.listMknMlm);
        listMknMlm.setLayoutManager(new LinearLayoutManager(this));
        listMknMlm.setNestedScrollingEnabled(false);
        listMknMlm.setHasFixedSize(true);

        CheckDataSarapan();
        AmbilDataSarapan();

        CheckDataMknSiang();
        AmbilDataMknSiang();

        CheckDataMknMalam();
        AmbilDataMknMlm();

    }

    private void AmbilDataSarapan() {
        /*Query query = mydb.child("DataSarapan");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataSarapan();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = dataSarapan.getValue(PoolData.class) ;
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                sarapan = new DataAdapter(getApplicationContext(),listArray);
                listSarapan.setAdapter(sarapan);
                sarapan.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        sarapanDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String karbo = snapshot.child("carbo").getValue(String.class);
                    String nama = snapshot.child("nama").getValue(String.class);
                    Log.d("TAG", "sarapan carbo"+karbo);
                    Log.d("TAG", "sarapan nama"+nama);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        PoolData poolData = dataSnapshot.getValue(PoolData.class);
                        listArray.add(poolData);
                    }
                    sarapan = new DataAdapter(getApplicationContext(),listArray);
                    listSarapan.setAdapter(sarapan);
                    sarapan.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataSarapan() {
        if (listArray != null){
            listArray.clear();
            if (sarapan != null){
                sarapan.notifyDataSetChanged();
            }
        }
        listArray = new ArrayList<>();
    }

    private void AmbilDataMknMlm() {
        Query query = mknmalam.child("DataMakanMalam");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataSarapan();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listMakanMalam.add(poolData);
                }
                makanMalam = new DataAdapterMknMalam(getApplicationContext(),listMakanMalam);
                listMknMlm.setAdapter(makanMalam);
                makanMalam.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknMalam() {
        if (listMakanMalam != null){
            listMakanMalam.clear();
            if (makanMalam != null){
                makanMalam.notifyDataSetChanged();
            }
        }
        listMakanMalam = new ArrayList<>();
    }

    private void AmbilDataMknSiang() {
        Query query = mknsiang.child("DataMakanSiang");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataSarapan();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listMakanSiang.add(poolData);
                }
                makanSiang = new DataAdapterMknSiang(getApplicationContext(),listMakanSiang);
                listMknSiang.setAdapter(makanSiang);
                makanSiang.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknSiang() {
        if (listMakanSiang != null){
            listMakanSiang.clear();
            if (makanSiang != null){
                makanSiang.notifyDataSetChanged();
            }
        }
        listMakanSiang = new ArrayList<>();
    }


    public void back(View view) {
        finish();
    }

    public void masukLayoutMknMalam(View view) {
        Intent intent = new Intent(Carbocalculator.this, Tambahmknmalam.class);
        startActivity(intent);
    }

    public void masukLayoutSarapan(View view) {
        Intent intent = new Intent(Carbocalculator.this, Tambahsarapan.class);
        startActivity(intent);
    }

    public void masukLayoutMknSiang(View view) {
        Intent intent = new Intent(Carbocalculator.this, Tambahmknsiang.class);
        startActivity(intent);
    }
}