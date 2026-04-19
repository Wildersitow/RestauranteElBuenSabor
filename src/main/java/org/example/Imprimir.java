/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author alfre
 */
public class Imprimir {

    private static final String SEPARADOR       = "========================================";
    private static final String SEPARADOR_CORTO = "----------------------------------------";
    private static final String FMT_LINEA_TOTAL = "%-27s $%,.0f%n";
    private static final String FMT_ITEM        = "%-20s x%-6d $%,.0f%n";

public static void mostrarCarta(){
    System.out.println(SEPARADOR);
    System.out.println("    " + Datos.nombreRestaurante.toUpperCase());
    System.out.println("    --- NUESTRA CARTA ---");
    System.out.println(SEPARADOR);
    int numero = 1;
    for (Producto producto : Datos.getCatalogo()) {
        System.out.printf("%d. %-22s $%,.0f%n", numero, producto.getNombre(), producto.getPrecio());
        numero++;
    }
    System.out.println(SEPARADOR);
}
public static void mostrarPedido(){
    double subtotal = 0;
    System.out.println("--- PEDIDO ACTUAL ---");
    for (Producto producto : Datos.getCatalogo()) {
        if (producto.tieneUnidades()) {
            System.out.printf(FMT_ITEM,
                    producto.getNombre(),
                    producto.getCantidad(),
                    producto.getSubtotalProducto());
            subtotal += producto.getSubtotalProducto();
        }
    }

    System.out.println("--------------------");
    System.out.printf(FMT_LINEA_TOTAL, "Subtotal:", subtotal);
}
public static void imprimirFacturaCompleta(double total){
    double subtotal = Proceso.calcularSubtotal();
    double subtotalConDesc = aplicarDescuento(subtotal);
    double iva = subtotalConDesc * 0.19;
    double propina = calcularPropina(subtotalConDesc, total, iva);

    imprimirEncabezadoRestaurante();
    System.out.printf("FACTURA No. %03d%n", Datos.getNumeroFactura());
    System.out.println(SEPARADOR_CORTO);

    imprimirItemsPedido();

    System.out.println(SEPARADOR_CORTO);
    imprimirTotales(subtotalConDesc, iva, propina, total);
    System.out.println(SEPARADOR);
    System.out.println("Gracias por su visita!");
    System.out.println(Datos.nombreRestaurante + " - " + Datos.direccion);
    System.out.println(SEPARADOR);

    actualizarEstadoPostFactura(total);
}

    private static void imprimirEncabezadoRestaurante() {
        System.out.println(SEPARADOR);
        System.out.println("    " + Datos.nombreRestaurante.toUpperCase());
        System.out.println("    " + Datos.direccion);
        System.out.println("    NIT: " + Datos.nit);
        System.out.println(SEPARADOR);
    }

    private static void imprimirItemsPedido() {
        for (Producto producto : Datos.getCatalogo()) {
            if (producto.tieneUnidades()) {
                System.out.printf(FMT_ITEM,
                        producto.getNombre(),
                        producto.getCantidad(),
                        producto.getSubtotalProducto());
            }
        }
    }

    private static void imprimirTotales(double subtotal, double iva, double propina, double total) {
        System.out.printf(FMT_LINEA_TOTAL, "Subtotal:", subtotal);
        System.out.printf(FMT_LINEA_TOTAL, "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf(FMT_LINEA_TOTAL, "Propina (10%):", propina);
        }

        System.out.println(SEPARADOR_CORTO);
        System.out.printf(FMT_LINEA_TOTAL, "TOTAL:", total);
    }

    private static void actualizarEstadoPostFactura(double total) {
        Datos.incrementarNumeroFactura();
        Datos.setEstadoMesa(0);
        Datos.setTotalFactura(total);
    }

    private static double aplicarDescuento(double subtotal) {
        if (Proceso.contarProductosDiferentes() > 3) {
            return subtotal - (subtotal * 0.05);
        }
        return subtotal;
    }

    private static double calcularPropina(double subtotal, double total, double iva) {
        if (subtotal > 50_000) {
            return total - subtotal - iva;
        }
        return 0;
    }
}
