package com.example.dokterdiabetesforelderly.BeratBadanBMI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BeratBadan extends AppCompatActivity {
    private EditText numberTinggi,numberBB;
    Map<String, Object> values = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);

        //current date
        TextView textView = findViewById(R.id.dateBB);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        textView.setText(currentDate);
    }
    public void back(View view) {
        Intent intent = new Intent(BeratBadan.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void SimpanBB(View view) {
        //declare edittext
        numberBB = findViewById(R.id.numBB);
        numberTinggi = findViewById(R.id.numTinggi);

        /*tglBB = findViewById(R.id.tanggalBB);*/

        //instansiasi database Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //declare database yg dituju
        DatabaseReference mydb = database.getReference("DataBeratBadan");
        //memberi nilai pada database yg dituju
        String randomID = mydb.push().getKey();
        String DataBeratBadan = numberBB.getText().toString();
        String DataTinggiBadan = numberTinggi.getText().toString();
        values.put("DataBB",DataBeratBadan);
        values.put("DataTinggi",DataTinggiBadan);

        /*mydb.child("TglDataBB").setValue(tglBB.getText().toString());*/
        mydb.child(randomID).setValue(values);
        Intent intent = new Intent(BeratBadan.this, HasilBeratBadan.class);
        startActivity(intent);
    }
}