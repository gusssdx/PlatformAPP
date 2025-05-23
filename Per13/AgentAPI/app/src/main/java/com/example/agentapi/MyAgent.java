package com.example.agentapi;

import android.content.Context;
import com.example.crud_api.AgentValoApi;

public class MyAgent {
    AgentValoApi agentValoApi;
    public MyAgent(Context context) {
        agentValoApi = RetrofitBuilder
                .builder(context)
                .create(AgentValoApi.class);
    }
    public AgentValoApi getInstance() {
        return agentValoApi;
    }
}
