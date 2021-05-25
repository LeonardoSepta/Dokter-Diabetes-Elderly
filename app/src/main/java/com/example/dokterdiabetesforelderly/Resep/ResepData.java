package com.example.dokterdiabetesforelderly.Resep;

import com.example.dokterdiabetesforelderly.Resep.ModelResep;
import com.example.dokterdiabetesforelderly.R;

import java.util.ArrayList;

public class ResepData {
    private static String[] judulDataResep = {
            "SOYJOY Avocado",
            "SOYJOY Protein Ball",
            "SOYJOY Apple Cinnamon Dessert",
            "Shrimp Tofu Dumpling",
            "SOYJOY Froyo Cups",
            "SOYJOY Banana Ice Cream",
    };

    private static String[] detailDataResep = {
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer",
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer",
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer",
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer",
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer",
            "2 buah Soyjoy.\n" +
                    "\n" + "350 ml plain yogurt.\n" +
                    "\n" + "50 ml madu atau sesuai selera\n" +
                    "\n" + "80 gr blueberry\n" +
                    "\n" + "\n" +
                    "\n" + "irisan strawberry secukupnya\n" +
                    "\n" + "campur yogurt dan madu\n" +
                    "\n" + "haluskan soyjoy dengan food processor, siapkan cetakan, dan masukan semua bahan pada cetakan, simpan didalam freezer"

    };

    private static int[] imageDataResep = {
            R.drawable.soyjoy_avocado,
            R.drawable.soyjoy_protein_ball,
            R.drawable.soyjoy_apple_cinnamon_dessert,
            R.drawable.shrimp_tofu_dumpling,
            R.drawable.soyjoy_froyo_cups,
            R.drawable.soyjoy_banana_ice_cream
    };

    //penempatan data setJudul , setDetail, setPhoto
    static ArrayList<ModelResep> getListData(){
        ArrayList<ModelResep> list = new ArrayList<>();
        for (int position = 0; position<judulDataResep.length; position++){
            ModelResep resep = new ModelResep();
            resep.setJudul(judulDataResep[position]);
            resep.setDetail(detailDataResep[position]);
            resep.setImg(imageDataResep[position]);
            list.add(resep);
        }
        return list;
    }
}
