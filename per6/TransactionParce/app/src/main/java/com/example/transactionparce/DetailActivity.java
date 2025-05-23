package com.example.transactionparce;

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

        Transaction transaction = getIntent().getParcelableExtra("EXTRA_TRANSACTION");

        if (transaction != null) {
            String result = "Judul: " + transaction.getTitle() + "\n"
                    + "Jumlah: Rp " + transaction.getAmount() + "\n"
                    + "Tanggal: " + transaction.getDate();

            tvDetail.setText(result);
        }
    }
}
