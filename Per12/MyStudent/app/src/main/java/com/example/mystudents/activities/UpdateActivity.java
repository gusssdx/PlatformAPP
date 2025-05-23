package com.example.mystudents.activities;

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

import com.example.mystudents.R;
import com.example.mystudents.db.DBHelper;
import com.example.mystudents.model.Student;

public class UpdateActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText etName, etNim;
    private Button btnSave;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DBHelper(this);

        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        btnSave = findViewById(R.id.btn_submit);

        // Ambil data Student dari Intent
        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("user");

        // Tampilkan data ke input field
        etName.setText(student.getName());
        etNim.setText(student.getNim());

        // Simpan perubahan
        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String nim = etNim.getText().toString();

            dbHelper.updateUser(student.getId(), nim, name);
            Toast.makeText(UpdateActivity.this, "Update berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
