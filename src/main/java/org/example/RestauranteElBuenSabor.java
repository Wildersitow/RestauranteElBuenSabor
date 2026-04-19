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
            int opcion = leerEntero("Seleccione una opcion: ");
            ejecutando = procesarOpcion(opcion);
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

    private static boolean procesarOpcion(int opcion) {
        System.out.println();

        switch (opcion) {
            case 1:
                Imprimir.mostrarCarta();
                break;
            case 2:
                opcionAgregarProducto();
                break;
            case 3:
                opcionVerPedido();
                break;
            case 4:
                opcionGenerarFactura();
                break;
            case 5:
                opcionNuevaMesa();
                break;
            case 0:
                System.out.println("Hasta luego!");
                return false;
            default:
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");

        }

        System.out.println();
        return true;
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

}
