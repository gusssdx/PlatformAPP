package com.example.bangundatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KerucutActivity extends AppCompatActivity {
    private EditText etJariJari, etTinggi;
    private Button btnHitung;
    private ImageView btnBack;
    private TextView tvHasil;
    private static final String STATE_RESULT = "state_result";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);

        etJariJari = findViewById(R.id.et_jari_jari);
        etTinggi = findViewById(R.id.et_tinggi);
        btnHitung = findViewById(R.id.btn_calculate);
        tvHasil = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

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
                if (etJariJari.getText().toString().isEmpty() ||
                        etTinggi.getText().toString().isEmpty()) {

                    Toast.makeText(KerucutActivity.this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
                    return; // Hentikan proses jika ada kolom yang kosong
                }
                double r = Double.parseDouble(etJariJari.getText().toString());
                double tinggi = Double.parseDouble(etTinggi.getText().toString());

                double volume = (1.0 / 3) * Math.PI * r * r * tinggi;
                tvHasil.setText("Volume Kerucut: " + String.format("%.1f", volume));
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
}
