package model;

public class ReservasiVIP extends Reservasi {

    public static final String PENYAMBUTAN_REGULER  = "Reguler";
    public static final String PENYAMBUTAN_LOUNGE  = "Executive Lounge";
    public static final String PENYAMBUTAN_AIRPORT  = "Airport Pickup + Lounge";


    private String jenisPenyambutan;
    private int chargePenyambutan;

    public ReservasiVIP(int idReservasi, String namaTamu, int jumlahMalam, String jenisPenyambutan) {
        super(idReservasi, namaTamu, jumlahMalam, 750000);
        setJenisPenyambutan(jenisPenyambutan);
    }

    public void setJenisPenyambutan(String jenisPenyambutan) {
        switch (jenisPenyambutan) {
            case PENYAMBUTAN_LOUNGE :
                this.jenisPenyambutan = PENYAMBUTAN_LOUNGE ;
                this.chargePenyambutan = 100000;
                break;
            case PENYAMBUTAN_AIRPORT :
                this.jenisPenyambutan = PENYAMBUTAN_AIRPORT ;
                this.chargePenyambutan = 200000;
                break;
            default:
                this.jenisPenyambutan = PENYAMBUTAN_REGULER ;
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

    if (jenisPenyambutan.equals(PENYAMBUTAN_LOUNGE )) {
        biayaPenyambutan = 100000;
    } else if (jenisPenyambutan.equals(PENYAMBUTAN_AIRPORT )) {
        biayaPenyambutan = 200000;
    }

    return biayaKamar + biayaPenyambutan;
}

    @Override
    public String getDetailTambahan() {
        return "Penyambutan: " + jenisPenyambutan + " (+Rp" + String.format("%,d", chargePenyambutan) + ")";
    }
}