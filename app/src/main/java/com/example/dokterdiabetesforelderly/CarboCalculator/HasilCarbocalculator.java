package com.example.dokterdiabetesforelderly.CarboCalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dokterdiabetesforelderly.MainMenu.MainMenu;
import com.example.dokterdiabetesforelderly.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HasilCarbocalculator extends AppCompatActivity {
    RecyclerView recyclercarbo;
    DatabaseReference mydb;
    ArrayList<CarbocalculatorAdapter> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_carbocalculator);

        mydb = FirebaseDatabase.getInstance().getReference();

        recyclercarbo = (RecyclerView) findViewById(R.id.recyclerHasilCarbo);
        recyclercarbo.setLayoutManager(new LinearLayoutManager(this));
        recyclercarbo.setHasFixedSize(true);

        //current date
        TextView textView = findViewById(R.id.dateHasilCarbo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        textView.setText(currentDate);

        //drawChart();
        BarChart barChart = (BarChart) findViewById(R.id.carboBarChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(350f, 0));

        BarDataSet barDataSet = new BarDataSet(entries, "Cells");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Data Karbohidrat");

        BarData data = new BarData(labels, barDataSet);
        barChart.setData(data); // set the data and list of labels into chart
        barChart.setDescription("Karbohidrat Normal");
        barChart.setDescriptionTextSize(20);
        barChart.setDescriptionPosition(500,60);
//        barDataSet.setColor(Integer.parseInt("#C70039"));
        barDataSet.setValueTextSize(20);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(3000);
    }

    public void back(View view) {
        Intent intent = new Intent(HasilCarbocalculator.this, MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void dataCarboCal(View view) {
        Intent intent = new Intent(HasilCarbocalculator.this, Carbocalculator.class);
        startActivity(intent);
    }
}