package com.example.dokterdiabetesforelderly.Glukosa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Glukosa extends AppCompatActivity {
    EditText numberGlukosa;
    EditText tglGlukosa;
    SwitchCompat puasa;
    ArrayList<ModelGlukosa> modelGlukosa;
    Map<String, Object> values = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glukosa);

        //current date
        TextView textView = findViewById(R.id.dateGlukosa);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        textView.setText(currentDate);

    }
    public void back(View view) {
        Intent intent = new Intent(Glukosa.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public EditText getNumberGlukosa() {
        return numberGlukosa;
    }

    public void setNumberGlukosa(EditText numberGlukosa) {
        this.numberGlukosa = numberGlukosa;
    }

    public void SimpanGlukosa(View view) {
        //declare edittext
        numberGlukosa = (EditText) findViewById(R.id.numGlukosa);

        puasa = (SwitchCompat) findViewById(R.id.puasa);
        //instansiasi database Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //declare database yg dituju
        DatabaseReference mydb = database.getReference("DataGlukosa");
        //memberi nilai pada database yg dituju
        String randomID = mydb.push().getKey();
        String Dataguladarah = numberGlukosa.getText().toString();
       /* String Tgldataglukosa = tglGlukosa.getText().toString();*/

        values.put("DataGulaDarah",Dataguladarah);

       /* values.put("TglDataGlukosa",Tgldataglukosa);*/

        mydb.child(randomID).setValue(values);
        //mydb.child("DataGulaDarah").setValue(DataGulaDarah);
        //mydb.child("TglDataGlukosa").setValue(TglDataGlukosa);

        Intent intent = new Intent(getApplicationContext(), HasilGlukosa.class);
        startActivity(intent);
    }
}