package com.example.quizapp;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.graphics.Typeface;

public class JadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);



        TableLayout tableLayout = findViewById(R.id.tableJadwal);

        // Data jadwal (hari dan daftar mata kuliah)
        String[][] jadwal = {
                {"Senin", "Bahasa Inggris"},
                {"Selasa", "Teori Bahasa dan Automata\nKomputasi Paralel dan Terdistribusi\nPPL Berorientasi Service\nPembelajaran Mesin"},
                {"Kamis", "Pengembangan Aplikasi Permainan\nAnalisis dan Desain Perangkat Lunak"},
                {"Jumat", "Praktikum PBP\nPemrograman Berbasis Platform"}
        };

        for (String[] hari : jadwal) {
            TableRow row = new TableRow(this);

            TextView hariText = new TextView(this);
            hariText.setText(hari[0]);
            hariText.setTypeface(null, Typeface.BOLD);
            hariText.setPadding(8, 8, 8, 8);
            hariText.setGravity(Gravity.START);
            hariText.setTextColor(getResources().getColor(android.R.color.black));

            TextView matkulText = new TextView(this);
            matkulText.setText(hari[1]);
            matkulText.setPadding(8, 8, 8, 8);
            matkulText.setTextColor(getResources().getColor(android.R.color.black));

            row.addView(hariText);
            row.addView(matkulText);

            tableLayout.addView(row);
        }
    }
}
