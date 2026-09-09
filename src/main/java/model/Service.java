package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private ArrayList<Kamar> daftarKamar;
    private ArrayList<Reservasi> daftarReservasi;

    private Scanner scanner;
    private int nomorUrut;

    public Service(Scanner scanner) {
        this.daftarKamar = new ArrayList<>();
        this.daftarReservasi = new ArrayList<>();
        this.scanner = scanner;
        this.nomorUrut = 1;
    }

// Validator agar memastikan pengguna menginput tidak kosong
    private String inputTeks(String label) {
        String input;
        do {
            System.out.print(label);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        } while (input.isEmpty());
        return input;
    }

    // Validator agar memastikan pengguna menginput angka lebih dari 0
    private int inputAngka(String label) {
        int angka;
        while (true) {
            System.out.print(label);
            if (scanner.hasNextInt()) {
                angka = scanner.nextInt();
                scanner.nextLine();
                if (angka > 0) {
                    break;
                }
                System.out.println("Angka harus lebih besar dari 0!");
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        return angka;
    }

    //  KELOLA KAMAR

    public void tambahKamar() {
        String tipeKamar = inputTeks("Tipe Kamar: ");
        int harga = inputAngka("Harga per Malam: ");

        int idKamar = nomorUrut;
        nomorUrut++;

        Kamar kamarBaru = new Kamar(idKamar, tipeKamar, harga);
        daftarKamar.add(kamarBaru);

        System.out.println("Kamar berhasil ditambahkan!");
        System.out.println("ID Kamar: " + idKamar);
    }

    public void tampilkanKamar() {
        if (daftarKamar.isEmpty()) {
            System.out.println("Belum ada data kamar.");
            return;
        }
        System.out.printf("%-6s | %-10s | %-12s | %-8s%n", "ID", "Tipe", "Harga", "Status");
        System.out.println("------------------------------------------");
        for (Kamar k : daftarKamar) {
            k.tampilkanInfo();
        }
    }

    // RESERVASI

    public void tambahReservasi() {
        if (daftarKamar.isEmpty()) {
            System.out.println(" Belum ada data kamar. Tambah kamar dulu!");
            return;
        }

        System.out.println("\n=== KAMAR TERSEDIA ===");
        System.out.printf("%-6s | %-10s | %-12s | %-8s%n", "ID", "Tipe", "Harga", "Status");
        System.out.println("------------------------------------------");
        for (Kamar k : daftarKamar) {
            if (k.getStatus().equals("Tersedia")) {
                k.tampilkanInfo();
            }
        }

        int idKamar = inputAngka("Pilih ID Kamar: ");

        Kamar kamarDipilih = null;
        for (Kamar k : daftarKamar) {
            if (k.getIdKamar() == idKamar && k.getStatus().equals("Tersedia")) {
            kamarDipilih = k;
            break;
            }
        }

        if (kamarDipilih == null) {
            System.out.println(" Kamar tidak tersedia!");
            return;
        }

        String namaTamu = inputTeks("Nama Tamu: ");
        int jumlahMalam = inputAngka("Jumlah Malam: ");

        int idReservasi = nomorUrut;
        nomorUrut++;

        Reservasi reservasiBaru = new Reservasi(idReservasi, namaTamu, kamarDipilih, jumlahMalam);
        daftarReservasi.add(reservasiBaru);
        kamarDipilih.setStatus("Terisi");

        System.out.println("Reservasi berhasil ditambahkan!");
        System.out.println("ID Reservasi: " + idReservasi);
    }

    public void tampilkanReservasi() {
        if (daftarReservasi.isEmpty()) {
            System.out.println(" Belum ada reservasi.");
            return;
        }
        System.out.printf("%-6s | %-15s | %-6s | %-10s | %-6s | %-14s%n",
                "ID", "Nama Tamu", "Kamar", "Tipe", "Malam", "Total Biaya");
        System.out.println("--------------------------------------------------------------------");
        for (int i = 0; i < daftarReservasi.size(); i++) {
            Reservasi r = daftarReservasi.get(i);
            r.tampilkanInfo();
        }
    }

    public void updateReservasi() {
        int idTarget = inputAngka("Masukkan ID Reservasi: ");

        for (Reservasi r : daftarReservasi) {
            if (r.getIdReservasi() == idTarget) {
                int malamBaru = inputAngka("Jumlah Malam Baru: ");
                r.setJumlahMalam(malamBaru);
                System.out.println(" Data reservasi berhasil diperbarui!");
                return;
            }
        }

        System.out.println("ID Reservasi tidak ditemukan!");
    }

    public void hapusReservasi() {
        int idTarget = inputAngka("Masukkan ID Reservasi: ");

        for (int i = 0; i < daftarReservasi.size(); i++) {
            Reservasi r = daftarReservasi.get(i);

            if (r.getIdReservasi() == idTarget) {
                r.tampilkanInfo();
                r.getKamar().setStatus("Tersedia");
                daftarReservasi.remove(i);
                System.out.println("Reservasi berhasil dihapus!");
                return;
            }
        }

        System.out.println("ID Reservasi tidak ditemukan!");
    }
}