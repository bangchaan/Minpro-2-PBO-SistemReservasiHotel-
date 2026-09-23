package model;

// ReservasiVIP IS-A Reservasi — pembeda: jenis penyambutan, tiap jenis punya charge beda
public class ReservasiVIP extends Reservasi {

    public static final String PenyambutanReguler = "Reguler";
    public static final String PenyambutanLounge = "Executive Lounge";
    public static final String PenyambutanAirport = "Airport Pickup + Lounge";

    private static final int BiayaLayanan = 100000;

    private String jenisPenyambutan;
    private int chargePenyambutan;

    public ReservasiVIP(int idReservasi, String namaTamu, int jumlahMalam, String jenisPenyambutan) {
        super(idReservasi, namaTamu, jumlahMalam, 750000);
        setJenisPenyambutan(jenisPenyambutan);
    }

    public void setJenisPenyambutan(String jenisPenyambutan) {
        switch (jenisPenyambutan) {
            case PenyambutanLounge:
                this.jenisPenyambutan = PenyambutanLounge;
                this.chargePenyambutan = 100000;
                break;
            case PenyambutanAirport:
                this.jenisPenyambutan = PenyambutanAirport;
                this.chargePenyambutan = 200000;
                break;
            default:
                this.jenisPenyambutan = PenyambutanReguler;
                this.chargePenyambutan = 0;
        }
    }

    @Override
    public String getTipe() {
        return "VIP";
    }

    @Override
    public int hitungTotalBiaya() {
    int biayaKamar = getJumlahMalam() * 750000;
    int biayaPenyambutan = 0;

    if (jenisPenyambutan.equals(PenyambutanLounge)) {
        biayaPenyambutan = 100000;
    } else if (jenisPenyambutan.equals(PenyambutanAirport)) {
        biayaPenyambutan = 200000;
    }

    return biayaKamar + biayaPenyambutan;
}

    @Override
    public String getDetailTambahan() {
        return "Penyambutan: " + jenisPenyambutan + " (+Rp" + String.format("%,d", chargePenyambutan) + ")";
    }
}