package com.example.mykelompok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mykelompok.R;
import com.example.mykelompok.db.DBHelper;
import com.example.mykelompok.model.Kelompok;

public class UpdateActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText etName, etNim, etEmail, etKlp, etApp;
    private Button btnSave;
    private Kelompok kelompok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DBHelper(this);

        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        etEmail = findViewById(R.id.edt_email);
        etKlp = findViewById(R.id.edt_klp);
        etApp = findViewById(R.id.edt_app);
        btnSave = findViewById(R.id.btn_submit);

        // Ambil data Student dari Intent
        Intent intent = getIntent();
        kelompok = (Kelompok) intent.getSerializableExtra("user");

        // Tampilkan data ke input field
        etName.setText(kelompok.getName());
        etNim.setText(kelompok.getNim());
        etEmail.setText(kelompok.getEmail());
        etKlp.setText(kelompok.getKlp());
        etApp.setText(kelompok.getApp());

        // Simpan perubahan
        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String nim = etNim.getText().toString();
            String email = etEmail.getText().toString();
            String klp = etKlp.getText().toString();
            String app = etApp.getText().toString();

            dbHelper.updateUser(kelompok.getId(), nim, name, email, klp, app);
            Toast.makeText(UpdateActivity.this, "Update berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
