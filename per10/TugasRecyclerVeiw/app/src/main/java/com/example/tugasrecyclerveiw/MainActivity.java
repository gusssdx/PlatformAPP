package com.example.tugasrecyclerveiw;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasrecyclerveiw.DataAdapter.ListAdapter;
import com.example.tugasrecyclerveiw.DataHelper.KelompokData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKelompok;
    private ArrayList<Kelompok> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvKelompok = findViewById(R.id.rv_kelompok);
        rvKelompok.setHasFixedSize(true);

        list.addAll(KelompokData.getListData());
        showRecyclerList();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showRecyclerList() {
        rvKelompok.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvKelompok.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        if (selectedMode == R.id.action_list) {
            rvKelompok.setLayoutManager(new LinearLayoutManager(this));
            ListAdapter listAdapter = new ListAdapter(list);
            rvKelompok.setAdapter(listAdapter);
        } else if (selectedMode == R.id.action_grid) {
//            rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
//            GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
//            rvHeroes.setAdapter(gridHeroAdapter);
        } else if (selectedMode == R.id.action_cardview) {
//            rvHeroes.setLayoutManager(new LinearLayoutManager(this));
//            CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
//            rvHeroes.setAdapter(cardViewHeroAdapter);
        }
    }
}