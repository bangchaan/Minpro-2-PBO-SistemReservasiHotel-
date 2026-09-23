package com.mycompany.reservasihotel;


import controller.ReservasiController;
import view.ReservasiView;
import java.util.Scanner;

public class SistemReservasiHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiView view = new ReservasiView();
        ReservasiController controller = new ReservasiController(view, scanner);

        boolean berjalan = true;
        while (berjalan) {
            view.tampilkanMenu();
            int pilihan = controller.inputAngka("Pilih menu: ", 0, 6);

            switch (pilihan) {
                case 1: controller.tambahReservasi(); break;
                case 2: controller.tampilkanReservasi(); break;
                case 3: controller.checkInReservasi(); break;
                case 4: controller.checkOutReservasi(); break;
                case 5: controller.updateReservasi(); break;
                case 6: controller.hapusReservasi(); break;
                case 0:
                    berjalan = false;
                    System.out.println("Terima kasih!");
                    break;
            }
        }
        scanner.close();
    }
}