package com.example.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTrapesium, btnBelahKetupat, btnKerucut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrapesium = findViewById(R.id.btn_trapesium);
        btnBelahKetupat = findViewById(R.id.btn_belah_ketupat);
        btnKerucut = findViewById(R.id.btn_kerucut);

        btnTrapesium.setOnClickListener(this);
        btnBelahKetupat.setOnClickListener(this);
        btnKerucut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_trapesium) {
            startActivity(new Intent(this, TrapesiumActivity.class));
        } else if (v.getId() == R.id.btn_belah_ketupat) {
            startActivity(new Intent(this, BelahKetupatActivity.class));
        } else if (v.getId() == R.id.btn_kerucut) {
            startActivity(new Intent(this, KerucutActivity.class));
        }
    }
}
