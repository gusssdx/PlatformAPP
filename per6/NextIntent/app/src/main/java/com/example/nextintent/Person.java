package com.example.nextintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String  Nama;

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getHobi() {
        return Hobi;
    }

    public void setHobi(String hobi) {
        Hobi = hobi;
    }

    public String getCita_cita() {
        return Cita_cita;
    }

    public void setCita_cita(String cita_cita) {
        Cita_cita = cita_cita;
    }

    private String Nim;
    private String Alamat;
    private String Hobi;
    private String Cita_cita;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nama);
        dest.writeString(this.Nim);
        dest.writeString(this.Alamat);
        dest.writeString(this.Hobi);
        dest.writeString(this.Cita_cita);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.Nama = in.readString();
        this.Nim = in.readString();
        this.Alamat = in.readString();
        this.Hobi = in.readString();
        this.Cita_cita = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
