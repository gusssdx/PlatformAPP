package com.example.myschedule.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myschedule.model.Jadwal;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbjadwal";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STD = "jadwal";
    private static final String KEY_ID = "id";
    private static final String KEY_MATKUL = "matkul";
    private static final String KEY_JAM = "jam";

    private static final String CREATE_TABLE_JADWAL = "CREATE TABLE "
            + TABLE_STD + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_MATKUL + " TEXT, "
            + KEY_JAM + " TEXT );";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JADWAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STD);
        onCreate(db);
    }

    public long addUserDetail(String matkul, String jam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MATKUL, matkul);
        values.put(KEY_JAM, jam);

        return db.insert(TABLE_STD, null, values);
    }

    public ArrayList<Jadwal> getAllUsers() {
        ArrayList<Jadwal> userModelArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Jadwal jadwal = new Jadwal();
                jadwal.setId(c.getInt(c.getColumnIndexOrThrow(KEY_ID)));
                jadwal.setMatkul(c.getString(c.getColumnIndexOrThrow(KEY_MATKUL)));
                jadwal.setJam(c.getString(c.getColumnIndexOrThrow(KEY_JAM)));

                userModelArrayList.add(jadwal);
            } while (c.moveToNext());
        }

        c.close(); // Jangan lupa menutup Cursor

        return userModelArrayList;
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STD, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int updateUser(int id, String matkul, String jam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MATKUL, matkul);
        values.put(KEY_JAM, jam);

        return db.update(TABLE_STD, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }
}


