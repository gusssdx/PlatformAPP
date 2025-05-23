package com.example.agentapi;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.ViewHolder> {

    List<AgentItem> result;
    Activity activity;

    public AgentAdapter(List<AgentItem> result, Activity activity){
        this.result = result;
        this.activity = activity;
    }
    public AgentAdapter(MyAgent myAgent) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_agent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(result.get(position));
    }

    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_no, tv_name, tv_release_date, tv_role, tv_abilities, tv_signature, tv_country, tv_ultimate;
        ImageView posterView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_no = itemView.findViewById(R.id.tv_no);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_release_date = itemView.findViewById(R.id.tv_release_date);
            tv_role = itemView.findViewById(R.id.tv_role);
            tv_abilities = itemView.findViewById(R.id.tv_abilities);
            tv_signature = itemView.findViewById(R.id.tv_signature);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_ultimate = itemView.findViewById(R.id.tv_ultimate);
            posterView = itemView.findViewById(R.id.posterView);
        }

        public void bind(AgentItem agentItem) {
            tv_no.setText(agentItem.no);
            tv_name.setText(agentItem.name);
            tv_release_date.setText(agentItem.release_date);
            tv_role.setText(agentItem.role);
            tv_abilities.setText(agentItem.abilities);
            tv_signature.setText(agentItem.signature);
            tv_country.setText(agentItem.country);
            tv_ultimate.setText(agentItem.ultimate);
            Glide.with(activity).load(agentItem.getPoster()).into(posterView);
        }
    }
}