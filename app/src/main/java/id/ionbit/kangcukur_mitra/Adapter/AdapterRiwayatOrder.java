package id.ionbit.kangcukur_mitra.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ionbit.kangcukur_mitra.Model.ModelRiwayatOrder;
import id.ionbit.kangcukur_mitra.R;

public class AdapterRiwayatOrder extends RecyclerView.Adapter<AdapterRiwayatOrder.BuatDesainViewHolder> {
    Context context;
    ArrayList<ModelRiwayatOrder> list;
    MethodCalback methodCalback;

    public AdapterRiwayatOrder(Context context, ArrayList<ModelRiwayatOrder> list, MethodCalback methodCalback) {
        this.context = context;
        this.list = list;
        this.methodCalback = methodCalback;
    }

    public interface MethodCalback {
        void onClick(ArrayList<ModelRiwayatOrder> list, int position);
    }

    @NonNull
    @Override
    public BuatDesainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_riwayatorder, parent, false);
        BuatDesainViewHolder vh = new BuatDesainViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BuatDesainViewHolder holder, int position) {
        ModelRiwayatOrder modelRiwayatOrder = list.get(position);
        holder.namaRiwayat.setText(modelRiwayatOrder.getNamaRiwayat());
        holder.tglRiwayat.setText(modelRiwayatOrder.getTglRiwayat());
        holder.hargaRiwayat.setText(modelRiwayatOrder.getHargaRiwayat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BuatDesainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.linear)
        LinearLayout linearLayout;
        @BindView(R.id.namaRiwayat)
        TextView namaRiwayat;
        @BindView(R.id.tglRiwayat)
        TextView tglRiwayat;
        @BindView(R.id.hargaRiwayat)
        TextView hargaRiwayat;

        public BuatDesainViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    methodCalback.onClick(list, getAdapterPosition());
                }
            });
        }
    }
}
