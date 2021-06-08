package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class KonsultasiAdapter extends RecyclerView.Adapter<KonsultasiAdapter.viewHolder> {
    private ArrayList<ModelKonsultasi> listKonsultasi;

    public KonsultasiAdapter(ArrayList<ModelKonsultasi> list){
        this.listKonsultasi = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlistkonsultasi,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelKonsultasi konsultasi = listKonsultasi.get(position);
        Glide.with(holder.itemView.getContext()).load(konsultasi.getPhoto()).apply(new RequestOptions().override(55,55)).into(holder.imgPhoto);
        holder.idTextKonsultasi.setText(konsultasi.getId());
        holder.judulTextKonsultasi.setText(konsultasi.getJudul());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailKonsultasi.class);
            intent.putExtra("item_extra",listKonsultasi.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listKonsultasi.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView idTextKonsultasi, judulTextKonsultasi;

        public viewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_konsultasi);
            idTextKonsultasi = itemView.findViewById(R.id.idKonsultasi);
            judulTextKonsultasi = itemView.findViewById(R.id.txKonsultasi);
        }
    }
}
