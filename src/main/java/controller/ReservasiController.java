package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Reservasi;
import model.ReservasiStandard;
import model.ReservasiVIP;
import view.ReservasiView;

public class ReservasiController {

    private ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    private ReservasiView view;
    private Scanner scanner;
    private int idBerikutnya = 1;

    public ReservasiController(ReservasiView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
        isiDummyData();
    }

    private void isiDummyData() {
        buatStandard("Budi Santoso", 2);

        buatVip("Siti Aminah", 3, ReservasiVIP.PENYAMBUTAN_LOUNGE).checkIn();

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

    public void jalankan() {
        boolean berjalan = true;

        while (berjalan) {
            view.tampilkanMenu();
            int pilihan = inputAngka("Pilih menu: ", 0, 6);

            switch (pilihan) {
                case 1:
                    tambahReservasi();
                    break;
                case 2:
                    view.tampilkanDaftar(daftarReservasi);
                    break;
                case 3:
                    checkInReservasi();
                    break;
                case 4:
                    checkOutReservasi();
                    break;
                case 5:
                    updateReservasi();
                    break;
                case 6:
                    hapusReservasi();
                    break;
                case 0:
                    berjalan = false;
                    view.tampilkanPesan("Terima kasih!");
                    break;
            }
        }
    }

    private void tambahReservasi() {
        System.out.println("\n--- TAMBAH RESERVASI ---");
        view.tampilkanPilihanTipe();

        int tipe = inputAngka("Pilih tipe (1-2): ", 1, 2);
        String nama = inputTeks("Nama tamu: ");
        int malam = inputAngka("Jumlah malam (1-30): ", 1, 30);

        Reservasi baru;

        if (tipe == 1) {
            baru = buatStandard(nama, malam);
        } else {
            view.tampilkanPilihanLayanan();

            int pilihan = inputAngka("Pilih layanan (1-3): ", 1, 3);
            String jenis;

            if (pilihan == 2) {
                jenis = ReservasiVIP.PENYAMBUTAN_LOUNGE;
            } else if (pilihan == 3) {
                jenis = ReservasiVIP.PENYAMBUTAN_AIRPORT;
            } else {
                jenis = ReservasiVIP.PENYAMBUTAN_REGULER;
            }

            baru = buatVip(nama, malam, jenis);
        }

        view.tampilkanPesan(">> Reservasi berhasil! ID: " + baru.getIdReservasi());
    }

    private void checkInReservasi() {
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);

        if (r != null && r.checkIn()) {
            view.tampilkanPesan(">> Check-in berhasil.");
        } else {
            view.tampilkanPesan(">> Gagal: ID tidak ditemukan atau status bukan Menunggu.");
        }
    }

    private void checkOutReservasi() {
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);

        if (r != null && r.checkOut()) {
            view.tampilkanPesan(">> Check-out berhasil.");
        } else {
            view.tampilkanPesan(">> Gagal: ID tidak ditemukan atau belum check-in.");
        }
    }

    private void updateReservasi() {
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);

        if (r == null) {
            view.tampilkanPesan(">> ID tidak ditemukan.");
            return;
        }
        
        if (Reservasi.CHECK_OUT.equals(r.getStatus())) {
       view.tampilkanPesan(">> Gagal: tamu sudah check-out.");
       return;
   }
        boolean vip = r instanceof ReservasiVIP;
        view.tampilkanMenuUpdate(vip);

        int batas = vip ? 3 : 2;
        int pilihan = inputAngka("Pilih: ", 0, batas);

        if (pilihan == 1) {
            String namaBaru = inputTeks("Nama baru: ");
            r.setNamaTamu(namaBaru);
            view.tampilkanPesan(">> Nama berhasil diperbarui.");

        } else if (pilihan == 2) {
            int malamBaru = inputAngka("Jumlah malam baru (1-30): ", 1, 30);
            r.setJumlahMalam(malamBaru);
            view.tampilkanPesan(">> Jumlah malam berhasil diperbarui.");

        } else if (pilihan == 3 && vip) {
            ReservasiVIP reservasiVIP = (ReservasiVIP) r;
            view.tampilkanPilihanLayanan();

            int layanan = inputAngka("Pilih layanan (1-3): ", 1, 3);

            if (layanan == 1) {
                reservasiVIP.setJenisPenyambutan(ReservasiVIP.PENYAMBUTAN_REGULER);
            } else if (layanan == 2) {
                reservasiVIP.setJenisPenyambutan(ReservasiVIP.PENYAMBUTAN_LOUNGE);
            } else {
                reservasiVIP.setJenisPenyambutan(ReservasiVIP.PENYAMBUTAN_AIRPORT);
            }

            view.tampilkanPesan(">> Layanan tambahan berhasil diperbarui.");
        }
    }

    private void hapusReservasi() {
        int id = inputAngka("ID reservasi: ", 1, Integer.MAX_VALUE);
        Reservasi r = cari(id);

        if (r == null) {
            view.tampilkanPesan(">> ID tidak ditemukan.");
            return;
        }

        int denda = r.hitungDenda();

        if (denda > 0 && !Reservasi.CHECK_OUT.equals(r.getStatus())) {
            view.tampilkanPesan(">> Denda pembatalan: Rp" + String.format("%,d", denda));
        }

        daftarReservasi.remove(r);
        view.tampilkanPesan(">> Reservasi berhasil dihapus.");
    }

    private Reservasi cari(int id) {
        for (Reservasi r : daftarReservasi) {
            if (r.getIdReservasi() == id) {
                return r;
            }
        }
        return null;
    }

    public int inputAngka(String pesan, int min, int max) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            try {
                int angka = Integer.parseInt(input);

                if (angka >= min && angka <= max) {
                    return angka;
                }

                System.out.println(">> Angka harus " + min + " sampai " + max + ".");

            } catch (NumberFormatException e) {
                System.out.println(">> Input harus berupa angka.");
            }
        }
    }

    private String inputTeks(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = scanner.nextLine().trim();

            if (teks.isEmpty()) {
                System.out.println(">> Input tidak boleh kosong.");
            } else if (teks.length() > Reservasi.MAKS_NAMA) {
                System.out.println(">> Nama maksimal " + Reservasi.MAKS_NAMA + " karakter.");
            } else {
                return teks;
            }
        }
    }
}