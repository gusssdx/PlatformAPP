package com.example.per2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu4 extends AppCompatActivity {
    private EditText edtSide;
    private Button btnCalculate;
    private ImageView btnBack;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu4);

        edtSide = findViewById(R.id.edt_side);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke MainActivity
        });

        btnCalculate.setOnClickListener(v -> {
            String inputSide = edtSide.getText().toString().trim();

            if (TextUtils.isEmpty(inputSide)) {
                edtSide.setError("Field ini tidak boleh kosong");
                return;
            }

            double side = Double.parseDouble(inputSide);
            double volume = Math.pow(side, 3);

            tvResult.setText("Volume Kubus: " + String.format("%.2f", volume));
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
