package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etWeight, etHeight;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etWeight.getText().toString().isEmpty() || etHeight.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
                } else {
                    double weight = Double.parseDouble(etWeight.getText().toString());
                    double height = Double.parseDouble(etHeight.getText().toString()) / 100; // cm ke meter

                    double bmi = weight / (height * height);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("BMI_RESULT", bmi);
                    startActivity(intent);
                }
            }
        });
    }
}
