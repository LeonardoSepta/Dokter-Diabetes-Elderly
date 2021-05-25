package com.example.dokterdiabetesforelderly.Resep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dokterdiabetesforelderly.Artikel.ModelArtikel;
import com.example.dokterdiabetesforelderly.R;

public class DetailResep extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);

        ImageView imgResep = findViewById(R.id.img_detail_resep);
        TextView txJudulResep = findViewById(R.id.textJudulResep);
        TextView txDetailResep = findViewById(R.id.textDetailResep);

        ModelResep modelResep = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (modelResep != null){
            //menampilkan gambar
            txJudulResep.setText(modelResep.getJudul());
            txDetailResep.setText(modelResep.getDetail());
            imgResep.setImageResource(modelResep.getImg());
        }
    }

    public void back(View view) {
        finish();
    }
}