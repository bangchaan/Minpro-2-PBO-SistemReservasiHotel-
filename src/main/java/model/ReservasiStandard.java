package model;

public class ReservasiStandard extends Reservasi {

    private int dendaPembatalanPersen;

    public ReservasiStandard(int idReservasi, String namaTamu, int jumlahMalam) {
        super(idReservasi, namaTamu, jumlahMalam, 300000);
        setDendaPembatalanPersen(20); // kebijakan hotel
    }

    public int getDendaPembatalanPersen() { return dendaPembatalanPersen; }

    public void setDendaPembatalanPersen(int dendaPembatalanPersen) {
        if (dendaPembatalanPersen < 0 || dendaPembatalanPersen > 100) {
        throw new IllegalArgumentException("Persentase denda harus antara 0 - 100.");
    }
    this.dendaPembatalanPersen = dendaPembatalanPersen;
}
        

    @Override
    public String getTipe() {
        return "Standard";
    }

    @Override
    public int hitungDenda() {
        return hitungTotalBiaya() * dendaPembatalanPersen / 100;
    }

    @Override
    public String getDetailTambahan() {
        return "-";
    }
}