package com.example.sambungkata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtInput;
    private Button btnAdd, btnReset;
    private TextView tvResult;
    private ArrayList<String> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edt_input);
        btnAdd = findViewById(R.id.btn_add);
        btnReset = findViewById(R.id.btn_reset);
        tvResult = findViewById(R.id.tv_result);

        // Tombol untuk menambahkan kata ke dalam list
        btnAdd.setOnClickListener(v -> {
            String inputWord = edtInput.getText().toString().trim();
            if (!inputWord.isEmpty()) {
                wordList.add(inputWord);
                updateSentence();
                edtInput.setText(""); // Kosongkan input setelah menambah kata
            } else {
                edtInput.setError("Masukkan kata terlebih dahulu!");
            }
        });

        // Tombol untuk reset kata-kata yang telah dimasukkan
        btnReset.setOnClickListener(v -> {
            wordList.clear();
            updateSentence();
        });
    }

    private void updateSentence() {
        if (wordList.isEmpty()) {
            tvResult.setText("Hasil: ");
        } else {
            String sentence = String.join(" ", wordList);
            tvResult.setText("Hasil: " + sentence);
        }
    }
}
