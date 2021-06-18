package com.example.dokterdiabetesforelderly.CarboCalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.MknMalamViewAdapter;
import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.MknSiangViewAdapter;
import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.SarapanViewAdapter;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.SingleAddMknMalam;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.SingleAddMknSiang;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.SingleAddSarapan;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Carbocalculator extends AppCompatActivity {
    private RecyclerView recyclerSarapan, recyclerMknSiang, recyclerMknMlm;
    private DatabaseReference mknsarapan, mknsiang, mknmalam;
    DatabaseReference sarapanDB;
    //private ArrayList<PoolData> listArray;
    private ArrayList<PoolData> listSarapan, listMakanSiang, listMakanMalam;
    private SarapanViewAdapter sarapanViewAdapter;
    private MknSiangViewAdapter mknSiangViewAdapter;
    private MknMalamViewAdapter mknMalamViewAdapter;
    //private CarbocalculatorAdapter carboAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbocalculator);

        //current date
        TextView textView = findViewById(R.id.dateCarbo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        textView.setText(currentDate);

        mknsarapan = FirebaseDatabase.getInstance().getReference();
        mknmalam = FirebaseDatabase.getInstance().getReference();
        mknsiang = FirebaseDatabase.getInstance().getReference();
        sarapanDB = FirebaseDatabase.getInstance().getReference();

        listSarapan = new ArrayList<>();
        recyclerSarapan = findViewById(R.id.listSarapan);
        recyclerSarapan.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerSarapan.setNestedScrollingEnabled(false);
        recyclerSarapan.setHasFixedSize(true);

        listMakanSiang = new ArrayList<>();
        recyclerMknSiang = findViewById(R.id.listMakanSiang);
        recyclerMknSiang.setLayoutManager(new LinearLayoutManager(this));
        recyclerMknSiang.setNestedScrollingEnabled(false);
        recyclerMknSiang.setHasFixedSize(true);

        listMakanMalam = new ArrayList<>();
        recyclerMknMlm = findViewById(R.id.listMknMlm);
        recyclerMknMlm.setLayoutManager(new LinearLayoutManager(this));
        recyclerMknMlm.setNestedScrollingEnabled(false);
        recyclerMknMlm.setHasFixedSize(true);

        CheckDataSarapan();
        AmbilDataSarapan();

        CheckDataMknSiang();
        AmbilDataMknSiang();

        CheckDataMknMalam();
        AmbilDataMknMlm();

    }

    private void AmbilDataSarapan() {
        Query query = mknsarapan.child("DataSarapan");
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

                    listSarapan.add(poolData);
                }
                sarapanViewAdapter = new SarapanViewAdapter(getApplicationContext(),listSarapan);
                recyclerSarapan.setAdapter(sarapanViewAdapter);
                sarapanViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataSarapan() {
        if (listSarapan != null){
            listSarapan.clear();
            if (sarapanViewAdapter != null){
                sarapanViewAdapter.notifyDataSetChanged();
            }
        }
        listSarapan = new ArrayList<>();
    }

    private void AmbilDataMknMlm() {
        Query query = mknmalam.child("DataMakanMalam");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataMknMalam();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listMakanMalam.add(poolData);
                }
                mknMalamViewAdapter = new MknMalamViewAdapter(getApplicationContext(),listMakanMalam);
                recyclerMknMlm.setAdapter(mknMalamViewAdapter);
                mknMalamViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknMalam() {
        if (listMakanMalam != null){
            listMakanMalam.clear();
            if (mknMalamViewAdapter != null){
                mknMalamViewAdapter.notifyDataSetChanged();
            }
        }
        listMakanMalam = new ArrayList<>();
    }

    private void AmbilDataMknSiang() {
        Query query = mknsiang.child("DataMakanSiang");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataMknSiang();
                for (DataSnapshot dataSarapan:snapshot.getChildren()){
                    PoolData poolData = new PoolData();
                    //PoolData poolData = dataSarapan.getValue(PoolData.class);
                    poolData.setNama(dataSarapan.child("nama").getValue().toString());
                    poolData.setCarbo(dataSarapan.child("carbo").getValue().toString());

                    listMakanSiang.add(poolData);
                }
                mknSiangViewAdapter = new MknSiangViewAdapter(getApplicationContext(),listMakanSiang);
                recyclerMknSiang.setAdapter(mknSiangViewAdapter);
                mknSiangViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataMknSiang() {
        if (listMakanSiang != null){
            listMakanSiang.clear();
            if (mknSiangViewAdapter != null){
                mknSiangViewAdapter.notifyDataSetChanged();
            }
        }
        listMakanSiang = new ArrayList<>();
    }


    public void back(View view) {
        Intent intent = new Intent(Carbocalculator.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        //finish();
    }

    public void masukLayoutMknMalam(View view) {
        Intent intent = new Intent(Carbocalculator.this, SingleAddMknMalam.class);
        startActivity(intent);
    }

    public void masukLayoutSarapan(View view) {
        Intent intent = new Intent(Carbocalculator.this, SingleAddSarapan.class);
        startActivity(intent);
    }

    public void masukLayoutMknSiang(View view) {
        Intent intent = new Intent(Carbocalculator.this, SingleAddMknSiang.class);
        startActivity(intent);
    }

    public void simpanCarbo(View view) {
        Intent intent = new Intent(Carbocalculator.this, HasilCarbocalculator.class);
        startActivity(intent);
    }
}