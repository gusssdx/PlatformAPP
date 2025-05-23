package com.example.myschedule.adapter;

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

import com.example.myschedule.R;
import com.example.myschedule.activities.ListJadwalActivity;
import com.example.myschedule.activities.UpdateActivity;
import com.example.myschedule.db.DBHelper;
import com.example.myschedule.model.Jadwal;

import java.io.Serializable;
import java.util.ArrayList;


public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private final ArrayList<Jadwal> listJadwal = new ArrayList<>();
    private final Activity activity;
    private final DBHelper dbHelper;

    public JadwalAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DBHelper(activity);
    }

    public ArrayList<Jadwal> getListJadwal() {
        return listJadwal;
    }

    public void setListJadwal(ArrayList<Jadwal> listNotes) {
        if (!listNotes.isEmpty()) {
            this.listJadwal.clear();
        }
        this.listJadwal.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        Jadwal jadwal = listJadwal.get(position);

        holder.tvMatkul.setText(jadwal.getMatkul());
        holder.tvJam.setText(jadwal.getJam());

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("user", (Serializable) jadwal);
            activity.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(activity)
                    .setTitle("Konfirmasi hapus")
                    .setMessage("Apakah yakin akan dihapus?")
                    .setPositiveButton("YA", (dialog, which) -> {
                        dbHelper.deleteUser(jadwal.getId());
                        Toast.makeText(activity, "Hapus berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, ListJadwalActivity.class);
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
        return listJadwal.size();
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {

        final TextView tvMatkul, tvJam;
        final Button btnEdit, btnDelete;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMatkul = itemView.findViewById(R.id.tv_item_matkul);
            tvJam = itemView.findViewById(R.id.tv_item_jam);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
