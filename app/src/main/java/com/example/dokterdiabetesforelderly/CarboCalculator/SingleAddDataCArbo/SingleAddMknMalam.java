package com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
    DatabaseReference mydb,dbDataMknMalam;
    private ArrayList<PoolData> listArray,arrayList;
    SingleAdapterMknMalam mknMalamAdapter;
    private AutoCompleteTextView searchdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_add_mkn_malam);

        //declare RecyclerView
        mknMalam = findViewById(R.id.singleaddmknmalam);
        mknMalam.setLayoutManager(new LinearLayoutManager(this));
        mknMalam.setHasFixedSize(true);
        mydb = FirebaseDatabase.getInstance().getReference();
        listArray = new ArrayList<>();

        //searchdata
        dbDataMknMalam = FirebaseDatabase.getInstance().getReference("makanmalam");
        arrayList = new ArrayList<>();
        searchdata = findViewById(R.id.singleSearchMknMalam);

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                populateSearch(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        dbDataMknMalam.addListenerForSingleValueEvent(eventListener);

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
        Query query = dbDataMknMalam.orderByChild("nama").equalTo(nama);
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

                    mknMalamAdapter = new SingleAdapterMknMalam(getApplicationContext(),arrayList);
                    mknMalam.setAdapter(mknMalamAdapter);
                    mknMalamAdapter.notifyDataSetChanged();

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