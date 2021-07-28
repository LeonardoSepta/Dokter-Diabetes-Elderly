package com.example.dokterdiabetesforelderly.Konsultasi.KonsultasiUmum;

import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class KonsultasiDataOlahraga {
    private static final String[] idDataKonsultasi = {
            "Rey Naldy",
            "Sulton Niko",
            "ZaReza AqistaWibowo",
            "Abcd",
            "Lilik Suheri"
    };

    private static final String[] judulDataKonsultasi = {
            "Tips Sehat",
            "Berat Badan",
            "Olahraga",
            "Jaga Makan Tidak Olahraga",
            "Bersepeda"
    };

    private static final String[] detailDataKonsultasi = {
            "Tips sehat agar terhindar dari penyakit diabetes?",
            "Berat badan normal sebesar berapa?",
            "Olahraga yang ideal adalah berapa jam sehari?",
            "Apakah baik untuk tubuh jika hanya dengan tidak sembarangan makan tetapi tidak olahraga?",
            "Apakah bersepeda cukup untuk menjaga tubuh agar terhindar dari diabetes?"
    };

    private static final String[] jawabanKonsultasi = {
            "Tips sehat berawal dari makan teratur rendah gula dan asupan karbohidrat normal, istirahat yang cukup dan rajin olahraga agar badan tetap bugar.",
            "Untuk mengetahui berat badan ideal, perlu dihitung dengan rumus  \n" + "\n" + "Berikut adalah rumusnya: Pria: Berat badan ideal (kilogram) = [tinggi badan (sentimeter) – 100] – [(tinggi badan (sentimeter) – 100) x 10 persen] Wanita: Berat badan ideal (kilogram) = [tinggi badan (sentimeter) – 100] – [(tinggi badan (sentimeter) – 100) x 15 persen]",
            "Untuk olahraga baiknya minimal 15 menit sehari, lebih dari itu akan lebih baik untuk tubuh, tetapi sejauh tidak berlebihan dan tidak memaksakan badan",
            "Mengenai tidak sembarangan makan tetapi tidak melakukan olahraga perlu adanya pengecualian jika dalam keseharian sudah banyak beraktifitas, bila tidak beraktifitas sama sekali sebaiknya tidak dianjurkan dan dapat menyebabkan obesitas",
            "Olahraga apapun sebenarnya cukup untuk menyehatkan tubuh bila dalam rentang lamanya berolahraga secara ideal"

    };

    private static final String[] tanggalKonsultasi = {
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
