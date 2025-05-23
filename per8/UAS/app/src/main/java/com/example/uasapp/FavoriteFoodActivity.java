package com.example.uasapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FavoriteFoodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Harus dipanggil duluan
        setContentView(R.layout.activity_favorite_food); // Set layout dulu

        ImageView imageView = findViewById(R.id.imageView); // Baru ini bisa dipanggil
        Bitmap bitmap = ImageUtils.decodeSampledBitmapFromResource(
                getResources(),
                R.drawable.makanan_favorit,
                400,
                300
        );
        imageView.setImageBitmap(bitmap);

        Button btnNext = findViewById(R.id.btnWisata);
        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(FavoriteFoodActivity.this, DestinationActivity.class));
        });
    }
}
