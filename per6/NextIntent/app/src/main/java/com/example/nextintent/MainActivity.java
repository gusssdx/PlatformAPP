// MainActivity.java
package com.example.nextintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.btn_move);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                Person person = new Person();
                person.setNama("Bagus Tri Handoko");
                person.setNim("2210511025");
                person.setAlamat("Jakarta, Indonesia");
                person.setHobi("Coding, Gaming, Running");
                person.setCita_cita("Data Scientist");
                moveIntent.putExtra("EXTRA_PERSON", person);
                startActivity(moveIntent);
            }
        });
    }
}
