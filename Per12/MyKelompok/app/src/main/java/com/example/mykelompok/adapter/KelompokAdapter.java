package com.example.mykelompok.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykelompok.R;
import com.example.mykelompok.activities.ListKelompokActivity;
import com.example.mykelompok.activities.UpdateActivity;
import com.example.mykelompok.db.DBHelper;
import com.example.mykelompok.model.Kelompok;


import java.io.Serializable;
import java.util.ArrayList;

public class KelompokAdapter extends RecyclerView.Adapter<KelompokAdapter.KelompokViewHolder> {

    private final ArrayList<Kelompok> listKelompok = new ArrayList<>();
    private final Activity activity;
    private final DBHelper dbHelper;

    public KelompokAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DBHelper(activity);
    }

    public ArrayList<Kelompok> getListKelompok() {
        return listKelompok;
    }

    public void setListKelompok
            (ArrayList<Kelompok> listNotes) {
        if (!listNotes.isEmpty()) {
            this.listKelompok.clear();
        }
        this.listKelompok.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KelompokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kelompok, parent, false);
        return new KelompokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelompokViewHolder holder, int position) {
        Kelompok kelompok = listKelompok.get(position);

        holder.tvNim.setText(kelompok.getNim());
        holder.tvName.setText(kelompok.getName());
        holder.tvEmail.setText(kelompok.getEmail());
        holder.tvKlp.setText(kelompok.getKlp());
        holder.tvApp.setText(kelompok.getApp());


        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("user", (Serializable) kelompok);
            activity.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(activity)
                    .setTitle("Konfirmasi hapus")
                    .setMessage("Apakah yakin akan dihapus?")
                    .setPositiveButton("YA", (dialog, which) -> {
                        dbHelper.deleteUser(kelompok.getId());
                        Toast.makeText(activity, "Hapus berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, ListKelompokActivity.class);
                        activity.startActivity(intent);
                        activity.finish();
                    })
                    .setNegativeButton("TIDAK", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return listKelompok.size();
    }

    public static class KelompokViewHolder extends RecyclerView.ViewHolder {

        final TextView tvNim, tvName, tvEmail, tvKlp, tvApp;
        final Button btnEdit, btnDelete;

        public KelompokViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tv_item_nim);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
            tvKlp = itemView.findViewById(R.id.tv_item_klp);
            tvApp = itemView.findViewById(R.id.tv_item_app);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
