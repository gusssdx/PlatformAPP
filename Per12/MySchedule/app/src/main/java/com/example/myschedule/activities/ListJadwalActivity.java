package com.example.myschedule.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myschedule.R;
import com.example.myschedule.adapter.JadwalAdapter;
import com.example.myschedule.db.DBHelper;
import com.example.myschedule.model.Jadwal;

import java.util.ArrayList;

public class ListJadwalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JadwalAdapter adapter;
    private ArrayList<Jadwal> jadwalArrayList;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);

        recyclerView = findViewById(R.id.rview);
        dbHelper = new DBHelper(this);

        adapter = new JadwalAdapter(this);
        jadwalArrayList = dbHelper.getAllUsers();
        adapter.setListJadwal(jadwalArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        jadwalArrayList = dbHelper.getAllUsers();
        adapter.setListJadwal(jadwalArrayList);
        adapter.notifyDataSetChanged();
    }
}
