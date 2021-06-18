package com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.AdapterSingleAddData;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterdiabetesforelderly.CarboCalculator.Carbocalculator;
import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.CarboCalculator.SingleAddDataCArbo.SingleAddSarapan;
import com.example.dokterdiabetesforelderly.CarboCalculator.TambahDataCarbo.Tambahmknsiang;
import com.example.dokterdiabetesforelderly.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleAdapterSarapan extends RecyclerView.Adapter<SingleAdapterSarapan.viewHolder> {
    ArrayList<PoolData> sarapanList;
    Context context;
    Map<String, Object> values = new HashMap<>();

    public SingleAdapterSarapan(Context mycontext, ArrayList<PoolData> list){
        this.context = mycontext;
        this.sarapanList = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutmenu,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.txNamaMenu.setText(sarapanList.get(position).getNama());
        holder.txCarboMenu.setText(sarapanList.get(position).getCarbo());
        holder.buttonTambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DatabaseReference getDataSarapan = FirebaseDatabase.getInstance().getReference().child("DataSarapan");
                String randomID = getDataSarapan.push().getKey();
                String nama = sarapanList.get(position).getNama();
                String carbo = sarapanList.get(position).getCarbo();

                values.put("nama", nama);
                values.put("carbo",carbo);
                getDataSarapan.child(randomID).setValue(values);
                Toast.makeText(v.getContext(), "Data Ditambah", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), Carbocalculator.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sarapanList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        TextView txNamaMenu, txCarboMenu;
        ImageButton buttonTambah;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txNamaMenu = itemView.findViewById(R.id.namaMenu);
            txCarboMenu = itemView.findViewById(R.id.carboMenu);
            buttonTambah = itemView.findViewById(R.id.btnTambah);
        }
    }
}
