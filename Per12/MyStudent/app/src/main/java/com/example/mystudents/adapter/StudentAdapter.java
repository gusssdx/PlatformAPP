package com.example.mystudents.adapter;

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

import com.example.mystudents.R;
import com.example.mystudents.activities.ListStudentsActivity;
import com.example.mystudents.activities.UpdateActivity;
import com.example.mystudents.db.DBHelper;
import com.example.mystudents.model.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final ArrayList<Student> listStudents = new ArrayList<>();
    private final Activity activity;
    private final DBHelper dbHelper;

    public StudentAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DBHelper(activity);
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listNotes) {
        if (!listNotes.isEmpty()) {
            this.listStudents.clear();
        }
        this.listStudents.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = listStudents.get(position);

        holder.tvNim.setText(student.getNim());
        holder.tvName.setText(student.getName());

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("user", (Serializable) student);
            activity.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(activity)
                    .setTitle("Konfirmasi hapus")
                    .setMessage("Apakah yakin akan dihapus?")
                    .setPositiveButton("YA", (dialog, which) -> {
                        dbHelper.deleteUser(student.getId());
                        Toast.makeText(activity, "Hapus berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, ListStudentsActivity.class);
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
        return listStudents.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        final TextView tvNim, tvName;
        final Button btnEdit, btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tv_item_nim);
            tvName = itemView.findViewById(R.id.tv_item_name);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

