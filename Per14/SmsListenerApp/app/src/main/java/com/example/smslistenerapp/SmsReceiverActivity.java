package com.example.smslistenerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SmsReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSmsFrom;
    private TextView tvSmsMessage;
    private Button btnClose;

    public static final String EXTRA_SMS_NO = "extra_sms_no";
    public static final String EXTRA_SMS_MESSAGE = "extra_sms_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);

        // Inisialisasi view
        tvSmsFrom = findViewById(R.id.tv_no);
        tvSmsMessage = findViewById(R.id.tv_message);
        btnClose = findViewById(R.id.btn_close);

        btnClose.setOnClickListener(this);

        // Ambil data dari intent
        String senderNo = getIntent().getStringExtra(EXTRA_SMS_NO);
        String senderMessage = getIntent().getStringExtra(EXTRA_SMS_MESSAGE);

        // Set teks ke TextView
        tvSmsFrom.setText("From: " + senderNo);
        tvSmsMessage.setText(senderMessage);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close) {
            finish();
        }
    }
}
