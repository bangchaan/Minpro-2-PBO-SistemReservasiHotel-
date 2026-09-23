package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Reservasi;
import model.ReservasiStandard;
import model.ReservasiVIP;
import view.ReservasiView;


public class ReservasiController {

    private final ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    private final ReservasiView view;
    private final Scanner scanner;
    private int idBerikutnya = 1;

    public ReservasiController(ReservasiView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
        isiDummyData();
    }

    private void isiDummyData() {
        buatStandard("Budi Santoso", 2);
        buatVip("Siti Aminah", 3, ReservasiVIP.PENYAMBUTAN_LOUNGE ).checkIn();

        Reservasi selesai = buatStandard("Andi Wijaya", 1);
        selesai.checkIn();
        selesai.checkOut();
    }

    private Reservasi buatStandard(String namaTamu, int jumlahMalam) {
        Reservasi r = new ReservasiStandard(idBerikutnya, namaTamu, jumlahMalam);
        idBerikutnya++;
        daftarReservasi.add(r);
        return r;
    }

    private Reservasi buatVip(String namaTamu, int jumlahMalam, String jenisPenyambutan) {
        Reservasi r = new ReservasiVIP(idBerikutnya, namaTamu, jumlahMalam, jenisPenyambutan);
        idBerikutnya++;
        daftarReservasi.add(r);
        return r;
    }

    public void tambahReservasi() {
        System.out.println("\n--- TAMBAH RESERVASI ---");
        System.out.println("1. Standard (Rp300.000/malam, denda pembatalan 20%)");
        System.out.println("2. VIP (Rp750.000/malam + layanan Rp100.000)");
        int jenis = inputAngka("Pilih tipe (1-2): ", 1, 2);
        String nama = inputTeks("Nama tamu: ");
        int malam = inputAngka("Jumlah malam (1-30): ", 1, 30);

        Reservasi r;
        if (jenis == 2) {
            System.out.println("Pilih jenis penyambutan:");
            System.out.println("1. Reguler (tanpa tambahan biaya)");
            System.out.println("2. Executive Lounge (+Rp100.000)");
            System.out.println("3. Airport Pickup + Lounge (+Rp200.000)");
            int pilihanPenyambutan = inputAngka("Pilih (1-3): ", 1, 3);

            String jenisPenyambutan;
            if (pilihanPenyambutan == 2) {
                jenisPenyambutan = ReservasiVIP.PENYAMBUTAN_LOUNGE ;
            } else if (pilihanPenyambutan == 3) {
                jenisPenyambutan = ReservasiVIP.PENYAMBUTAN_AIRPORT ;
            } else {
                jenisPenyambutan = ReservasiVIP.PENYAMBUTAN_REGULER ;
            }
            r = buatVip(nama, malam, jenisPenyambutan);
        } else {
            r = buatStandard(nama, malam);
        }

        view.tampilkanPesan(">> Berhasil! ID reservasi: " + r.getIdReservasi());
    }

    public void tampilkanReservasi() {
        view.tampilkanDaftarReservasi(daftarReservasi);
    }

    public void checkInReservasi() {
        System.out.println("\n--- CHECK-IN TAMU ---");
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);
        if (r != null && r.checkIn()) {
            view.tampilkanPesan(">> Check-in berhasil.");
        } else {
            view.tampilkanPesan(">> Gagal: ID tidak ditemukan / status bukan 'Menunggu'.");
        }
    }

    public void checkOutReservasi() {
        System.out.println("\n--- CHECK-OUT TAMU ---");
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);
        if (r != null && r.checkOut()) {
            view.tampilkanPesan(">> Check-out berhasil.");
        } else {
            view.tampilkanPesan(">> Gagal: ID tidak ditemukan / tamu belum check-in.");
        }
    }

    public void updateReservasi() {
        System.out.println("\n--- UPDATE JUMLAH MALAM ---");
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);
        if (r == null) {
            view.tampilkanPesan(">> ID tidak ditemukan.");
            return;
        }
        if (r.getStatus().equals(Reservasi.CHECK_OUT)) {
            view.tampilkanPesan(">> Gagal: tamu sudah check-out.");
            return;
        }
        int malamBaru = inputAngka("Jumlah malam baru (1-30): ", 1, 30);
        r.setJumlahMalam(malamBaru);
        view.tampilkanPesan(">> Data berhasil diperbarui.");
    }

    public void hapusReservasi() {
        System.out.println("\n--- HAPUS RESERVASI ---");
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);
        if (r == null) {
            view.tampilkanPesan(">> ID tidak ditemukan.");
            return;
        }

        int denda = r.hitungDenda();
        if (denda > 0 && !r.getStatus().equals(Reservasi.CHECK_OUT)) {
            view.tampilkanPesan(">> Dibatalkan sebelum selesai, kena denda pembatalan: Rp"
                    + String.format("%,d", denda));
        }

        daftarReservasi.remove(r);
        view.tampilkanPesan(">> Reservasi dihapus.");
    }

    private Reservasi cari(int id) {
        for (Reservasi r : daftarReservasi) {
            if (r.getIdReservasi() == id) {
                return r;
            }
        }
        return null;
    }

    public int inputAngka(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String teks = scanner.nextLine().trim();
            try {
                int angka = Integer.parseInt(teks);
                if (angka >= min && angka <= max) {
                    return angka;
                }
                System.out.println(">> Angka harus antara " + min + " dan " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println(">> Input harus berupa angka.");
            }
        }
    }

    private String inputTeks(String prompt) {
        String teks;
        do {
            System.out.print(prompt);
            teks = scanner.nextLine().trim();
            if (teks.isEmpty()) {
                System.out.println(">> Input tidak boleh kosong!");
            }
        } while (teks.isEmpty());
        return teks;
    }
}