package com.example.ticketpojo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etTujuan, etTanggal, etJumlah;
    private Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etTujuan = findViewById(R.id.et_tujuan);
        etTanggal = findViewById(R.id.et_tanggal);
        etJumlah = findViewById(R.id.et_jumlah);
        btnPesan = findViewById(R.id.btn_pesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String tujuan = etTujuan.getText().toString();
                String tanggal = etTanggal.getText().toString();
                int jumlah = Integer.parseInt(etJumlah.getText().toString());

                Ticket ticket = new Ticket(nama, tujuan, tanggal, jumlah);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("EXTRA_TICKET", ticket);
                startActivity(intent);
            }
        });
    }
}
