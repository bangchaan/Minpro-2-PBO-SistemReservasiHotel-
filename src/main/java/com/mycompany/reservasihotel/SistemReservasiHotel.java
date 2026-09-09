package com.mycompany.reservasihotel;

import model.Service;
import java.util.Scanner;

public class SistemReservasiHotel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service(scanner);

        boolean berjalan = true;

        while (berjalan) {

            System.out.println("\n==============================");
            System.out.println("    SISTEM RESERVASI HOTEL");
            System.out.println("==============================");
            System.out.println("1. Kelola Kamar");
            System.out.println("2. Menu Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    kelolaKamar(service, scanner);
                    break;

                case 2:
                    kelolaReservasi(service, scanner);
                    break;

                case 3:
                    berjalan = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }

    // Submenu Kelola Kamar
    private static void kelolaKamar(Service service, Scanner scanner) {
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n--- KELOLA KAMAR ---");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tampilkan Semua Kamar");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    service.tambahKamar();
                    break;

                case 2:
                    service.tampilkanKamar();
                    break;

                case 3:
                    kembali = true;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Submenu Kelola Reservasi
    private static void kelolaReservasi(Service service, Scanner scanner) {
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n--- MENU RESERVASI ---");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Tampilkan Semua Reservasi");
            System.out.println("3. Update Data Reservasi");
            System.out.println("4. Hapus Reservasi");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    service.tambahReservasi();
                    break;

                case 2:
                    service.tampilkanReservasi();
                    break;

                case 3:
                    service.updateReservasi();
                    break;

                case 4:
                    service.hapusReservasi();
                    break;

                case 5:
                    kembali = true;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}