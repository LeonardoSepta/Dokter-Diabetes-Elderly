package com.example.dokterdiabetesforelderly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ListViewHolder> {
    private ArrayList<ModelPesan> listPesan;

    public PesanAdapter(ArrayList<ModelPesan> list){
        this.listPesan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutpesan,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ModelPesan modelPesan = listPesan.get(position);
        holder.judulTxPesan.setText(modelPesan.getJudul());
        holder.detailTxPesan.setText(modelPesan.getDetail());

    }

    @Override
    public int getItemCount() {
        return listPesan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView judulTxPesan, detailTxPesan;

        //input data ke layoutpesan
        ListViewHolder(View itemView) {
            super(itemView);
            judulTxPesan = itemView.findViewById(R.id.judulPesan);
            detailTxPesan = itemView.findViewById(R.id.detailPesan);
        }
    }
}
