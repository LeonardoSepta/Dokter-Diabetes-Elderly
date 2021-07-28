package com.example.dokterdiabetesforelderly.Konsultasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PertanyaanKonsultasi extends AppCompatActivity {
    Map<String, Object> values = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan_konsultasi);
    }


    public void back(View view) {
        finish();
    }

    public void buatPetanyaan(View view) {
        //declare edittext
        EditText pertanyaan = findViewById(R.id.detailPertanyaan);
        EditText judul = findViewById(R.id.judulPertanyaan);
        //instansiasi database Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //declare database yg dituju
        DatabaseReference mydb = database.getReference("DataKonsultasi");
        //memberi nilai pada database yg dituju
        String randomID = mydb.push().getKey();
        String judulKonsul = judul.getText().toString();
        String pertanyaanKonsul = pertanyaan.getText().toString();

        values.put("DataJudulPertanyaan",judulKonsul);
        values.put("DataPertanyaan",pertanyaanKonsul);

        mydb.child(randomID).setValue(values);

        Intent intent = new Intent(PertanyaanKonsultasi.this, KonsultasiUser.class);
        startActivity(intent);
    }
}