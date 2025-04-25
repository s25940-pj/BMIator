package com.example.bmiator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

/**
 * BMI Calculator App
 * Author: Maksymilian Mrówka
 * <p>
 * This is a simple Android application that calculates the Body Mass Index (BMI)
 * based on the user's weight (in kilograms) and height (in centimeters).
 * <p>
 * How to run this app:
 * 1. Open the project in Android Studio.
 * 2. Make sure Gradle is synced (File > Sync Project with Gradle Files).
 * 3. Connect a real Android device or start an emulator.
 * 4. Click "Run" to install and launch the app.
 * <p>
 * On launch, the user can enter weight and height, and press "Calculate BMI".
 * The app will display the BMI value and a status (Underweight, Optimal, Overweight, Obesity).
 */
public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView bmiResult, bmiStatus;
    Button openCalorieCalculatorButton;

    /**
     * Initializes the activity and sets up UI element bindings and button listener.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        bmiResult = findViewById(R.id.bmiResult);
        bmiStatus = findViewById(R.id.bmiStatus);
        openCalorieCalculatorButton = findViewById(R.id.openCalorieCalculatorButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
        openCalorieCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalorieIntakeCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Retrieves user input, validates it, calculates BMI and updates the UI.
     * Handles invalid input and division by zero cases.
     */
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

            String status = calculateBmiStatus(weight, heightCm);

            bmiStatus.setText("Status: " + status);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numeric values", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calculates the BMI (Body Mass Index) status based on weight in kilograms and height in centimeters.
     */
    public static String calculateBmiStatus(float weight, float heightCm) {
        if (weight <= 0 || heightCm <= 0) {
            return "Error";
        }

        float heightM = heightCm / 100;
        float bmi = weight / (heightM * heightM);

        if (bmi < 18.5f) {
            return "Underweight";
        } else if (bmi < 25f) {
            return "Optimal";
        } else if (bmi < 30f) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
