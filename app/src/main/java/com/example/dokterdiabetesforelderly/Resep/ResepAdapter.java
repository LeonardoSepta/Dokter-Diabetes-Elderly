package com.example.dokterdiabetesforelderly.Resep;

import android.content.Context;
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
import com.example.dokterdiabetesforelderly.Artikel.DetailArtikel;
import com.example.dokterdiabetesforelderly.Artikel.ModelArtikel;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.viewHolder> {
    private ArrayList<ModelResep> listResep;

    public ResepAdapter (ArrayList<ModelResep> list){
        this.listResep = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutresep,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelResep resep = listResep.get(position);
        holder.judulTextResep.setText(resep.getJudul());
        holder.detailTextResep.setText(resep.getDetail());
        holder.imgPhoto.setImageResource(resep.getImg());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailResep.class);
            intent.putExtra("item_extra",listResep.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView judulTextResep, detailTextResep;

        public viewHolder(View itemView) {
            super(itemView);
            judulTextResep = itemView.findViewById(R.id.judulResep);
            detailTextResep = itemView.findViewById(R.id.detailResep);
            imgPhoto = itemView.findViewById(R.id.imgResep);
        }
    }
}
