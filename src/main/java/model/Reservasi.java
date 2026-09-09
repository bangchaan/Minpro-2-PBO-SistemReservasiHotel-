package model;

public class Reservasi {
    private int idReservasi;
    private String namaTamu;
    private Kamar kamar;
    private int jumlahMalam;

    public Reservasi(int idReservasi, String namaTamu, Kamar kamar, int jumlahMalam) {
        this.idReservasi = idReservasi;
        this.namaTamu = namaTamu;
        this.kamar = kamar;
        this.jumlahMalam = validasiJumlah(jumlahMalam);
    }

    // Validator umlah malam tidak boleh 0 atau minus.
    private int validasiJumlah(int jumlahMalam) {
        if (jumlahMalam <= 0) {
            System.out.println("Jumlah malam tidak valid (harus > 0), otomatis diset ke 1.");
            return 1;
        }
        return jumlahMalam;
    }

    public int getIdReservasi() {
        return idReservasi;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public void setJumlahMalam(int jumlahMalam) {
        this.jumlahMalam = validasiJumlah(jumlahMalam);
    }

    public int hitungTotalBiaya() {
        return jumlahMalam * kamar.getHargaPerMalam();
    }

    public void tampilkanInfo() {
    System.out.printf("%-6d | %-15s | %-6d | %-10s | %-6d | Rp%-14d%n",
            idReservasi, namaTamu, kamar.getIdKamar(), kamar.getTipeKamar(),
            jumlahMalam, hitungTotalBiaya());
}
    }
