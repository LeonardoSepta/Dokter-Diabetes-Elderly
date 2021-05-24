package com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.DataAdapterMknSiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tambahmknsiang extends AppCompatActivity {
    private RecyclerView mknsianglist;
    private DatabaseReference mydb;
    //private ArrayList<PoolData> listArray;
    //private ArrayList<GetDataIntent> data;
    private ArrayList<PoolData> listArray;
    //private CarboCalAdapter adapter;
    private DataAdapterMknSiang mknSiangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmknsiang);

        mknsianglist = findViewById(R.id.mknsiang);
        mknsianglist.setLayoutManager(new LinearLayoutManager(this));
        mknsianglist.setHasFixedSize(true);
        mydb = FirebaseDatabase.getInstance().getReference();
        listArray = new ArrayList<PoolData>();

        CheckData();
        AmbilDataFirebase();
    }

    private void CheckData() {
        if (listArray != null){
            listArray.clear();
            if (mknSiangAdapter != null){
                mknSiangAdapter.notifyDataSetChanged();
            }
        }
        listArray = new ArrayList<>();
    }

    private void AmbilDataFirebase() {
        Query query = mydb.child("makansiang");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckData();
                for (DataSnapshot dataMknSiang:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataMknSiang.child("nama").getValue().toString());
                    poolData.setCarbo(dataMknSiang.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                mknSiangAdapter = new DataAdapterMknSiang(getApplicationContext(),listArray);
                mknsianglist.setAdapter(mknSiangAdapter);
                mknSiangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void back(View view) {
        finish();
    }
}