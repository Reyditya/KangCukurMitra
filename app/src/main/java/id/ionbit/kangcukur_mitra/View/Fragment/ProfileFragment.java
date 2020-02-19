package id.ionbit.kangcukur_mitra.View.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ionbit.kangcukur_mitra.Adapter.AdapterRiwayatOrder;
import id.ionbit.kangcukur_mitra.Iterator.IteratorRiwayatOrder;
import id.ionbit.kangcukur_mitra.Model.ModelRiwayatOrder;
import id.ionbit.kangcukur_mitra.Presenter.PresenterRiwayatOrder;
import id.ionbit.kangcukur_mitra.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements IteratorRiwayatOrder.profileRiwayatOrder {
    @BindView(R.id.rvRiwayatOrder)
    RecyclerView rvRiwayatOrder;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    @BindView(R.id.kosong)
    TextView kosong;

    PresenterRiwayatOrder presenterRiwayatOrder;
    AdapterRiwayatOrder adapterRiwayatOrder;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);

        presenterRiwayatOrder = new PresenterRiwayatOrder(getContext(), this);
        presenterRiwayatOrder.onRiwayatOrder();
        adapterRiwayatOrder.notifyDataSetChanged();
        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    public void onSuccessRiwayatOrde(ArrayList<ModelRiwayatOrder> riwayatOrders) {
        swipeRefreshLayout.setRefreshing(false);
        if (riwayatOrders != null) {
            rvRiwayatOrder.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            adapterRiwayatOrder = new AdapterRiwayatOrder(getContext(), riwayatOrders, new AdapterRiwayatOrder.MethodCalback() {
                @Override
                public void onClick(ArrayList<ModelRiwayatOrder> list, int position) {
                    Toast.makeText(getContext(), "Posisi Ke : " + position, Toast.LENGTH_SHORT).show();
                }
            });
            rvRiwayatOrder.setAdapter(adapterRiwayatOrder);
            rvRiwayatOrder.setHasFixedSize(true);
            kosong.setVisibility(View.GONE);
            adapterRiwayatOrder.notifyDataSetChanged();
            rvRiwayatOrder.setVisibility(View.VISIBLE);
            mShimmerViewContainer.setVisibility(View.GONE);
        } else {
            rvRiwayatOrder.setVisibility(View.GONE);
            mShimmerViewContainer.setVisibility(View.GONE);
            kosong.setVisibility(View.VISIBLE);
        }
        adapterRiwayatOrder.notifyDataSetChanged();
        rvRiwayatOrder.setNestedScrollingEnabled(false);

    }
}
