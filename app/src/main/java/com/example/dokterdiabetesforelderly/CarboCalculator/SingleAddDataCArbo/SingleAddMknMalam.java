package com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.AdapterSingleAddData.SingleAdapterMknMalam;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.AdapterSingleAddData.SingleAdapterMknSiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo.AdapterTambahData.DataAdapterMknMalam;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SingleAddMknMalam extends AppCompatActivity {
    private RecyclerView mknMalam;
    DatabaseReference mydb;
    private ArrayList<PoolData> listArray;
    SingleAdapterMknMalam mknMalamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_add_mkn_malam);

        //declare RecyclerView
        mknMalam = findViewById(R.id.singleaddmknmalam);
        mknMalam.setLayoutManager(new LinearLayoutManager(this));
        mknMalam.setHasFixedSize(true);
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
                mknMalamAdapter = new SingleAdapterMknMalam(getApplicationContext(),listArray);
                mknMalam.setAdapter(mknMalamAdapter);
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