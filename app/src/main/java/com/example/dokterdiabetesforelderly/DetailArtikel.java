package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailArtikel extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        ImageView imgArtikel = findViewById(R.id.img_detail_artikel);
        TextView txJudulArtikel = findViewById(R.id.textJudulArtikel);
        TextView txDetailArtikel = findViewById(R.id.textDetailArtikel);

        ModelArtikel modelArtikel = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (modelArtikel != null){
            //menampilkan gambar
            Glide.with(this).load(modelArtikel.getPhoto()).into(imgArtikel);
            txJudulArtikel.setText(modelArtikel.getJudul());
            txDetailArtikel.setText(modelArtikel.getDetail());
        }
    }
    
    public void back(View view) {
        finish();
    }
}