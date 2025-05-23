package com.example.ticketpojo;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String nama;
    private String tujuan;
    private String tanggal;
    private int jumlah;

    public Ticket(String nama, String tujuan, String tanggal, int jumlah) {
        this.nama = nama;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
    }

    public String getNama() { return nama; }
    public String getTujuan() { return tujuan; }
    public String getTanggal() { return tanggal; }
    public int getJumlah() { return jumlah; }
}

