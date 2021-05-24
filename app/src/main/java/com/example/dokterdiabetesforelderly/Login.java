package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;

public class Login extends AppCompatActivity {
    EditText numberAkun;
    EditText passwordAkun;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        numberAkun = (EditText) findViewById(R.id.userAkun);
        passwordAkun = (EditText) findViewById(R.id.passAkun);
        loginButton = (Button) findViewById(R.id.buttonLogin);

        login();
    }

    private void login() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numberAkun.getText().toString().equals("081804109331")&&passwordAkun.getText().toString().equals("123456")){
                    Toast.makeText(Login.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainMenu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"Login Gagal, Periksa kembali username dan password anda",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}