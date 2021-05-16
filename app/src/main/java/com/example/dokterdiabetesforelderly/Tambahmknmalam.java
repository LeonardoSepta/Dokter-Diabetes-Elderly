package com.example.dokterdiabetesforelderly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tambahmknmalam extends AppCompatActivity {
    private RecyclerView mknmalamlist;
    private DatabaseReference mydb;
    //private ArrayList<PoolData> listArray;
    //private ArrayList<GetDataIntent> data;
    private ArrayList<PoolData> listArray;
    //private CarboCalAdapter adapter;
    private DataAdapterMknMalam mknMalamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmknmalam);

        mknmalamlist = findViewById(R.id.mknmalam);
        mknmalamlist.setLayoutManager(new LinearLayoutManager(this));
        mknmalamlist.setHasFixedSize(true);
        mydb = FirebaseDatabase.getInstance().getReference();
        listArray = new ArrayList<PoolData>();

        CheckData();
        AmbilDataFirebase();
    }

    private void CheckData() {
        if (listArray != null){
            listArray.clear();
            if (mknMalamAdapter != null){
                mknMalamAdapter.notifyDataSetChanged();
            }
        }
        listArray = new ArrayList<>();
    }

    private void AmbilDataFirebase() {
        Query query = mydb.child("makanmalam");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckData();
                for (DataSnapshot dataMknMalam:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    /* PoolData poolData = dataMknMalam.getValue(PoolData.class);*/
                    poolData.setNama(dataMknMalam.child("nama").getValue().toString());
                    poolData.setCarbo(dataMknMalam.child("carbo").getValue().toString());
                    //poolData.setCarbo(dataMknMalam.child("carbo").getValue().toString());

                    listArray.add(poolData);
                }
                mknMalamAdapter = new DataAdapterMknMalam(getApplicationContext(),listArray);
                mknmalamlist.setAdapter(mknMalamAdapter);
                mknMalamAdapter.notifyDataSetChanged();
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