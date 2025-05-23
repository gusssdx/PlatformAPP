package com.example.per2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu2 extends AppCompatActivity {
    private EditText edtRadius, edtHeight;
    private Button btnCalculate;
    private ImageView btnBack;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        edtRadius = findViewById(R.id.edt_radius);
        edtHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke MainActivity
        });

        btnCalculate.setOnClickListener(v -> {
            String inputRadius = edtRadius.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            if (TextUtils.isEmpty(inputRadius) || TextUtils.isEmpty(inputHeight)) {
                tvResult.setText("Masukkan semua nilai!");
                return;
            }

            double radius = Double.parseDouble(inputRadius);
            double height = Double.parseDouble(inputHeight);
            double volume = (1.0 / 3) * Math.PI * radius * radius * height;

            tvResult.setText("Volume Kerucut: " + String.format("%.2f", volume));
        });

        // Mengembalikan hasil perhitungan saat rotasi layar
        if (savedInstanceState != null) {
            String savedResult = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(savedResult);
        }
    }

    // Menyimpan hasil perhitungan saat rotasi layar
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}