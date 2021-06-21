package com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
    private DatabaseReference mydb,dbDataMknSiang;
    private ArrayList<PoolData> listArray,arrayList;
    private SingleAdapterMknSiang mknSiangAdapter;
    private AutoCompleteTextView searchdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_add_mkn_siang);

        //declare RecyclerView
        mknSiang = findViewById(R.id.singleaddmknsiang);
        mknSiang.setLayoutManager(new LinearLayoutManager(this));
        mknSiang.setHasFixedSize(true);
        mydb = FirebaseDatabase.getInstance().getReference();
        listArray = new ArrayList<>();

        //declare for searchdata
        arrayList = new ArrayList<>();
        searchdata = findViewById(R.id.singleSearchMknSiang);
        dbDataMknSiang = FirebaseDatabase.getInstance().getReference("makansiang");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                populateSearch(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        dbDataMknSiang.addListenerForSingleValueEvent(eventListener);

        CheckData();
        AmbilDataFirebase();
    }

    private void populateSearch(DataSnapshot snapshot) {
        ArrayList<String> listData =new ArrayList<>();
        if (snapshot.exists())
        {
            for (DataSnapshot dataSnapshot:snapshot.getChildren())
            {
                String nama=dataSnapshot.child("nama").getValue(String.class);
                listData.add(nama);
            }
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listData);
            searchdata.setAdapter(adapter);
            searchdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String nama = searchdata.getText().toString();
                    searchNama(nama);
                }
            });
        }else{
            Log.d("sarapan", "No Data Found");
        }
    }

    private void searchNama(String nama) {
            Query query = dbDataMknSiang.orderByChild("nama").equalTo(nama);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                            PoolData namaMenu = new PoolData();
                            namaMenu.setNama(dataSnapshot.child("nama").getValue().toString());
                            namaMenu.setCarbo(dataSnapshot.child("carbo").getValue().toString());
                            arrayList.add(namaMenu);
                        }
                    /*ArrayAdapter adapterData = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listNamaMenu);
                    sarapan.setAdapter(adapterData);*/
                        mknSiangAdapter = new SingleAdapterMknSiang(getApplicationContext(),arrayList);
                        mknSiang.setAdapter(mknSiangAdapter);
                        mknSiangAdapter.notifyDataSetChanged();
                        /*sarapan.setVisibility(View.GONE);*/
                    }else{
                        Log.d("nama", "No Data Found");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
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