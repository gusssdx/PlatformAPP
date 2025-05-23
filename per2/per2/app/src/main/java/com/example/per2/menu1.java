package com.example.per2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu1 extends AppCompatActivity implements View.OnClickListener {

    private EditText edtRadius, edtHeight;
    private Button btnCalculate;
    private ImageView btnBack;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        // Inisialisasi komponen UI
        edtRadius = findViewById(R.id.edt_radius);
        edtHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        // Menetapkan event listener pada tombol
        btnCalculate.setOnClickListener(this);

        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke MainActivity
        });
        // Mengecek apakah ada data yang disimpan saat perubahan orientasi
        if (savedInstanceState != null) {
            String savedResult = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(savedResult);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            // Mengambil nilai input dan menghapus spasi berlebih
            String inputRadius = edtRadius.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            // Validasi input
            if (TextUtils.isEmpty(inputRadius)) {
                isEmptyFields = true;
                edtRadius.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            // Jika semua input valid, lakukan perhitungan
            if (!isEmptyFields) {
                double radius = Double.parseDouble(inputRadius);
                double height = Double.parseDouble(inputHeight);

                double volume = Math.PI * radius * radius * height; // Rumus volume tabung
                tvResult.setText("Volume Tabung: " + String.format("%.1f", volume));
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}
