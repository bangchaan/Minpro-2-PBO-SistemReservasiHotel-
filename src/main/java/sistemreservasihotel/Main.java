package sistemreservasihotel;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> daftarNama = new ArrayList<>();
    static ArrayList<String> daftarTipeKamar = new ArrayList<>();
    static ArrayList<Integer> daftarMalam = new ArrayList<>();
    static ArrayList<Integer> daftarId = new ArrayList<>();
    static ArrayList<Integer> daftarTarif = new ArrayList<>();
    static int id = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean kondisi = true;
        dataAwal();

        while (kondisi) {
            System.out.println("\n|======================================|");
            System.out.println("|   Sistem Manajemen Reservasi Hotel   |");
            System.out.println("|======================================|");
            System.out.println("| [1] Tambah Reservasi                 |");
            System.out.println("| [2] Lihat Reservasi                  |");
            System.out.println("| [3] Perbarui Reservasi               |");
            System.out.println("| [4] Hapus Reservasi                  |");
            System.out.println("| [5] Keluar                           |");
            System.out.println("|======================================|");
            System.out.print("Masukkan Pilihan menu: "); 

            try { 
                int pilih = input.nextInt();
                input.nextLine();
                    if (pilih == 1){
                        tambahReservasi(input);                     
                    } else if (pilih == 2){
                        tampilkanReservasi();
                    } else if (pilih == 3){
                        perbaruiReservasi(input);
                    } else if (pilih == 4){
                        hapusReservasi(input);
                    } else if (pilih == 5){
                        kondisi = false;
                        System.out.println("\nTerima kasih, program selesai. Silahkan running kembali di lain waktu :) ");
                    } else {
                        System.out.println("Input tidak tersedia, silahkan input kembali!");
                    }
            } catch (java.util.InputMismatchException e){
                System.out.print("\nInput tidak valid, silahkan masukkan angka pada pilihan menu");
                input.nextLine();
            }
        }
    }
    
    private static void dataAwal(){
        daftarId.add(id++);
        daftarNama.add("Larry");
        daftarTipeKamar.add("DELUXE");
        daftarMalam.add(5);
        daftarTarif.add(tarif("deluxe") * 5);
        
        daftarId.add(id++);
        daftarNama.add("Polin");
        daftarTipeKamar.add("SUITE");
        daftarMalam.add(5);
        daftarTarif.add(tarif("Suite") * 5);
        
        daftarId.add(id++);
        daftarNama.add("Anugrah");
        daftarTipeKamar.add("STANDARD");
        daftarMalam.add(5);
        daftarTarif.add(tarif("standard") * 5);
  
    }
    
    // Method Menambahkan Reservasi   
    static void tambahReservasi(Scanner input) {
        System.out.println("\n======= Tambah Reservasi ==========");

        String nama = inputNama(input);
        String tipe = inputTipe(input);
        int malam = inputLamaMenginap(input);
        
        int tarifMalam = tarif(tipe);
        int total = tarifMalam * malam;
        System.out.println("Total Harga: Rp " + total);
        
        daftarId.add(id++);
        daftarNama.add(nama);
        daftarTipeKamar.add(tipe);
        daftarMalam.add(malam);
        daftarTarif.add(total);
        
        System.out.println("Reservasi berhasil ditambahkan!");
    }

    private static String inputNama(Scanner input) {
        while (true) {
            System.out.print("Nama Tamu: ");
            String nama = input.nextLine().trim();
            try {
                Integer.parseInt(nama);
                System.out.println("Nama tidak valid, Silahkan masukkan nama berupa huruf");
            } catch (NumberFormatException e){
                if (!nama.isEmpty()) {
                    return nama;
                }
                System.out.println("Nama tidak boleh kosong. Coba lagi.");
            }
        }
    }

    private static String inputTipe(Scanner input) {
        while (true) {
            System.out.print("Tipe Kamar (Deluxe, Suite, Standard): ");
            String tipe = input.nextLine().trim().toUpperCase();
            if (tipe.equalsIgnoreCase("DELUXE") || tipe.equalsIgnoreCase("SUITE") || tipe.equalsIgnoreCase("STANDARD")) {
                return tipe;
            }
            System.out.println("Tipe kamar tidak valid. Pilih 'Deluxe', 'Suite' atau 'Standard.");
        }
    }

    private static int inputLamaMenginap(Scanner input) {
        while (true) {
            System.out.print("Lama Menginap (malam): ");
            try {
                int malam = Integer.parseInt(input.nextLine().trim());
                if (malam > 0) {
                    return malam;
                }
                System.out.println("Lama menginap harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silahkan masukkan angka.");
            }
        }
    }
    
    private static int tarif(String tipe) {
        if (tipe.equalsIgnoreCase("deluxe")) {
            return 400000;
        } else if (tipe.equalsIgnoreCase("suite")) {
            return 750000;
        } else if (tipe.equalsIgnoreCase("standard")) {
            return 250000;
        } else {
            return 0; 
        }
    }
    
        // Method Menampilkan Reservasi
    static void tampilkanReservasi() {
        System.out.println("\n========== Daftar Reservasi ==========");
        if (daftarNama.isEmpty()) {
            System.out.println("Tidak ada reservasi yang terdaftar.");
        } else {
            for (int i = 0; i < daftarNama.size(); i++) {
                System.out.println("\nID             : " + daftarId.get(i));
                System.out.println("Nama           : " + daftarNama.get(i));
                System.out.println("Tipe Kamar     : " + daftarTipeKamar.get(i));
                System.out.println("Lama Menginap  : " + daftarMalam.get(i) + " malam");
                System.out.println("Tarif          : Rp " + daftarTarif.get(i));
                System.out.println("--------------------------------------");
            }
        }
    }
        
//    Method Memperbarui Reservasi
static void perbaruiReservasi(Scanner input) {
        if (daftarNama.isEmpty()) {
            System.out.println("Tidak ada reservasi untuk diperbarui.");
            return;
        }

        tampilkanReservasi();
        System.out.print("\nMasukkan ID reservasi yang ingin diperbarui: ");
        try {
            int id_reservasi = Integer.parseInt(input.nextLine().trim());
            int idx = daftarId.indexOf(id_reservasi);

            if (idx != -1) {
                System.out.println("========== Data Reservasi ==========");
                System.out.println("Nama           : " + daftarNama.get(idx));
                System.out.println("Tipe Kamar     : " + daftarTipeKamar.get(idx));
                System.out.println("Lama Menginap  : " + daftarMalam.get(idx) + " malam");

                String namaBaru = daftarNama.get(idx);
                String tipeBaru = daftarTipeKamar.get(idx);
                int malamBaru = daftarMalam.get(idx);
                int pilihan = 0;
                boolean batal = false;

                while (true) {
                    System.out.println("\n======================================");
                    System.out.println("| Pilih data yang ingin diperbarui   |");
                    System.out.println("|====================================|");
                    System.out.println("| [1] Nama Tamu                      |");
                    System.out.println("| [2] Tipe Kamar                     |");
                    System.out.println("| [3] Lama Menginap                  |");
                    System.out.println("| [4] Semua Data                     |");
                    System.out.println("| [5] Batal Perbarui                 |");
                    System.out.println("|====================================|");
                    System.out.print("Pilihan Anda: ");

                    try {
                        pilihan = input.nextInt();
                        input.nextLine(); // Membersihkan buffer
                        
                        if (pilihan == 1) {
                            namaBaru = inputNama(input);
                            System.out.println("Nama Tamu Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 2) {
                            tipeBaru = inputTipe(input);
                            System.out.println("Tipe Kamar Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 3) {
                            malamBaru = inputLamaMenginap(input);
                            System.out.println("Lama Menginap Berhasil DIperbarui!");
                            break;
                        } else if (pilihan == 4) {
                            namaBaru = inputNama(input);
                            tipeBaru = inputTipe(input);
                            malamBaru = inputLamaMenginap(input);
                            System.out.println("Reservasi Berhasil Diperbarui!");

                            break;
                        } else if (pilihan == 5) {
                            System.out.println("Pembaruan dibatalkan.");
                            batal = true;
                            break;
                        } else {
                            System.out.println("Pilihan tidak valid, coba lagi!");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.print("Input tidak valid, masukkan angka.");
                        input.nextLine();
                    }
                }
                
                if (batal) {
                    return;
                }

                int tarifMalam = tarif(tipeBaru);
                int totalBaru = tarifMalam * malamBaru;

                daftarNama.set(idx, namaBaru);
                daftarTipeKamar.set(idx, tipeBaru);
                daftarMalam.set(idx, malamBaru);
                daftarTarif.set(idx, totalBaru);

            } else {
                System.out.println("ID tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan ID berupa angka.");
        }
    }

    // Method Menghapus Reservasi
   static void hapusReservasi(Scanner input) {
        if (daftarNama.isEmpty()) {
            System.out.println("Tidak ada reservasi untuk dihapus.");
            return;
        }

        tampilkanReservasi();
        System.out.println("\n========== Hapus Reservasi ==========");
        System.out.print("Masukkan ID reservasi yang ingin dihapus: ");
        try {
            int id_reservasi = Integer.parseInt(input.nextLine().trim());
            int index = daftarId.indexOf(id_reservasi);

            if (index >= 0 && index < daftarNama.size()) {
                daftarNama.remove(index);
                daftarTipeKamar.remove(index);
                daftarMalam.remove(index);
                daftarId.remove(index);
                daftarTarif.remove(index);
                System.out.println("Reservasi berhasil dihapus!");
            } else {
                System.out.println("ID tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan ID berupa angka.");
        }
    }
}