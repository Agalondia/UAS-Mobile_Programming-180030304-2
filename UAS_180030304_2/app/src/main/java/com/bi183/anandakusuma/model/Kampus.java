package com.bi183.anandakusuma.model;

import com.google.gson.annotations.SerializedName;

public class Kampus {

    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("nim")
    private String nim;
    @SerializedName("kelas")
    private String kelas;
    @SerializedName("photo")
    private String photo;
    @SerializedName("gender")
    private String gender;

    public Kampus(int id, String firstName, String lastName, String nim, String kelas, String photo, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nim = nim;
        this.kelas = kelas;
        this.photo = photo;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getPhoto() {
        return photo;
    }

    public String getGender() {
        return gender;
    }
}