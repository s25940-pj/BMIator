package com.example.bmiator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class BmiChartActivity extends AppCompatActivity {

    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_chart);

        chart = findViewById(R.id.bmiChart);

        ArrayList<Entry> bmiData = new ArrayList<>();
        bmiData.add(new Entry(1, 19.2f));
        bmiData.add(new Entry(2, 40.9f));
        bmiData.add(new Entry(3, 34.6f));
        bmiData.add(new Entry(4, 33.4f));
        bmiData.add(new Entry(5, 33.1f));
        bmiData.add(new Entry(6, 32.9f));
        bmiData.add(new Entry(7, 21.8f));

        LineDataSet dataSet = new LineDataSet(bmiData, "BMI (Ostatnie dni)");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);
        dataSet.setCircleColor(Color.BLUE);
        dataSet.setDrawValues(true);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        chart.getDescription().setText("Zmiany BMI w czasie");
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisRight().setEnabled(false);
        chart.invalidate();
    }
}
