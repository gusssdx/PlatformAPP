package com.example.uasapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY = 5000; // 5 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // layout splash

        // Ambil ImageView dari layout
        ImageView imageView = findViewById(R.id.imageView);

        // Decode bitmap dengan ukuran optimal (misalnya 400x400)
        Bitmap bitmap = ImageUtils.decodeSampledBitmapFromResource(
                getResources(),
                R.drawable.logo_upnvj_1,
                400,
                400
        );

        // Set bitmap ke ImageView
        imageView.setImageBitmap(bitmap);

        // Setelah delay, lanjut ke FavoriteFoodActivity
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, FavoriteFoodActivity.class));
            finish(); // Splash screen ditutup
        }, SPLASH_DELAY);
    }
}
