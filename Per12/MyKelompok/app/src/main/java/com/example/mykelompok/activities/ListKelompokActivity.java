package com.example.mykelompok.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykelompok.R;
import com.example.mykelompok.adapter.KelompokAdapter;
import com.example.mykelompok.db.DBHelper;
import com.example.mykelompok.model.Kelompok;

import java.util.ArrayList;

public class ListKelompokActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KelompokAdapter adapter;
    private ArrayList<Kelompok> kelompokArrayList;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kelompok);

        recyclerView = findViewById(R.id.rview);
        dbHelper = new DBHelper(this);

        adapter = new KelompokAdapter(this);
        kelompokArrayList = dbHelper.getAllUsers();
        adapter.setListKelompok(kelompokArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        kelompokArrayList = dbHelper.getAllUsers();
        adapter.setListKelompok(kelompokArrayList);
        adapter.notifyDataSetChanged();
    }
}
