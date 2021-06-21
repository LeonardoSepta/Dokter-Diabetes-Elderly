package com.example.dokterdiabetesforelderly.LoginLansia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrasi extends AppCompatActivity {
    //variable
    private EditText nomorRegistrasi, passRegistrasi, namaRegistrasi;
    private RadioGroup genderRegistrasi;
    private Button buttonRegistrasi;
    private DatabaseReference dbRegis;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        nomorRegistrasi = findViewById(R.id.nomorRegis);
        passRegistrasi = findViewById(R.id.passRegis);
        namaRegistrasi = findViewById(R.id.namaRegis);
        genderRegistrasi = findViewById(R.id.genderRegis);
        buttonRegistrasi = findViewById(R.id.buttonRegis);

        //Menyimpan data ke firebase setelah diclick
        buttonRegistrasi.setOnClickListener(v -> {
            dbRegis = FirebaseDatabase.getInstance().getReference("userlansia");
            int radioID = genderRegistrasi.getCheckedRadioButtonId();

            radioButton = findViewById(radioID);

            //Mendapatkan semua inputan
            String nomor = nomorRegistrasi.getText().toString();
            String password = passRegistrasi.getText().toString();
            String nama = namaRegistrasi.getText().toString();
            String gender = radioButton.getText().toString();

            if (nomor.isEmpty()){
                nomorRegistrasi.setError("Nomor masih kosong");
                nomorRegistrasi.requestFocus();
                return;
            }
            if (nomor.length() < 10){
                nomorRegistrasi.setError("Nomor belum sesuai");
                nomorRegistrasi.requestFocus();
                return;
            }
            if (password.isEmpty()){
                passRegistrasi.setError("Password masih kosong");
                passRegistrasi.requestFocus();
                return;
            }
            if (password.length() < 5 ){
                passRegistrasi.setError("katasandi kurang panjang");
                passRegistrasi.requestFocus();
                return;
            }
            if (nama.isEmpty()){
                namaRegistrasi.setError("Nama masih kosong");
                namaRegistrasi.requestFocus();
                return;
            }

            RegisLansiaModel regisModel = new RegisLansiaModel(nomor,password,nama,gender);

            dbRegis.child(nomor).setValue(regisModel).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    startActivity(new Intent(Registrasi.this, Login.class));
                }
            });

        });
    }
}