package com.example.dokterdiabetesforelderly;

import java.util.ArrayList;

public class ArtikelInfoDiabetesData {
    private static String[] judulDataArtikel = {
            "Diabetes adalah penyakit kronis yang ditandai dengan ciri-ciri berupa tingginya kadar gula (glukosa) darah.",
            "Diabetes, Penyebab, dan Pencegahannya",
            "4 Jenis Suntik Insulin untuk Diabetes dan Cara Penyimpanananya"
    };

    private static String[] detailDataArtikel = {
            "Glukosa yang menumpuk di dalam darah akibat tidak diserap sel tubuh dengan baik dapat menimbulkan berbagai gangguan organ tubuh. Jika diabetes tidak dikontrol dengan baik, dapat timbul berbagai komplikasi yang membahayakan nyawa penderita.",
            "Diabetes Melitus (DM) atau disebut diabetes saja merupakan penyakit gangguan metabolik menahun akibat pankreas tidak memproduksi cukup insulin atau tubuh tidak dapat menggunakan insulin yang diproduksi secara efektif.\n" +
                    "\n" +
                    "Insulin adalah hormon yang mengatur keseimbangan kadar gula darah. Akibatnya terjadi peningkatan konsentrasi glukosa di dalam darah (hiperglikemia). Terdapat dua kategori utama diabetes melitus yaitu diabetes tipe 1 dan tipe 2.",
            "Mengendalikan kadar gula darah tetap normal adalah kunci hidup sehat bagi diabetesi (penderita diabetes melitus). Selain itu, beberapa diabetesi juga perlu mematuhi anjuran dokter untuk menjalani pengobatan diabetes dengan terapi insulin lewat suntikan. Namun, tahukah Anda apa fungsi dari suntik insulin dan bagaimana cara melakukannya? Simak selengkapnya di artikel ini."
    };

    private static int[] imageDataArtikel = {
            R.drawable.diabetes_adalah_penyakit_kronis,
            R.drawable.diabetes_penyebab_dan_pencegahannya,
            R.drawable.jenis_suntik_insulin
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
