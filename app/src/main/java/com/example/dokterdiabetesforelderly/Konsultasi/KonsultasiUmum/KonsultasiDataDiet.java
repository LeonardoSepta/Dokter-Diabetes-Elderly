package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

//harus membuat detail jawaban konsultasi 

public class KonsultasiDataDiet {
    private static final String[] idDataKonsultasi = {
            "Wahyu Sudrajat",
            "Wahyu Sudrajat",
            "Rey Naldy",
            "Sulton Niko",
            "ZaReza AqistaWibowo",
            "Abcd",
            "Lilik Suheri"
    };

    private static final String[] judulDataKonsultasi = {
            "Jagung",
            "Buah Pisang",
            "Tips Sehat",
            "Berat Badan",
            "Olahraga",
            "Jaga Makan Tidak Olahraga",
            "Bersepeda"
    };

    private static final String[] detailDataKonsultasi = {
            "Kandungan Gula pada Jagung apakah berpengaruh pada pengidap Diabetes? Karena akan di konsumsi setiap hari",
            "Kandungan Gula pada Pisang apakah berpengaruh pada pengidap Diabetes?",
            "Tips sehat agar terhindar dari penyakit diabetes?",
            "Berat badan normal sebesar berapa?",
            "Olahraga yang ideal adalah berapa jam sehari?",
            "Apakah baik untuk tubuh jika hanya dengan tidak sembarangan makan tetapi tidak olahraga?",
            "Apakah bersepeda cukup untuk menjaga tubuh agar terhindar dari diabetes?"
    };

    private static final String[] jawabanKonsultasi = {
            "Anda perlu mengetahui bahwa semua makanan yang dikonsumsi selama ini tak luput dari kandungan gula. Kandugan gula bisa berasal dari makanan itu sendiri. Misalnya, makanan yang kaya akan karbohidrat, seperti lontong, mie, roti, kentang, xn jagung. \n" +
                    "\n" +
                    "Oleh sebab itu, Anda sebenarnya dianjurkan untuk membatasi gula tambahan harian. Menurut dr. Fiona Amelia, MPH, batasan konsumsi gula yang dimaksud ditujukan untuk konsumsi gula tambahan yang berasal dari berbagai makanan dan minuman olahan dan siap saji, maupun penggunaan pemanis. Misalnya gula pasir, gula merah, dan gula palem.\n" +
                    "\n" +
                    "\"Makanan dan minuman yang dimaksud, seperti kue, donat, biskuit, permen, minuman kemasan (baik yang bersoda maupun tidak), kopi atau teh manis yang kerap dijual di pasaran. Anda juga harus menghindari berbagai makanan pencuci mulut,\" ujar dr. Fiona.",
            "Anda perlu mengetahui bahwa semua makanan yang dikonsumsi selama ini tak luput dari kandungan gula. Kandugan gula bisa berasal dari makanan itu sendiri. Misalnya, makanan yang kaya akan karbohidrat, seperti lontong, mie, roti, kentang, xn jagung. \n" +
                    "\n" +
                    "Oleh sebab itu, Anda sebenarnya dianjurkan untuk membatasi gula tambahan harian. Menurut dr. Fiona Amelia, MPH, batasan konsumsi gula yang dimaksud ditujukan untuk konsumsi gula tambahan yang berasal dari berbagai makanan dan minuman olahan dan siap saji, maupun penggunaan pemanis. Misalnya gula pasir, gula merah, dan gula palem.\n" +
                    "\n" +
                    "\"Makanan dan minuman yang dimaksud, seperti kue, donat, biskuit, permen, minuman kemasan (baik yang bersoda maupun tidak), kopi atau teh manis yang kerap dijual di pasaran. Anda juga harus menghindari berbagai makanan pencuci mulut,\" ujar dr. Fiona.",
            "Tips sehat berawal dari makan teratur rendah gula dan asupan karbohidrat normal, istirahat yang cukup dan rajin olahraga agar badan tetap bugar.",
            "Untuk mengetahui berat badan ideal, perlu dihitung dengan rumus  \n" + "\n" + "Berikut adalah rumusnya: Pria: Berat badan ideal (kilogram) = [tinggi badan (sentimeter) – 100] – [(tinggi badan (sentimeter) – 100) x 10 persen] Wanita: Berat badan ideal (kilogram) = [tinggi badan (sentimeter) – 100] – [(tinggi badan (sentimeter) – 100) x 15 persen]",
            "Untuk olahraga baiknya minimal 15 menit sehari, lebih dari itu akan lebih baik untuk tubuh, tetapi sejauh tidak berlebihan dan tidak memaksakan badan",
            "Mengenai tidak sembarangan makan tetapi tidak melakukan olahraga perlu adanya pengecualian jika dalam keseharian sudah banyak beraktifitas, bila tidak beraktifitas sama sekali sebaiknya tidak dianjurkan dan dapat menyebabkan obesitas",
            "Olahraga apapun sebenarnya cukup untuk menyehatkan tubuh bila dalam rentang lamanya berolahraga secara ideal"

    };

    private static final String[] tanggalKonsultasi = {
            "22/07/20",
            "06/01/20",
            "20/08/19",
            "01/05/19",
            "13/03/19",
            "05/03/19",
            "03/02/19"
    };

    private static final int[] imageDataKonsultasi = {
            R.drawable.removebg_logo_dokter_diabetes,
            R.drawable.removebg_logo_dokter_diabetes,
            R.drawable.removebg_logo_dokter_diabetes,
            R.drawable.removebg_logo_dokter_diabetes,
            R.drawable.removebg_logo_dokter_diabetes,
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
            konsultasi.setTanggal(tanggalKonsultasi[position]);
            list.add(konsultasi);
        }
        return list;
    }
}
