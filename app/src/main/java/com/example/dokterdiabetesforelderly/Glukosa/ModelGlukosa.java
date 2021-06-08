package com.example.dokterdiabetesforelderly.Glukosa;

public class ModelGlukosa {
    String dataglukosa;
    String tglglukosa;

    //constructor
    public ModelGlukosa(){

    }

    public ModelGlukosa(String dataglukosa, String tglglukosa) {
        this.dataglukosa = dataglukosa;
        this.tglglukosa = tglglukosa;
    }

    public String getDataglukosa() {
        return dataglukosa;
    }

    public void setDataglukosa(String dataglukosa) {
        this.dataglukosa = dataglukosa;
    }

    public String getTglglukosa() {
        return tglglukosa;
    }

    public void setTglglukosa(String tglglukosa) {
        this.tglglukosa = tglglukosa;
    }
}
