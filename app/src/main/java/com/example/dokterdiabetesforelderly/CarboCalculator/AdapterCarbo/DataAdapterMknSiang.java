package com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataAdapterMknSiang extends RecyclerView.Adapter<DataAdapterMknSiang.viewHolder> {
    private Context context;
    private ArrayList<PoolData> dataList;
    DatabaseReference databaseReference;
    Map<String, Object> values = new HashMap<>();

    //fungsi declare adapter
    public DataAdapterMknSiang(Context myContext, ArrayList<PoolData> list){
        this.context = myContext;
        this.dataList = list;
    }

    @NonNull
    @Override
    public DataAdapterMknSiang.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutmenu,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterMknSiang.viewHolder holder, int position) {
        holder.namaMenu.setText(dataList.get(position).getNama());
        holder.carboMenu.setText(dataList.get(position).getCarbo());
        holder.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference getDataSarapan = FirebaseDatabase.getInstance().getReference().child("DataMakanSiang");
                String randomID = getDataSarapan.push().getKey();
                String nama = dataList.get(position).getNama();
                String carbo = dataList.get(position).getCarbo();

                values.put("nama", nama);
                values.put("carbo",carbo);
                getDataSarapan.child(randomID).setValue(values);
                Toast.makeText(v.getContext(), "Masuk", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnRecycleListener {
        void onRecycleListener(int position);
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView namaMenu, carboMenu;
        ImageButton btnTambah;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            namaMenu = itemView.findViewById(R.id.namaMenu);
            carboMenu = itemView.findViewById(R.id.carboMenu);
            btnTambah = itemView.findViewById(R.id.btnTambah);
        }
    }
}
