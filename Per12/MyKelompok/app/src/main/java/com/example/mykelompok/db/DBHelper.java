package com.example.mykelompok.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mykelompok.model.Kelompok;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbkelompok";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STD = "kelompok";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NIM = "nim";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_KLP = "klp";
    private static final String KEY_APP = "app";


    private static final String CREATE_TABLE_KELOMPOK = "CREATE TABLE "
            + TABLE_STD + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME + " TEXT, "
            + KEY_NIM + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_KLP + " TEXT, "
            + KEY_APP + " TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KELOMPOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STD);
        onCreate(db);
    }

    public long addUserDetail(String nim, String name, String email, String klp, String app) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_NIM, nim);
        values.put(KEY_EMAIL, email);
        values.put(KEY_KLP, klp);
        values.put(KEY_APP, app);

        return db.insert(TABLE_STD, null, values);
    }

    public ArrayList<Kelompok> getAllUsers() {
        ArrayList<Kelompok> userModelArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Kelompok std = new Kelompok();
                std.setId(c.getInt(c.getColumnIndexOrThrow(KEY_ID)));
                std.setName(c.getString(c.getColumnIndexOrThrow(KEY_NAME)));
                std.setNim(c.getString(c.getColumnIndexOrThrow(KEY_NIM)));
                std.setEmail(c.getString(c.getColumnIndexOrThrow(KEY_EMAIL)));
                std.setKlp(c.getString(c.getColumnIndexOrThrow(KEY_KLP)));
                std.setApp(c.getString(c.getColumnIndexOrThrow(KEY_APP)));

                userModelArrayList.add(std);
            } while (c.moveToNext());
        }

        c.close(); // Jangan lupa menutup Cursor

        return userModelArrayList;
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STD, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int updateUser(int id, String nim, String name, String email, String klp, String app) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_NIM, nim);
        values.put(KEY_EMAIL, email);
        values.put(KEY_KLP, klp);
        values.put(KEY_APP, app);

        return db.update(TABLE_STD, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }
}