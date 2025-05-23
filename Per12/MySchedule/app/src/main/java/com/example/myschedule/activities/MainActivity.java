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

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText etMatkul, etJam;
    private Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        etMatkul = findViewById(R.id.edt_matkul);
        etJam = findViewById(R.id.edt_jam);
        btnSave = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        btnSave.setOnClickListener(v -> {
            String matkul = etMatkul.getText().toString().trim();
            String jam = etJam.getText().toString().trim();

            if (matkul.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: NIM harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (jam.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nama harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addUserDetail(matkul, jam);
                etMatkul.setText("");
                etJam.setText("");
                Toast.makeText(MainActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
            }
        });

        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListJadwalActivity.class);
            startActivity(intent);
        });
    }
}
