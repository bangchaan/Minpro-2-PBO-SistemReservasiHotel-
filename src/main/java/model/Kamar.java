package model;

public class Kamar {

    private int idKamar;
    private String tipeKamar;
    private int hargaPerMalam;
    private String status;

    public Kamar(int idKamar, String tipeKamar, int hargaPerMalam) {
        this.idKamar = idKamar;
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = validasiHarga(hargaPerMalam);
        this.status = "Tersedia";
    }

    
    private int validasiHarga(int harga) {
        if (harga <= 0) {
            System.out.println("Harga tidak valid (harus > 0), otomatis diset ke 0.");
            return 0;
        }
        return harga;
    }

    public int getIdKamar() {
        return idKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
    System.out.printf("%-6d | %-10s | Rp%-10d | %-8s%n",
            idKamar, tipeKamar, hargaPerMalam, status);
    }
}