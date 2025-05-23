package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult, tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tv_result);
        tvCategory = findViewById(R.id.tv_category);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI_RESULT", 0);

        tvResult.setText(String.format("BMI Anda: %.2f", bmi));
        tvCategory.setText(getBMICategory(bmi));
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Kategori: Kurus";
        } else if (bmi < 24.9) {
            return "Kategori: Normal";
        } else if (bmi < 29.9) {
            return "Kategori: Overweight";
        } else {
            return "Kategori: Obesitas";
        }
    }
}
