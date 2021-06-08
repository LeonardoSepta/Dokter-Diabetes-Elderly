package com.example.dokterdiabetesforelderly.Konsultasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum.ModelKonsultasi;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class KonsultasiUserAdapter extends RecyclerView.Adapter<KonsultasiUserAdapter.viewHolder> {
    private ArrayList<ModelKonsultasiUser> listKonsul;
    Context context;

    public KonsultasiUserAdapter(Context myContext, ArrayList<ModelKonsultasiUser> list){
        this.listKonsul = list;
        this.context = myContext;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlistkonsultasi, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.judulKonsul.setText(listKonsul.get(position).getJudul());
        holder.detailkonsul.setText(listKonsul.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return listKonsul.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView judulKonsul , detailkonsul;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            judulKonsul = itemView.findViewById(R.id.idKonsultasi);
            detailkonsul = itemView.findViewById(R.id.txKonsultasi);
        }
    }
}
