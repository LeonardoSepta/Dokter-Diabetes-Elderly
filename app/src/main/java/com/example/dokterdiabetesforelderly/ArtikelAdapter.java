package com.example.dokterdiabetesforelderly;

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

import java.util.ArrayList;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ListViewHolder> {
    private ArrayList<ModelArtikel> listArtikel;
    Context context;

    public ArtikelAdapter(/*Context context,*/ ArrayList<ModelArtikel> list){
        //this.context = context;
        this.listArtikel = list;
    }




    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlistartikel,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ModelArtikel artikel = listArtikel.get(position);
        Glide.with(holder.itemView.getContext()).load(artikel.getPhoto()).apply(new RequestOptions().override(55,55)).into(holder.imgPhoto);
        holder.judulTextArtikel.setText(artikel.getJudul());
        holder.detailTextArtikel.setText(artikel.getDetail());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailArtikel.class);
            intent.putExtra("item_extra",listArtikel.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listArtikel.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView judulTextArtikel, detailTextArtikel;
        //input data ke layoutlistartikel
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_artikel);
            judulTextArtikel = itemView.findViewById(R.id.judulArtikel);
            detailTextArtikel = itemView.findViewById(R.id.detailArtikel);
        }
    }
}
