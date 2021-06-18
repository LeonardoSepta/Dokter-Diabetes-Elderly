package com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.AdapterSingleAddData.SingleAdapterMknSiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.AdapterSingleAddData.SingleAdapterSarapan;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SingleAddMknSiang extends AppCompatActivity {
    private RecyclerView mknSiang;
    private DatabaseReference mydb;
    private ArrayList<PoolData> listArray;
    private SingleAdapterMknSiang mknSiangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_add_mkn_siang);

        //declare RecyclerView
        mknSiang = findViewById(R.id.singleaddmknsiang);
        mknSiang.setLayoutManager(new LinearLayoutManager(this));
        mknSiang.setHasFixedSize(true);
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
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                mknSiangAdapter = new SingleAdapterMknSiang(getApplicationContext(),listArray);
                //set to RecyclerView
                mknSiang.setAdapter(mknSiangAdapter);
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