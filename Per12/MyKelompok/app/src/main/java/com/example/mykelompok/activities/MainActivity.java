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

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText etName, etNim, etEmail, etKlp, etApp;
    private Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        etEmail = findViewById(R.id.edt_email);
        etKlp = findViewById(R.id.edt_klp);
        etApp = findViewById(R.id.edt_app);
        btnSave = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        btnSave.setOnClickListener(v -> {
            String nim = etNim.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String klp = etKlp.getText().toString().trim();
            String app = etApp.getText().toString().trim();


            if (nim.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: NIM harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nama harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Email harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (klp.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nomor Kelompok harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (app.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nama Aplikasi harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addUserDetail(nim, name, email, klp, app);
                etName.setText("");
                etNim.setText("");
                etEmail.setText("");
                etKlp.setText("");
                etApp.setText("");
                Toast.makeText(MainActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
            }
        });

        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListKelompokActivity.class);
            startActivity(intent);
        });
    }
}
