/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author alfre
 */
public class Utilidades {

    private Utilidades() { }

    public static boolean hayProductosEnPedido() {
        for (Producto producto : Datos.getCatalogo()) {
            if (producto.tieneUnidades()) {
                return true;
            }
        }
        return false;
    }

    public static void reiniciarPedido() {
        for (Producto producto : Datos.getCatalogo()) {
            producto.setCantidad(0);
        }
        Datos.setTotalFactura(0);
        Datos.setEstadoMesa(0);
        Datos.setNumeroMesa(0);
    }

}
