package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BeratBadan extends AppCompatActivity {
    private EditText numberTinggi,numberBB,tglBB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);
    }
    public void back(View view) {
        finish();
    }

    public void SimpanBB(View view) {
        //declare edittext
        numberBB = findViewById(R.id.numBB);
        tglBB = findViewById(R.id.tanggalBB);
        numberTinggi = findViewById(R.id.numTinggi);
        //instansiasi database Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //declare database yg dituju
        DatabaseReference mydb = database.getReference("DataGlukosa");
        //memberi nilai pada database yg dituju
        mydb.child("DataBB").setValue(numberBB.getText().toString());
        mydb.child("TglDataBB").setValue(tglBB.getText().toString());
        mydb.child("DataTinggi").setValue(numberTinggi.getText().toString());

        Intent intent = new Intent(BeratBadan.this, HasilBeratBadan.class);
        startActivity(intent);
    }
}