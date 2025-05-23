package com.example.bangundatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TrapesiumActivity extends AppCompatActivity {
    private EditText etAlasAtas, etAlasBawah, etTinggi;
    private Button btnHitung;
    private ImageView btnBack;
    private TextView tvHasil;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);

        etAlasAtas = findViewById(R.id.et_alas_atas);
        etAlasBawah = findViewById(R.id.et_alas_bawah);
        etTinggi = findViewById(R.id.et_tinggi);
        btnHitung = findViewById(R.id.btn_calculate);
        tvHasil = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke MainActivity
        });

        if (savedInstanceState != null) {
            String savedResult = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(savedResult);
        }

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cek apakah input kosong
                if (etAlasAtas.getText().toString().isEmpty() ||
                        etAlasBawah.getText().toString().isEmpty() ||
                        etTinggi.getText().toString().isEmpty()) {

                    Toast.makeText(TrapesiumActivity.this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
                    return; // Hentikan proses jika ada kolom yang kosong
                }

                double alasAtas = Double.parseDouble(etAlasAtas.getText().toString());
                double alasBawah = Double.parseDouble(etAlasBawah.getText().toString());
                double tinggi = Double.parseDouble(etTinggi.getText().toString());

                double luas = 0.5 * (alasAtas + alasBawah) * tinggi;
                tvHasil.setText("Luas Trapesium: " + String.format("%.1f", luas));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
}
