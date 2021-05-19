package com.example.dokterdiabetesforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HasilGlukosa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_glukosa);
        //drawChart();
        BarChart barChart = (BarChart) findViewById(R.id.glukosaBarChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(160f, 0));

        BarDataSet barDataSet = new BarDataSet(entries, "Cells");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("25/05/2021");

        BarData data = new BarData(labels, barDataSet);
        barChart.setData(data); // set the data and list of labels into chart
        barChart.setDescription("Kadar Glukosa Normal");
        barChart.setDescriptionTextSize(20);
        //barDataSet.setColor(Integer.parseInt("#C70039"));
        barDataSet.setValueTextSize(20);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(3000);
    }

    public void back(View view) {
        Intent intent = new Intent(HasilGlukosa.this, MainMenu.class);
        startActivity(intent);
    }

    public void dataGlukosa(View view) {
        Intent intent = new Intent(HasilGlukosa.this, Glukosa.class);
        startActivity(intent);
    }
}