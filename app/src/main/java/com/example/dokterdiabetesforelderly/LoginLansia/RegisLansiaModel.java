package com.example.dokterdiabetesforelderly.LoginLansia;

public class RegisLansiaModel {
    String nomor,password,nama,gender;

    public RegisLansiaModel(){

    }

    public RegisLansiaModel(String Nomor, String Pass, String Nama, String Gender){
        this.nomor = Nomor;
        this.password = Pass;
        this.nama = Nama;
        this.gender = Gender;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
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
