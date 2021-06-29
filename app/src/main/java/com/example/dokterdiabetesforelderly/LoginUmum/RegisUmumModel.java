package com.example.dokterdiabetesforelderly.LoginUmum;

public class RegisUmumModel {
    String username,email,password,nama,gender;

    public RegisUmumModel(){

    }

    public RegisUmumModel(String Username, String Email, String Pass, String Nama, String Gender){
        this.username = Username;
        this.email = Email;
        this.password = Pass;
        this.nama = Nama;
        this.gender = Gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
