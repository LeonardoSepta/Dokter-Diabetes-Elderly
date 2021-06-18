package com.example.dokterdiabetesforelderly.Glukosa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dokterdiabetesforelderly.CarboCalculator.AdapterCarbo.SarapanViewAdapter;
import com.example.dokterdiabetesforelderly.CarboCalculator.PoolData;
import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HasilGlukosa extends AppCompatActivity implements ValueEventListener {
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = mydb.getReference();
    DatabaseReference gulaDarah;
    String dataGulaDarah;
    private RecyclerView listGlukosa;
    ArrayList<ModelGlukosa> arrayList;
    private AdapterGlukosa adapterGlukosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_glukosa);

        //current date
        TextView textView = findViewById(R.id.dateHasilGlukosa);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        textView.setText(currentDate);

        //drawChart();
        BarChart barChart = (BarChart) findViewById(R.id.glukosaBarChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(90f, 0));

        BarDataSet barDataSet = new BarDataSet(entries, "Data");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Data Kadar Glukosa");

        BarData data = new BarData(labels, barDataSet);
        barChart.setData(data); // set the data and list of labels into chart
        barChart.setDescription("Kadar Glukosa Normal");
        barChart.setDescriptionTextSize(20);
        barChart.setDescriptionPosition(500,70);
        data.setValueTextSize(20);
        //barDataSet.setColor(Integer.parseInt("#C70039"));
        barDataSet.setValueTextSize(20);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(3000);

        //RecyclerView
        gulaDarah = FirebaseDatabase.getInstance().getReference();
        listGlukosa = (RecyclerView) findViewById(R.id.recyclerGlukosa);
        listGlukosa.setLayoutManager(new LinearLayoutManager(this));
        listGlukosa.setHasFixedSize(true);

        CheckDataGlukosa();
        AmbilDataFirebase();
    }

    private void AmbilDataFirebase() {
        Query query = gulaDarah.child("DataGlukosa");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CheckDataGlukosa();
                for (DataSnapshot dataGlukosa:snapshot.getChildren()){
                    ModelGlukosa modelGlukosa = new ModelGlukosa();
                    modelGlukosa.setDataglukosa(dataGlukosa.child("DataGulaDarah").getValue().toString());

                    arrayList.add(modelGlukosa);
                }
                adapterGlukosa = new AdapterGlukosa(getApplicationContext(),arrayList);
                listGlukosa.setAdapter(adapterGlukosa);
                adapterGlukosa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void CheckDataGlukosa() {
        if (arrayList != null){
            arrayList.clear();
            if (adapterGlukosa != null){
                adapterGlukosa.notifyDataSetChanged();
            }
        }
        arrayList = new ArrayList<>();
    }

    public void back(View view) {
        Intent intent = new Intent(HasilGlukosa.this, MainMenu.class);
        startActivity(intent);
    }

    public void dataGlukosa(View view) {
        Intent intent = new Intent(HasilGlukosa.this, Glukosa.class);
        startActivity(intent);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}