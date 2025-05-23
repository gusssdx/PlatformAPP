package com.example.alphabetindex;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;
import android.graphics.Typeface;

import com.example.alphabetindex.adapter.MyAdapter;
import com.example.alphabetindex.helper.DataHelper;

public class MainActivity extends AppCompatActivity {

    private FastScrollRecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data = DataHelper.getAlphabetFullData();
        Collections.sort(data); // Urutkan data agar index A-Z sinkron
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);

        // Generate index A-Z secara dinamis
        LinearLayout sideIndex = findViewById(R.id.side_index);
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String letter : alphabet) {
            TextView tv = new TextView(this);
            tv.setText(letter);
            tv.setTextSize(12f);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(0, 4, 0, 4);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0, // height 0dp
                    1f // weight 1
            );
            tv.setLayoutParams(params);
            tv.setOnClickListener(v -> {
                scrollToSection(letter);
            });
            sideIndex.addView(tv);
        }
    }

    private void scrollToSection(String letter) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).toUpperCase().startsWith(letter)) {
                recyclerView.scrollToPosition(i);
                break;
            }
        }
    }
}
