package id.ionbit.kangcukur_mitra.Dummy;

import java.util.ArrayList;

import id.ionbit.kangcukur_mitra.Model.ModelRiwayatOrder;

public class DummyRiwayatOrder {

    public static String[][] riwayatorder = new String[][]{
            {"Ujang Asep", "20 Juni 2020", "Rp.60.000"},
            {"Ujang Asep", "20 Juni 2020", "Rp.60.000"},
            {"Ujang Asep", "20 Juni 2020", "Rp.60.000"}
    };

    public static ArrayList<ModelRiwayatOrder> getRiwayatOrder() {
        ModelRiwayatOrder check = null;
        ArrayList<ModelRiwayatOrder> list = new ArrayList<>();
        for (int i = 0; i < riwayatorder.length; i++) {
            check = new ModelRiwayatOrder();
            check.setNamaRiwayat(riwayatorder[i][0]);
            check.setTglRiwayat(riwayatorder[i][1]);
            check.setHargaRiwayat(riwayatorder[i][2]);
            list.add(check);
        }
        return list;
    }


}
