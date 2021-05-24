package com.example.dokterdiabetesforelderly.CarboCalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarbocalculatorAdapter extends RecyclerView.Adapter<CarbocalculatorAdapter.viewHolder> {
    private Context context;
    private ArrayList<PoolData> dataList;
    DatabaseReference databaseReference;
    Map<String, Object> values = new HashMap<>();

    public CarbocalculatorAdapter(Context myContext, ArrayList<PoolData> list){
        this.context = myContext;
        this.dataList = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layouttampilanmenu,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txNamaMenu.setText(dataList.get(position).getNama());
        holder.txCarboMenu.setText(dataList.get(position).getCarbo());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txNamaMenu, txCarboMenu;

        public viewHolder(View itemView) {
            super(itemView);
            txNamaMenu = itemView.findViewById(R.id.namaMenu);
            txCarboMenu = itemView.findViewById(R.id.carboMenu);

        }
    }
}
