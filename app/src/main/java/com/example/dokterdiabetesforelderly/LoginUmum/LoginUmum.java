package com.example.dokterdiabetesforelderly.LoginUmum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dokterdiabetesforelderly.LoginLansia.Login;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginUmum extends AppCompatActivity {
    //variable

    EditText username;
    EditText passwordUser;
    Button loginButton;
    private DatabaseReference dbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_umum);

        //declare variable
        username = findViewById(R.id.usernameLogin);
        passwordUser = findViewById(R.id.passLogin);
        loginButton = findViewById(R.id.buttonLogin);

        //login
        dbLogin = FirebaseDatabase.getInstance().getReference("userumum");
        loginButton.setOnClickListener(v -> {
            String inputedUsername = Objects.requireNonNull(username.getText().toString().trim());
            String inputedPass = Objects.requireNonNull(passwordUser.getText().toString().trim());

            Query checkUser = dbLogin.orderByChild("username").equalTo(inputedUsername);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        username.setError(null);

                        String passFromDB = snapshot.child(inputedUsername).child("password").getValue().toString();

                        if (passFromDB != null && passFromDB.equals(inputedPass)) {

                            username.setError(null);

                            String usernameFromDB = snapshot.child(inputedUsername).child("username").getValue().toString();

                            Intent intent = new Intent(getApplicationContext(), MainMenu.class);

                            intent.putExtra("username", usernameFromDB);

                            Toast.makeText(LoginUmum.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }else{
                            passwordUser.setError("Password Salah");
                        }
                    } else {
                        username.setError("Username Tidak Ditemukan");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }

    public void masukRegistrasi(View view) {
        Intent intent = new Intent(LoginUmum.this, RegistrasiUmum.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}