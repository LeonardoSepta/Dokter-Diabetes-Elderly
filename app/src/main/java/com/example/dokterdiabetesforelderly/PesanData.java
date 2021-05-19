package com.example.dokterdiabetesforelderly;

import java.util.ArrayList;

public class PesanData {
    private static String[] judulDataPesan = {
            "Kompetisi Konsultasi Dokter Diabetes",
            "Update Apps",
            "Fakta Karbohidrat yang Perlu Anda Tahu"

    };

    private static String[] detailDataPesan = {
            "Beragam hadiah menarik menantimu Konsultasikan pertanyaan secepatnya",
            "Suka ngelag? Ayo, Update Dokter Diabetes versi terbaru",
            "Fakta Karbohidrat yang Perlu Anda Tahu"

    };

    //penempatan data setJudul , setDetail
    static ArrayList<ModelPesan> getListData(){
        ArrayList<ModelPesan> list = new ArrayList<>();
        for (int position = 0; position<judulDataPesan.length; position++){
            ModelPesan modelPesan = new ModelPesan();
            modelPesan.setJudul(judulDataPesan[position]);
            modelPesan.setDetail(detailDataPesan[position]);

            list.add(modelPesan);
        }
        return list;
    }
}
