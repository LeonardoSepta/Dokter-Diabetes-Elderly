package com.example.dokterdiabetesforelderly.CarboCalculator;


public class PoolData {
    String Nama;
    String Carbo;
    String Key;

    public PoolData(){}

    public PoolData(String nama, String carbo) {
        this.Nama = nama;
        this.Carbo = carbo;

    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getCarbo() {
        return Carbo;
    }

    public void setCarbo(String carbo) {
        this.Carbo = carbo;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}

