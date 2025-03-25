package com.example.bmiator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView bmiResult, bmiStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        bmiResult = findViewById(R.id.bmiResult);
        bmiStatus = findViewById(R.id.bmiStatus);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Enter your weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            float heightCm = Float.parseFloat(heightStr);
            float heightM = heightCm / 100;

            if (weight <= 0 || heightCm <= 0) {
                Toast.makeText(this, "Weight and height must be greater than zero", Toast.LENGTH_SHORT).show();
                return;
            }

            float bmi = weight / (heightM * heightM);
            bmiResult.setText("Your BMI: " + String.format("%.2f", bmi));

            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Optimal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obesity";
            }

            bmiStatus.setText("Status: " + status);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numeric values", Toast.LENGTH_SHORT).show();
        }
    }
}
