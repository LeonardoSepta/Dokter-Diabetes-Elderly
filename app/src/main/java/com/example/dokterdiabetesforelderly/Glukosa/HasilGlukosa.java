package com.example.dokterdiabetesforelderly.Glukosa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.TextView;

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
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HasilGlukosa extends AppCompatActivity implements ValueEventListener {
    FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = mydb.getReference();
    DatabaseReference gulaDarah = databaseReference.child("DataGlukosa");
    String dataGulaDarah;

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
        entries.add(new BarEntry(160f, 0));

        BarDataSet barDataSet = new BarDataSet(entries, "Cells");

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