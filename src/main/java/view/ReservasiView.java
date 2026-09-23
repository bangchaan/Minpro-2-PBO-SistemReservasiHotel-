package view;

import model.Reservasi;
import java.util.ArrayList;

public class ReservasiView {

    public void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("   TRACKING RESERVASI HOTEL");
        System.out.println("==============================");
        System.out.println("1. Tambah Reservasi");
        System.out.println("2. Tampilkan Semua Reservasi");
        System.out.println("3. Check-In Tamu");
        System.out.println("4. Check-Out Tamu");
        System.out.println("5. Update Jumlah Malam");
        System.out.println("6. Hapus Reservasi");
        System.out.println("0. Keluar");
    }

    public void tampilkanDaftarReservasi(ArrayList<Reservasi> daftar) {
        System.out.println("\n--- DAFTAR RESERVASI ---");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada reservasi.");
            return;
        }
        System.out.printf("%-4s | %-15s | %-8s | %-6s | %-9s | %-12s | %s%n",
                "ID", "Nama Tamu", "Tipe", "Malam", "Status", "Total Biaya", "Detail");
        System.out.println("---------------------------------------------------------------------------------------");
        for (Reservasi r : daftar) {
            System.out.printf("%-4d | %-15s | %-8s | %-6d | %-9s | Rp%-10d | %s%n",
                    r.getIdReservasi(), 
                    r.getNamaTamu(), 
                    r.getTipe(),
                    r.getJumlahMalam(), 
                    r.getStatus(), 
                    r.hitungTotalBiaya(), 
                    r.getDetailTambahan());
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}