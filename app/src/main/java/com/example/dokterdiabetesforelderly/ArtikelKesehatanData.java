package com.example.dokterdiabetesforelderly;

import java.util.ArrayList;

public class ArtikelKesehatanData {
    private static String[] judulDataArtikel = {
            "Cegah Komplikasi, Begini Cara Perawatan Pasca Operasi Katarak"

    };

    private static String[] detailDataArtikel = {
            "Prosedur pengangkatan lensa katarak memiliki tingkat keberhasilan yang cukup tinggi. Perawatan pasca operasi katarak, seperti menghindari sinar matahari, rutin menggunakan obat tetes, dan memakai pelindung mata menjadi hal yang tak boleh dilewatkan demi mencegah komplikasi.",

    };

    private static int[] imageDataArtikel = {
            R.drawable.artikel_mata_katarak,

    };

    //penempatan data setJudul , setDetail, setPhoto
    static ArrayList<ModelArtikel> getListData(){
        ArrayList<ModelArtikel> list = new ArrayList<>();
        for (int position = 0; position<judulDataArtikel.length; position++){
            ModelArtikel artikel = new ModelArtikel();
            artikel.setJudul(judulDataArtikel[position]);
            artikel.setDetail(detailDataArtikel[position]);
            artikel.setPhoto(imageDataArtikel[position]);
            list.add(artikel);
        }
        return list;
    }
}
