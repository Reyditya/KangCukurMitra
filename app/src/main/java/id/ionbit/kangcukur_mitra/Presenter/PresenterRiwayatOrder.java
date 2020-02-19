package id.ionbit.kangcukur_mitra.Presenter;

import android.content.Context;

import id.ionbit.kangcukur_mitra.Dummy.DummyRiwayatOrder;
import id.ionbit.kangcukur_mitra.Iterator.IteratorRiwayatOrder;

public class PresenterRiwayatOrder implements IteratorRiwayatOrder.presenter {
    Context context;
    IteratorRiwayatOrder.profileRiwayatOrder profileRiwayatOrder;

    public PresenterRiwayatOrder(Context context, IteratorRiwayatOrder.profileRiwayatOrder profileRiwayatOrder) {
        this.context = context;
        this.profileRiwayatOrder = profileRiwayatOrder;
    }


    @Override
    public void onRiwayatOrder() {
profileRiwayatOrder.onSuccessRiwayatOrde(DummyRiwayatOrder.getRiwayatOrder());
    }
}
