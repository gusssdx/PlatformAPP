package com.example.myschedule.activities;

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

import com.example.myschedule.R;
import com.example.myschedule.db.DBHelper;
import com.example.myschedule.model.Jadwal;

public class UpdateActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText etMatkul, etJam;
    private Button btnSave;
    private Jadwal jadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DBHelper(this);

        etMatkul = findViewById(R.id.edt_matkul);
        etJam = findViewById(R.id.edt_jam);
        btnSave = findViewById(R.id.btn_submit);

        // Ambil data Student dari Intent
        Intent intent = getIntent();
        jadwal = (Jadwal) intent.getSerializableExtra("user");

        // Tampilkan data ke input field
        etMatkul.setText(jadwal.getMatkul());
        etJam.setText(jadwal.getJam());

        // Simpan perubahan
        btnSave.setOnClickListener(v -> {
            String matkul = etMatkul.getText().toString();
            String jam = etJam.getText().toString();

            dbHelper.updateUser(jadwal.getId(), matkul, jam);
            Toast.makeText(UpdateActivity.this, "Update berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
