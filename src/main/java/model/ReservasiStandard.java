package model;

public class ReservasiStandard extends Reservasi {

    private int dendaPersen;

    public ReservasiStandard(int idReservasi, String namaTamu,
            int jumlahMalam) {

        super(idReservasi, namaTamu, jumlahMalam, 300000);

        setDendaPersen(20);
    }

    public int getDendaPersen() {
        return dendaPersen;
    }

    public void setDendaPersen(int dendaPersen) {
        if (dendaPersen >= 0 && dendaPersen <= 100) {
            this.dendaPersen = dendaPersen;
        } else {
            this.dendaPersen = 20;
        }
    }

    @Override
    public String getTipe() {
        return "Standard";
    }

    @Override
    public int hitungDenda() {
        return hitungTotalBiaya() * dendaPersen / 100;
    }

    @Override
    public String getDetailTambahan() {
        return "Denda batal: " + dendaPersen + "%";
    }
}