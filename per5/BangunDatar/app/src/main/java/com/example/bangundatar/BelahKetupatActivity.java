package com.example.bangundatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BelahKetupatActivity extends AppCompatActivity {
    private EditText etDiagonal1, etDiagonal2;
    private Button btnHitung;
    private ImageView btnBack;
    private TextView tvHasil;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);

        etDiagonal1 = findViewById(R.id.et_diagonal1);
        etDiagonal2 = findViewById(R.id.et_diagonal2);
        btnHitung = findViewById(R.id.btn_calculate);
        btnBack = findViewById(R.id.btn_back);
        tvHasil = findViewById(R.id.tv_result);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        if (savedInstanceState != null) {
            String savedResult = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(savedResult);
        }


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cek apakah input kosong
                if (etDiagonal1.getText().toString().isEmpty() ||
                        etDiagonal2.getText().toString().isEmpty()) {

                    Toast.makeText(BelahKetupatActivity.this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
                    return; // Hentikan proses jika ada kolom yang kosong
                }
                double d1 = Double.parseDouble(etDiagonal1.getText().toString());
                double d2 = Double.parseDouble(etDiagonal2.getText().toString());

                double luas = 0.5 * d1 * d2;
                tvHasil.setText("Luas Belah Ketupat: " +String.format("%.1f", luas));
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
}
