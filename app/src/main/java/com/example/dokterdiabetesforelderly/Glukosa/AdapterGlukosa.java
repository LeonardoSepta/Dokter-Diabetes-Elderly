package com.example.dokterdiabetesforelderly.Glukosa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterdiabetesforelderly.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdapterGlukosa extends RecyclerView.Adapter<AdapterGlukosa.viewHolder> {
    ArrayList<ModelGlukosa> arrayList;
    Context context;

    public AdapterGlukosa(Context mycontext, ArrayList<ModelGlukosa> list){
        this.arrayList = list;
        this.context = mycontext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutdataglukosa,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.dataGlukosa.setText(arrayList.get(position).getDataglukosa());

        /*currentdate*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        holder.dateGlukosa.setText(currentDate);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView dataGlukosa, dateGlukosa;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            dataGlukosa = itemView.findViewById(R.id.dataListGlukosa);
            dateGlukosa = itemView.findViewById(R.id.dateListGlukosa);
        }
    }
}
