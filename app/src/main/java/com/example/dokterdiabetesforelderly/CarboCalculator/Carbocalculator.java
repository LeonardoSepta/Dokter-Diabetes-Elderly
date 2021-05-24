package com.example.dokterdiabetesforelderly.CarboCalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.DataAdapterMknMalam;
import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.DataAdapterMknSiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.DataAdapterSarapan;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo.Tambahmknmalam;
import com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo.Tambahmknsiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo.Tambahsarapan;
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
    private ArrayList<PoolData> listArray, listMakanSiang, listMakanMalam;
    private DataAdapterMknMalam makanMalam;
    private DataAdapterSarapan sarapan;
    private DataAdapterMknSiang makanSiang;
    private CarbocalculatorAdapter carboAdapter;

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
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class) ;
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                carboAdapter = new CarbocalculatorAdapter(getApplicationContext(),listArray);
                listSarapan.setAdapter(carboAdapter);
                carboAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        sarapanDB.addListenerForSingleValueEvent(new ValueEventListener() {
            //syntax untuk sarapan
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String carbo = snapshot.child("carbo").getValue(String.class);
                    String nama = snapshot.child("nama").getValue(String.class);
                    Log.d("TAG", "sarapan carbo"+carbo);
                    Log.d("TAG", "sarapan nama"+nama);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        PoolData poolData = dataSnapshot.getValue(PoolData.class);
                        listArray.add(poolData);
                    }
                    carboAdapter = new CarbocalculatorAdapter(getApplicationContext(),listArray);
                    listSarapan.setAdapter(carboAdapter);
                    carboAdapter.notifyDataSetChanged();
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
            if (carboAdapter != null){
                carboAdapter.notifyDataSetChanged();
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
                carboAdapter = new CarbocalculatorAdapter(getApplicationContext(),listMakanMalam);
                listMknMlm.setAdapter(carboAdapter);
                carboAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknMalam() {
        if (listMakanMalam != null){
            listMakanMalam.clear();
            if (carboAdapter != null){
                carboAdapter.notifyDataSetChanged();
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
                carboAdapter = new CarbocalculatorAdapter(getApplicationContext(),listMakanSiang);
                listMknSiang.setAdapter(carboAdapter);
                carboAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknSiang() {
        if (listMakanSiang != null){
            listMakanSiang.clear();
            if (carboAdapter != null){
                carboAdapter.notifyDataSetChanged();
            }
        }
        listMakanSiang = new ArrayList<>();
    }


    public void back(View view) {
        Intent intent = new Intent(Carbocalculator.this, MainMenu.class);
        startActivity(intent);
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

    public void simpanCarbo(View view) {
        Intent intent = new Intent(Carbocalculator.this, HasilCarbocalculator.class);
        startActivity(intent);
    }
}