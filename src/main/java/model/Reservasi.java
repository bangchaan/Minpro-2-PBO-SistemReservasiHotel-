package model;

public class Reservasi {

    public static final int MAKS_NAMA = 25;

    public static final String MENUNGGU = "Menunggu";
    public static final String CHECK_IN = "Check-In";
    public static final String CHECK_OUT = "Check-Out";

    private final int idReservasi;
    private final int hargaPerMalam;
    private String namaTamu;
    private int jumlahMalam;
    private String status;

    public Reservasi(int idReservasi, String namaTamu,
            int jumlahMalam, int hargaPerMalam) {

        this.idReservasi = idReservasi;
        this.hargaPerMalam = hargaPerMalam;
        this.status = MENUNGGU;

        setNamaTamu(namaTamu);
        setJumlahMalam(jumlahMalam);
    }

    public int getIdReservasi() {
        return idReservasi;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public String getStatus() {
        return status;
    }

    public void setNamaTamu(String namaTamu) {
        if (namaTamu != null && !namaTamu.trim().isEmpty()) {
            this.namaTamu = namaTamu.trim();
        } else {
            this.namaTamu = "Tanpa Nama";
        }
    }

    public void setJumlahMalam(int jumlahMalam) {
        if (jumlahMalam >= 1 && jumlahMalam <= 30) {
            this.jumlahMalam = jumlahMalam;
        } else {
            this.jumlahMalam = 1;
        }
    }

    public boolean checkIn() {
        if (status.equals(MENUNGGU)) {
            status = CHECK_IN;
            return true;
        }
        return false;
    }

    public boolean checkOut() {
        if (status.equals(CHECK_IN)) {
            status = CHECK_OUT;
            return true;
        }
        return false;
    }

    public String getTipe() {
        return "Umum";
    }

    public int hitungTotalBiaya() {
        return jumlahMalam * hargaPerMalam;
    }

    public int hitungDenda() {
        return 0;
    }

    public String getDetailTambahan() {
        return "-";
    }
}