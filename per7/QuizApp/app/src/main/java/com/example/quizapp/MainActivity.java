package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnJadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJadwal = findViewById(R.id.jadwal_kuliah);
        btnJadwal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JadwalActivity.class);
            startActivity(intent);
        });
    }
}
