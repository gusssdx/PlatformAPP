package com.example.crud_api;

import com.example.agentapi.AgentItem;
import com.example.agentapi.AgentResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AgentValoApi {
    @GET("agent.json")
    Call<AgentResponse<AgentItem>> getAgent();
}
