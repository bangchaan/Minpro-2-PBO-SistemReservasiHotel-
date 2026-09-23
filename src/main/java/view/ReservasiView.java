package view;

import java.util.ArrayList;
import model.Reservasi;

public class ReservasiView {

    public void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("   TRACKING RESERVASI HOTEL");
        System.out.println("==============================");
        System.out.println("1. Tambah Reservasi");
        System.out.println("2. Tampilkan Semua Reservasi");
        System.out.println("3. Check-In Tamu");
        System.out.println("4. Check-Out Tamu");
        System.out.println("5. Update Reservasi");
        System.out.println("6. Hapus Reservasi");
        System.out.println("0. Keluar");
    }

    public void tampilkanPilihanTipe() {
        System.out.println("1. Standard (Rp300.000/malam, denda batal 20%)");
        System.out.println("2. VIP (Rp750.000/malam + biaya penyambutan)");
    }

    public void tampilkanPilihanLayanan() {
        System.out.println("1. Reguler");
        System.out.println("2. Executive Lounge (+Rp100.000)");
        System.out.println("3. Airport Pickup + Lounge (+Rp200.000)");
    }

    public void tampilkanMenuUpdate(boolean vip) {
        System.out.println("\n--- UPDATE RESERVASI ---");
        System.out.println("1. Update Nama");
        System.out.println("2. Update Jumlah Malam");
        if (vip) {
            System.out.println("3. Update Layanan Tambahan");
        }
        System.out.println("0. Kembali");
    }

    public void tampilkanDaftar(ArrayList <Reservasi> daftar) {
        System.out.println("\n--- DAFTAR RESERVASI ---");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada reservasi.");
            return;
        }

        System.out.printf("%-4s | %-15s | %-9s | %-6s | %-9s | %-12s | %s%n",
                "ID", "Nama Tamu", "Tipe", "Malam", "Status", "Total Biaya", "Detail");
        System.out.println("--------------------------------------------------------------------------------");

        for (Reservasi r : daftar) {
            System.out.printf("%-4d | %-15s | %-9s | %-6d | %-9s | Rp%-10d | %s%n",
                    r.getIdReservasi(), r.getNamaTamu(), r.getTipe(),
                    r.getJumlahMalam(), r.getStatus(), r.hitungTotalBiaya(), r.getDetailTambahan());
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}