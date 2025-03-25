package com.example.bmiator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

/**
 * BMI Calculator App
 * Author: Maksymilian Mrówka
 *
 * This is a simple Android application that calculates the Body Mass Index (BMI)
 * based on the user's weight (in kilograms) and height (in centimeters).
 *
 * How to run this app:
 * 1. Open the project in Android Studio.
 * 2. Make sure Gradle is synced (File > Sync Project with Gradle Files).
 * 3. Connect a real Android device or start an emulator.
 * 4. Click "Run" to install and launch the app.
 *
 * On launch, the user can enter weight and height, and press "Calculate BMI".
 * The app will display the BMI value and a status (Underweight, Optimal, Overweight, Obesity).
 */
public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView bmiResult, bmiStatus;

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

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
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
