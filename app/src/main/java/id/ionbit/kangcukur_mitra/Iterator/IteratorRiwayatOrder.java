package id.ionbit.kangcukur_mitra.Iterator;

import java.util.ArrayList;

import id.ionbit.kangcukur_mitra.Model.ModelRiwayatOrder;

public interface IteratorRiwayatOrder {
    interface profileRiwayatOrder {
        void showLoading();

        void dismissLoading();

        void onFailure(String msg);

        void onSuccessRiwayatOrde(ArrayList<ModelRiwayatOrder> riwayatOrders);

    }

    interface presenter {
        void onRiwayatOrder();
    }
}
