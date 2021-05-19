package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Glukosa extends AppCompatActivity {
    EditText numberGlukosa;
    EditText tglGlukosa;
    SwitchCompat puasa;
    //private DatabaseReference database;

    public Glukosa(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glukosa);

    }
    public void back(View view) {
        finish();
    }

    public EditText getNumberGlukosa() {
        return numberGlukosa;
    }

    public void setNumberGlukosa(EditText numberGlukosa) {
        this.numberGlukosa = numberGlukosa;
    }

    public void SimpanGlukosa(View view) {
        //declare edittext
        numberGlukosa = findViewById(R.id.numGlukosa);
        tglGlukosa = findViewById(R.id.tanggalGlukosa);
        puasa = findViewById(R.id.puasa);
        //instansiasi database Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //declare database yg dituju
        DatabaseReference mydb = database.getReference("DataGlukosa");
        //memberi nilai pada database yg dituju
        mydb.child("DataGlukosa").setValue(numberGlukosa.getText().toString());
        mydb.child("TglDataGlukosa").setValue(tglGlukosa.getText().toString());

        Intent intent = new Intent(Glukosa.this, HasilGlukosa.class);
        startActivity(intent);
    }
}