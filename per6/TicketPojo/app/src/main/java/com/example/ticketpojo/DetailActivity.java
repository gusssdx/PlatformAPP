package com.example.ticketpojo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetail = findViewById(R.id.tv_detail);

        Ticket ticket = (Ticket) getIntent().getSerializableExtra("EXTRA_TICKET");

        String result = "Nama: " + ticket.getNama() + "\n"
                + "Tujuan: " + ticket.getTujuan() + "\n"
                + "Tanggal: " + ticket.getTanggal() + "\n"
                + "Jumlah Tiket: " + ticket.getJumlah();

        tvDetail.setText(result);
    }
}
