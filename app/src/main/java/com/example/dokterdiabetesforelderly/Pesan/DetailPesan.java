package com.example.dokterdiabetesforelderly.Pesan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dokterdiabetesforelderly.Artikel.ModelArtikel;
import com.example.dokterdiabetesforelderly.R;

public class DetailPesan extends AppCompatActivity {
    public static final String ITEM_EXTRA = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesan);

        TextView txJudulPesan = findViewById(R.id.textJudulPesan);
        TextView txDetailPesan = findViewById(R.id.textDetailPesan);

        ModelPesan modelPesan = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (modelPesan != null){
            txJudulPesan.setText(modelPesan.getJudul());
            txDetailPesan.setText(modelPesan.getDetail());
        }
    }

    public void back(View view) {
        Intent intent = new Intent(DetailPesan.this, Pesan.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}