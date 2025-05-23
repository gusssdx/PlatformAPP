package com.example.per2;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button menu1, menu2, menu3,menu4, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi tombol
        menu1 = findViewById(R.id.menu1);
        menu2 = findViewById(R.id.menu2);
        menu3 = findViewById(R.id.menu3);
        menu4 = findViewById(R.id.menu4);
        btnLogout = findViewById(R.id.btn_logout);

        // Event listener untuk setiap tombol menu
        menu1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, menu1.class)));
        menu2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, menu2.class)));
        menu3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, menu3.class)));
        menu4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, menu4.class)));

        // Logout
        btnLogout.setOnClickListener(v -> {
            finish();
        });
    }
}
