package com.mycompany.reservasihotel;

import controller.ReservasiController;
import java.util.Scanner;
import view.ReservasiView;

public class SistemReservasiHotel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ReservasiView view = new ReservasiView();
        ReservasiController controller = new ReservasiController(view, scanner);

        controller.jalankan();
    }
}