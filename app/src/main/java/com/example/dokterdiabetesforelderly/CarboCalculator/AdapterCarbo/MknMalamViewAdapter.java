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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MknMalamViewAdapter extends RecyclerView.Adapter<MknMalamViewAdapter.viewHolder> {
    private ArrayList<PoolData> mknMalamList;
    private Context context;

    public MknMalamViewAdapter(Context mycontext, ArrayList<PoolData> list){
        this.context = mycontext;
        this.mknMalamList = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layouttampilanmenu,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        //holder.itemView.setTag(position);
        holder.txNamaMenu.setText(mknMalamList.get(position).getNama());
        holder.txCarboMenu.setText(mknMalamList.get(position).getCarbo());
        //holder.buttonHapus.setTag(mknMalamList.get(position));
        holder.buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("DataMakanMalam")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    //dataSnapshot.equals(mknMalamList.get(position));
                                    //dataSnapshot.getKey();
                                    dataSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                Toast.makeText(v.getContext(), "Data DiDihapus", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mknMalamList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txNamaMenu, txCarboMenu;
        ImageButton buttonHapus;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txNamaMenu = itemView.findViewById(R.id.namaMenu);
            txCarboMenu = itemView.findViewById(R.id.carboMenu);
            buttonHapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}
