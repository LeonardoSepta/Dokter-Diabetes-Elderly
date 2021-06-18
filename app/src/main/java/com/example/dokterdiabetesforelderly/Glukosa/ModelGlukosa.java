package com.example.dokterdiabetesforelderly.Glukosa;

public class ModelGlukosa {
    String dataglukosa;
    String dateglukosa;

    //constructor
    public ModelGlukosa(){

    }

    public ModelGlukosa(String dataglukosa, String dateglukosa) {
        this.dataglukosa = dataglukosa;
        this.dateglukosa = dateglukosa;
    }

    public String getDataglukosa() {
        return dataglukosa;
    }

    public String getDateglukosa() {
        return dateglukosa;
    }

    public void setDateglukosa(String dateglukosa) {
        this.dateglukosa = dateglukosa;
    }

    public void setDataglukosa(String dataglukosa) {
        this.dataglukosa = dataglukosa;
    }

}
