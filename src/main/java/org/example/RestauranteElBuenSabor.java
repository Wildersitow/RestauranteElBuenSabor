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
        boolean ejecutando = true;

        while (ejecutando) {
            imprimirMenuPrincipal();
            
        }
        sc.close();
    }

    private static void imprimirBienvenida() {
        System.out.println("========================================");
        System.out.println("    " + Datos.nombreRestaurante.toUpperCase());
        System.out.println("    " + Datos.direccion);
        System.out.println("    NIT: " + Datos.nit);
        System.out.println("========================================");
    }

    private static void imprimirMenuPrincipal() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
    }

}
