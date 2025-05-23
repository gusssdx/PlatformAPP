package com.example.quizapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;
    private String correctAnswer1 = "10";  // Jawaban benar untuk soal 1
    private String correctAnswer2 = "Bumi"; // Jawaban benar untuk soal 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tv_result);

        String userAnswer1 = getIntent().getStringExtra("answer1");
        String userAnswer2 = getIntent().getStringExtra("answer2");

        String resultText = "Jawaban Anda:\n";
        resultText += "1. " + userAnswer1 + (userAnswer1.equals(correctAnswer1) ? " ✅" : " ❌") + "\n";
        resultText += "2. " + userAnswer2 + (userAnswer2.equals(correctAnswer2) ? " ✅" : " ❌") + "\n";

        tvResult.setText(resultText);
    }
}
