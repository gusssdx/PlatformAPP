package com.example.uasapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        // Ambil ImageView dari layout
        ImageView imageView = findViewById(R.id.imageView);

        // Decode bitmap dengan ukuran optimal (misalnya 400x400)
        Bitmap bitmap = ImageUtils.decodeSampledBitmapFromResource(
                getResources(),
                R.drawable.img, // Ganti dengan nama gambar
                400,
                400
        );

        // Set bitmap ke ImageView
        imageView.setImageBitmap(bitmap);

        // Tombol Kembali
        Button btnBack = findViewById(R.id.btnKembali);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(DestinationActivity.this, FavoriteFoodActivity.class));
        });
    }
}
