package com.example.dokterdiabetesforelderly.Konsultasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum.Konsultasi;
import com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum.ModelKonsultasi;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.MainMenu.Profil;
import com.example.dokterdiabetesforelderly.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class KonsultasiUser extends AppCompatActivity {
    private Button buatKonsultasi;
    RecyclerView recyclerKonsultasi;
    DatabaseReference dbkonsultasi;
    ArrayList<ModelKonsultasiUser> listKonsul;
    KonsultasiUserAdapter konsulAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_user);

        dbkonsultasi = FirebaseDatabase.getInstance().getReference();

        listKonsul = new ArrayList<ModelKonsultasiUser>();
        recyclerKonsultasi = (RecyclerView) findViewById(R.id.listKonsultasi);
        recyclerKonsultasi.setLayoutManager(new LinearLayoutManager(this));
        recyclerKonsultasi.setHasFixedSize(true);

        CheckDataKonsul();
        AmbilDataKonsultasi();

        buatKonsultasi = (Button) findViewById(R.id.buatkonsultasi);
        buatKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPertanyaanKonsultasi();
            }
        });


      /*  //BottomNav
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navkonsultasi);
        bottomNavigationView.setSelectedItemId(R.id.konsultasiuser);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.konsultasiuserlain:
                        startActivity(new Intent(KonsultasiUser.this, Konsultasi.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.konsultasiuser:
                        return true;
                }
                return false;
            }
        });
        
*/
    }

    private void CheckDataKonsul() {
        if (listKonsul != null){
            listKonsul.clear();
            if (konsulAdapter != null){
                konsulAdapter.notifyDataSetChanged();
            }
        }
        listKonsul = new ArrayList<>();
    }

    private void AmbilDataKonsultasi(){
        Query query = dbkonsultasi.child("DataKonsultasi");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataKonsul();
                for (DataSnapshot dataKonsul:snapshot.getChildren()){
                    ModelKonsultasiUser modelKonsultasiUser = new ModelKonsultasiUser();
                    modelKonsultasiUser.setJudul(dataKonsul.child("DataJudulPertanyaan").getValue().toString());
                    modelKonsultasiUser.setDetail(dataKonsul.child("DataPertanyaan").getValue().toString());

                    listKonsul.add(modelKonsultasiUser);
                }
                konsulAdapter = new KonsultasiUserAdapter(getApplicationContext(),listKonsul);
                recyclerKonsultasi.setAdapter(konsulAdapter);
                konsulAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void OpenPertanyaanKonsultasi (){
        Intent intent = new Intent(KonsultasiUser.this, PertanyaanKonsultasi.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void back(View view) {
        /*Intent intent = new Intent(KonsultasiUser.this, Profil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);*/
        finish();
    }
}