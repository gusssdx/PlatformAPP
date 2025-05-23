package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgQuestion1, rgQuestion2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgQuestion1 = findViewById(R.id.rg_question1);
        rgQuestion2 = findViewById(R.id.rg_question2);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId1 = rgQuestion1.getCheckedRadioButtonId();
                int selectedId2 = rgQuestion2.getCheckedRadioButtonId();

                if (selectedId1 == -1 || selectedId2 == -1) {
                    Toast.makeText(MainActivity.this, "Harap jawab semua pertanyaan!", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedAnswer1 = findViewById(selectedId1);
                RadioButton selectedAnswer2 = findViewById(selectedId2);

                String answer1 = selectedAnswer1.getText().toString();
                String answer2 = selectedAnswer2.getText().toString();

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("answer1", answer1);
                intent.putExtra("answer2", answer2);
                startActivity(intent);
            }
        });
    }
}
