package com.example.agentapi;


import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MyAgent myAgent;
    private AgentAdapter adapter;
    private RecyclerView rv_agent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_agent = findViewById(R.id.rv_agent);
        myAgent = new MyAgent(this);

        rv_agent.setHasFixedSize(true);
        rv_agent.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi data
        adapter = new AgentAdapter(myAgent);  // catatan: konstruktor ini tidak digunakan, bisa dihapus
        rv_agent.setAdapter(adapter);

        // Ambil data pemain dari API
        getDataAgent();
    }

    public void getDataAgent() {
        myAgent.getInstance().getAgent().enqueue(new Callback<AgentResponse<AgentItem>>() {
            @Override
            public void onResponse(Call<AgentResponse<AgentItem>> call, Response<AgentResponse<AgentItem>> response) {
                AgentResponse<AgentItem> resp = response.body();

                if (resp.getResult() != null && resp.getResult().size() > 0){
                    adapter = new AgentAdapter(resp.getResult(),MainActivity.this);
                    rv_agent.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<AgentResponse<AgentItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
