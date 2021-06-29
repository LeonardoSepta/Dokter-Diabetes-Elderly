package com.example.dokterdiabetesforelderly.LoginUmum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dokterdiabetesforelderly.LoginLansia.Login;
import com.example.dokterdiabetesforelderly.LoginLansia.RegisLansiaModel;
import com.example.dokterdiabetesforelderly.LoginLansia.Registrasi;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrasiUmum extends AppCompatActivity {
    //variable
    private EditText usernameRegistrasi, emailRegistrasi, passRegistrasi, namaRegistrasi;
    private RadioGroup genderRegistrasi;
    private DatabaseReference dbRegisUmum;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_umum);

        usernameRegistrasi = findViewById(R.id.usernameRegis);
        emailRegistrasi = findViewById(R.id.emailRegis);
        passRegistrasi = findViewById(R.id.passRegisUmum);
        namaRegistrasi = findViewById(R.id.namaRegisUmum);
        genderRegistrasi = findViewById(R.id.genderRegisUmum);
        Button buttonRegistrasi = findViewById(R.id.btnRegisUmum);

        //Menyimpan data ke firebase setelah diclick
        buttonRegistrasi.setOnClickListener(v -> {
            dbRegisUmum = FirebaseDatabase.getInstance().getReference("userumum");
            int radioID = genderRegistrasi.getCheckedRadioButtonId();

            radioButton = findViewById(radioID);

            //Mendapatkan semua inputan
            String username = usernameRegistrasi.getText().toString();
            String email = emailRegistrasi.getText().toString();
            String password = passRegistrasi.getText().toString();
            String nama = namaRegistrasi.getText().toString();
            String gender = radioButton.getText().toString();

            if (username.isEmpty()){
                emailRegistrasi.setError("Username masih kosong");
                emailRegistrasi.requestFocus();
                return;
            }
            if (username.length() > 10){
                emailRegistrasi.setError("Username terlalu panjang");
                emailRegistrasi.requestFocus();
                return;
            }
            if (email.isEmpty()){
                emailRegistrasi.setError("Email masih kosong");
                emailRegistrasi.requestFocus();
                return;
            }
            if (password.isEmpty()){
                passRegistrasi.setError("Password masih kosong");
                passRegistrasi.requestFocus();
                return;
            }
            if (password.length() < 5 ){
                passRegistrasi.setError("Katasandi kurang panjang");
                passRegistrasi.requestFocus();
                return;
            }
            if (nama.isEmpty()){
                namaRegistrasi.setError("Nama masih kosong");
                namaRegistrasi.requestFocus();
                return;
            }

            RegisUmumModel regisUmumModel = new RegisUmumModel(username,email,password,nama,gender);

            dbRegisUmum.child(username).setValue(regisUmumModel).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    startActivity(new Intent(RegistrasiUmum.this, LoginUmum.class));
                }
            });
        });
    }

    public void pindahLoginUmum(View view) {
        Intent intent = new Intent(RegistrasiUmum.this, LoginUmum.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}