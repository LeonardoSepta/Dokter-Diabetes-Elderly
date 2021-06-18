package com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SarapanViewAdapter extends RecyclerView.Adapter<SarapanViewAdapter.viewHolder> {
    private ArrayList<PoolData> sarapanList;
    private Context context;

    Map<String, Object> values = new HashMap<>();
    DatabaseReference sarapanDB;

    public SarapanViewAdapter(Context mycontext, ArrayList<PoolData> list){
        this.context = mycontext;
        this.sarapanList = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layouttampilanmenu,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder,final int position) {
        final PoolData dataID = sarapanList.get(position);

        sarapanDB = FirebaseDatabase.getInstance().getReference().child("DataSarapan").child("randomID");
        String randomID = sarapanDB.child("DataSarapan").push().getKey();
        randomID.equals(dataID);

        holder.txNamaMenu.setText(sarapanList.get(position).getNama());
        holder.txCarboMenu.setText(sarapanList.get(position).getCarbo());
        //holder.buttonHapus.setTag(sarapanList.get(position).getKey());
        holder.buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*sarapanDB.child(randomID).removeValue();*/

               sarapanDB = FirebaseDatabase.getInstance().getReference("DataSarapan");
               sarapanDB.removeValue();

               //FirebaseDatabase.getInstance().getReference("DataSarapan").child(sarapanList.get(position).getKey()).getRef().removeValue();

               /* FirebaseDatabase.getInstance().getReference().child("DataSarapan")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    //String randomID = dataSnapshot.getKey();
                                    //dataSnapshot.child(dataID.getKey()).getRef().removeValue();
                                    //dataSnapshot.getKey();
                                    dataSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });*/

             /* sarapanDB = FirebaseDatabase.getInstance().getReference("DataSarapan").child(dataID.getKey());
                  sarapanDB.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    //String randomID = dataSnapshot.getKey();
                                    //dataSnapshot.child(dataID.getKey()).getRef().removeValue();
                                    //dataSnapshot.getKey();
                                    dataSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });*/
                Toast.makeText(v.getContext(), "Data DiDihapus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sarapanList.size();
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

