package com.example.dokterdiabetesforelderly.LoginLansia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {
    //variable
    EditText numberAkun;
    EditText passwordAkun;
    Button loginButton;
    ImageView lihatPassword;

    private DatabaseReference dbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //declare variable
        numberAkun = findViewById(R.id.userAkun);
        passwordAkun = findViewById(R.id.passAkun);
        loginButton = findViewById(R.id.buttonLogin);
        lihatPassword = findViewById(R.id.lihatPass);

        //show/hide Password
        lihatPassword.setOnClickListener(v -> {
            //ShowHidePass();
            if(lihatPassword.getId()==R.id.lihatPass){

                if(passwordAkun.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    lihatPassword.setImageResource(R.drawable.ic_baseline_visibilitypass_off);

                    //Show Password
                    passwordAkun.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    lihatPassword.setImageResource(R.drawable.ic_baseline_visibilitypass);

                    //Hide Password
                    passwordAkun.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }

        });

        //login();
        dbLogin = FirebaseDatabase.getInstance().getReference("userlansia");
        loginButton.setOnClickListener(v -> {
            String inputedNomor = Objects.requireNonNull(numberAkun.getText().toString().trim());
            String inputedPass = Objects.requireNonNull(passwordAkun.getText().toString().trim());

            Query checkUser = dbLogin.orderByChild("nomor").equalTo(inputedNomor);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        numberAkun.setError(null);

                        String passFromDB = snapshot.child(inputedNomor).child("pass").getValue().toString();

                        if (passFromDB != null && passFromDB.equals(inputedPass)) {

                            numberAkun.setError(null);

                            String nomorFromDB = snapshot.child(inputedNomor).child("nomor").getValue().toString();

                            Intent intent = new Intent(getApplicationContext(), MainMenu.class);

                            intent.putExtra("nomor", nomorFromDB);

                            Toast.makeText(Login.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }else{
                            passwordAkun.setError("Password Salah");
                        }
                    } else {
                        numberAkun.setError("Nomor Tidak Ditemukan");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }

    /*private void login() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numberAkun.getText().toString().equals("081804109331")&&passwordAkun.getText().toString().equals("123456")){
                    Toast.makeText(Login.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainMenu.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"Login Gagal, Periksa kembali username dan password anda",Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/

    public void masukRegistrasiLansia(View view) {
        Intent intent = new Intent(Login.this,Registrasi.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}