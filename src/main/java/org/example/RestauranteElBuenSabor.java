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

    private static void opcionAgregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");

        int numeroProd = leerEntero("Numero de producto (1-" + Datos.getTotalProductosEnCarta() + "): ");

        if (!esProductoValido(numeroProd)) {
            return;
        }

        int cantidad = leerEntero("Cantidad: ");

        if (!esCantidadValida(cantidad)) {
            return;
        }

        if (Datos.getEstadoMesa() == 0) {
            pedirNumeroMesa();
        }

        Producto producto = Datos.getCatalogo()[numeroProd - 1];
        producto.agregarCantidad(cantidad);

        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
    }

    private static void pedirNumeroMesa() {
        int mesa = leerEntero("Ingrese numero de mesa: ");

        if (mesa > 0) {
            Datos.setNumeroMesa(mesa);
        } else {
            System.out.println("Numero de mesa invalido. Se asigna mesa 1 por defecto.");
            Datos.setNumeroMesa(1);
        }

        Datos.setEstadoMesa(1);
    }

    private static void opcionVerPedido() {
        if (Utilidades.hayProductosEnPedido()) {
            Imprimir.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
    }

    private static void opcionGenerarFactura() {
        if (!Utilidades.hayProductosEnPedido()) {
            System.out.println("No se puede generar factura.");
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
            return;
        }

        double total = Proceso.calcularTotal();
        Imprimir.imprimirFacturaCompleta(total);
    }

    private static boolean esCantidadValida(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser un valor positivo.");
            return false;
        }
        return true;
    }

    private static boolean esProductoValido(int numero) {
        if (numero <= 0) {
            System.out.println("El numero debe ser mayor a cero.");
            return false;
        }
        if (numero > Datos.getTotalProductosEnCarta()) {
            System.out.println("Producto no existe. La carta tiene "
                    + Datos.getTotalProductosEnCarta() + " productos.");
            return false;
        }
        return true;
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

}
