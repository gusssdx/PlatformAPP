package com.example.transactionparce;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {
    private String title;
    private double amount;
    private String date;

    public Transaction(String title, double amount, String date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    protected Transaction(Parcel in) {
        title = in.readString();
        amount = in.readDouble();
        date = in.readString();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeDouble(amount);
        parcel.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}