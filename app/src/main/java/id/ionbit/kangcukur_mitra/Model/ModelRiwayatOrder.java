package id.ionbit.kangcukur_mitra.Model;

public class ModelRiwayatOrder {
String namaRiwayat;
String tglRiwayat;
String hargaRiwayat;

    public ModelRiwayatOrder(String namaRiwayat, String tglRiwayat, String hargaRiwayat) {
        this.namaRiwayat = namaRiwayat;
        this.tglRiwayat = tglRiwayat;
        this.hargaRiwayat = hargaRiwayat;
    }

    public ModelRiwayatOrder() {

    }

    public String getNamaRiwayat() {
        return namaRiwayat;
    }

    public void setNamaRiwayat(String namaRiwayat) {
        this.namaRiwayat = namaRiwayat;
    }

    public String getTglRiwayat() {
        return tglRiwayat;
    }

    public void setTglRiwayat(String tglRiwayat) {
        this.tglRiwayat = tglRiwayat;
    }

    public String getHargaRiwayat() {
        return hargaRiwayat;
    }

    public void setHargaRiwayat(String hargaRiwayat) {
        this.hargaRiwayat = hargaRiwayat;
    }
}
