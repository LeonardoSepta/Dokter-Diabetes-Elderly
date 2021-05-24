package com.example.dokterdiabetesforelderly.Konsultasi;

import com.example.dokterdiabetesforelderly.Artikel.ModelArtikel;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

//harus membuat detail jawaban konsultasi 

public class KonsultasiData {
    private static String[] idDataKonsultasi = {
            "Wahyu Sudrajat",
            "Wahyu Sudrajat"
    };

    private static String[] judulDataKonsultasi = {
            "Jagung",
            "Buah Pisang"
    };

    private static String[] detailDataKonsultasi = {
            "Kandungan Gula pada Jagung apakah berpengaruh pada pengidap Diabetes? Karena akan di konsumsi setiap hari",
            "Kandungan Gula pada Pisang apakah berpengaruh pada pengidap Diabetes?",
    };

    private static String[] jawabanKonsultasi = {
            "Anda perlu mengetahui bahwa semua makanan yang dikonsumsi selama ini tak luput dari kandungan gula. Kandugan gula bisa berasal dari makanan itu sendiri. Misalnya, makanan yang kaya akan karbohidrat, seperti lontong, mie, roti, kentang, xn jagung. \n" +
                    "\n" +
                    "Oleh sebab itu, Anda sebenarnya dianjurkan untuk membatasi gula tambahan harian. Menurut dr. Fiona Amelia, MPH, batasan konsumsi gula yang dimaksud ditujukan untuk konsumsi gula tambahan yang berasal dari berbagai makanan dan minuman olahan dan siap saji, maupun penggunaan pemanis. Misalnya gula pasir, gula merah, dan gula palem.\n" +
                    "\n" +
                    "\"Makanan dan minuman yang dimaksud, seperti kue, donat, biskuit, permen, minuman kemasan (baik yang bersoda maupun tidak), kopi atau teh manis yang kerap dijual di pasaran. Anda juga harus menghindari berbagai makanan pencuci mulut,\" ujar dr. Fiona.",
            "Anda perlu mengetahui bahwa semua makanan yang dikonsumsi selama ini tak luput dari kandungan gula. Kandugan gula bisa berasal dari makanan itu sendiri. Misalnya, makanan yang kaya akan karbohidrat, seperti lontong, mie, roti, kentang, xn jagung. \n" +
                    "\n" +
                    "Oleh sebab itu, Anda sebenarnya dianjurkan untuk membatasi gula tambahan harian. Menurut dr. Fiona Amelia, MPH, batasan konsumsi gula yang dimaksud ditujukan untuk konsumsi gula tambahan yang berasal dari berbagai makanan dan minuman olahan dan siap saji, maupun penggunaan pemanis. Misalnya gula pasir, gula merah, dan gula palem.\n" +
                    "\n" +
                    "\"Makanan dan minuman yang dimaksud, seperti kue, donat, biskuit, permen, minuman kemasan (baik yang bersoda maupun tidak), kopi atau teh manis yang kerap dijual di pasaran. Anda juga harus menghindari berbagai makanan pencuci mulut,\" ujar dr. Fiona."
    };

    private static int[] imageDataKonsultasi = {
            R.drawable.removebg_logo_dokter_diabetes,
            R.drawable.removebg_logo_dokter_diabetes
    };

    //penempatan data setJudul , setDetail, setPhoto
    static ArrayList<ModelKonsultasi> getListData(){
        ArrayList<ModelKonsultasi> list = new ArrayList<>();
        for (int position = 0; position<idDataKonsultasi.length; position++){
            ModelKonsultasi konsultasi = new ModelKonsultasi();
            konsultasi.setId(idDataKonsultasi[position]);
            konsultasi.setJudul(judulDataKonsultasi[position]);
            konsultasi.setDetail(detailDataKonsultasi[position]);
            konsultasi.setJawaban(jawabanKonsultasi[position]);
            konsultasi.setPhoto(imageDataKonsultasi[position]);
            list.add(konsultasi);
        }
        return list;
    }
}
