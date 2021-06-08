package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dokterdiabetesforelderly.R;

public class DetailKonsultasi extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_konsultasi);

        ImageView imgKonsultasi = findViewById(R.id.img_detail_Konsultasi);
        TextView txJudulKonsultasi = findViewById(R.id.textJudulKonsultasi);
        TextView txIdKonsultasi = findViewById(R.id.textIdKonsultasi);
        TextView txDetailKonsultasi = findViewById(R.id.textDetailKonsultasi);
        TextView txJawabanKonsultasi = findViewById(R.id.textJawabanKonsultasi);

        ModelKonsultasi modelKonsultasi = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (modelKonsultasi != null){
            //menampilkan gambar
            Glide.with(this).load(modelKonsultasi.getPhoto()).into(imgKonsultasi);
            txJudulKonsultasi.setText(modelKonsultasi.getJudul());
            txIdKonsultasi.setText(modelKonsultasi.getId());
            txDetailKonsultasi.setText(modelKonsultasi.getDetail());
            txJawabanKonsultasi.setText(modelKonsultasi.getJawaban());
        }
    }

    public void back(View view) {
        finish();
    }
}