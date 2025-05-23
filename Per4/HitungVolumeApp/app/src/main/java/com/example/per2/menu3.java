package com.example.per2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu3 extends AppCompatActivity {
    private EditText edtRadius;
    private Button btnCalculate;
    private ImageView btnBack;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        edtRadius = findViewById(R.id.edt_radius);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke MainActivity
        });

        btnCalculate.setOnClickListener(v -> {
            String inputRadius = edtRadius.getText().toString().trim();

            if (TextUtils.isEmpty(inputRadius)) {
                edtRadius.setError("Field ini tidak boleh kosong");
                return;
            }

            double radius = Double.parseDouble(inputRadius);
            double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);

            tvResult.setText("Volume Bola: " + String.format("%.2f", volume));
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
