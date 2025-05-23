package com.example.myintentapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);

        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        if (mPerson != null) {
            String text = "Name: " + mPerson.getName() +
                    ",\n Email: " + mPerson.getEmail() +
                    ",\n Age: " + mPerson.getAge() +
                    ",\n Location: " + mPerson.getCity();

            tvObject.setText(text);
        }
    }
}
