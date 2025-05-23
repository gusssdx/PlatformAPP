package com.example.mykelompok.model;

import java.io.Serializable;

public class Kelompok  implements Serializable {
    private int id;
    private String name, nim, email, klp, app;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getKlp(){
        return klp;
    }
    public void setKlp(String klp){
        this.klp = klp;
    }
    public String getApp(){
        return app;
    }
    public void setApp(String app){
        this.app = app;
    }
}

