/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author alfre
 */
public class Proceso {

    private static final double TASA_IVA = 0.19;
    private static final double TASA_PROPINA            = 0.10;
    private static final double TASA_DESCUENTO_GRUPO    = 0.05;
    private static final double UMBRAL_PROPINA          = 50_000;
    private static final int    MIN_PRODUCTOS_DESCUENTO = 3;

    //En este taller las funciones son public static porque no se instancia ninguna clase
    public static double calcularTotal(){
        double subtotal        = calcularSubtotal();
        double subtotalConDesc = aplicarDescuento(subtotal);
        double total           = calcularTotalConImpuestos(subtotalConDesc);
        Datos.setEstadoMesa(1);
        Datos.setTotalFactura(total);

        return total;
    }

    private static double aplicarDescuento(double subtotal){
        if (contarProductosDiferentes() > MIN_PRODUCTOS_DESCUENTO) {
            return subtotal - (subtotal * TASA_DESCUENTO_GRUPO);
        }
        return subtotal;
    }

    private static double calcularTotalConImpuestos(double subtotal) {
        double iva   = subtotal * TASA_IVA;
        double total = subtotal + iva;

        if (subtotal > UMBRAL_PROPINA) {
            total += total * TASA_PROPINA;
        }

        return total;
    }

    public static double calcularSubtotal(){
        double subtotal = 0;

        for (Producto producto : Datos.getCatalogo()) {
            if (producto.tieneUnidades()) {
                subtotal += producto.getSubtotalProducto();
            }
        }

        return subtotal;
    }

    public static int contarProductosDiferentes() {
        int contador = 0;

        for (Producto producto : Datos.getCatalogo()) {
            if (producto.tieneUnidades()) {
                contador++;
            }
        }

        return contador;
    }

}

