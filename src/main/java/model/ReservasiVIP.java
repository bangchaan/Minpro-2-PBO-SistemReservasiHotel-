package model;

public class ReservasiVIP extends Reservasi {

    public static final String PENYAMBUTAN_REGULER = "Reguler";
    public static final String PENYAMBUTAN_LOUNGE = "Executive Lounge";
    public static final String PENYAMBUTAN_AIRPORT = "Airport Pickup + Lounge";

    private String jenisPenyambutan;
    private int biayaPenyambutan;

    public ReservasiVIP(int idReservasi, String namaTamu,
            int jumlahMalam, String jenisPenyambutan) {

        super(idReservasi, namaTamu, jumlahMalam, 750000);

        setJenisPenyambutan(jenisPenyambutan);
    }

    public String getJenisPenyambutan() {
        return jenisPenyambutan;
    }

    public int getBiayaPenyambutan() {
        return biayaPenyambutan;
    }

    public void setJenisPenyambutan(String jenisPenyambutan) {

        if (PENYAMBUTAN_LOUNGE.equals(jenisPenyambutan)) {

            this.jenisPenyambutan = PENYAMBUTAN_LOUNGE;
            this.biayaPenyambutan = 100000;

        } else if (PENYAMBUTAN_AIRPORT.equals(jenisPenyambutan)) {

            this.jenisPenyambutan = PENYAMBUTAN_AIRPORT;
            this.biayaPenyambutan = 200000;

        } else {

            this.jenisPenyambutan = PENYAMBUTAN_REGULER;
            this.biayaPenyambutan = 0;
        }
    }

    @Override
    public String getTipe() {
        return "VIP";
    }

    @Override
    public int hitungTotalBiaya() {
        return super.hitungTotalBiaya() + biayaPenyambutan;
    }

    @Override
    public String getDetailTambahan() {
        return "Penyambutan: " + jenisPenyambutan
                + " (+Rp"
                + String.format("%,d", biayaPenyambutan)
                + ")";
    }
}