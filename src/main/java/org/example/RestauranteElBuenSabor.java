/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.example;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        imprimirBienvenida();

        sc.close();
    }

    private static void imprimirBienvenida() {
        System.out.println("========================================");
        System.out.println("    " + Datos.nombreRestaurante.toUpperCase());
        System.out.println("    " + Datos.direccion);
        System.out.println("    NIT: " + Datos.nit);
        System.out.println("========================================");
    }

}
