package com.example.nextintent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        TextView tvDetail = findViewById(R.id.tv_detail);
        Person person = getIntent().getParcelableExtra("EXTRA_PERSON");
        if (person != null) {
            String detail = "Nama: " + person.getNama() + "\n" +
                    "NIM: " + person.getNim() + "\n" +
                    "Alamat: " + person.getAlamat() + "\n" +
                    "Hobi: " + person.getHobi() + "\n" +
                    "Cita-cita: " + person.getCita_cita();
            tvDetail.setText(detail);
        }
    }
}
