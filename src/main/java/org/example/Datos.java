/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author alfre
 */
public class Datos {
    public static final String nombreRestaurante = "Restaurante El Buen Sabor";
    public static final String direccion = "Calle 15 #8-32, Valledupar";
    public static final String nit = "900.123.456-7";

    private static int    numeroMesa    = 0;
    private static int    estadoMesa    = 0;   // 0 = libre, 1 = activa
    private static double totalFactura  = 0;
    private static int    numeroFactura = 1;

    public static int getNumeroMesa() {
        return numeroMesa;
    }

    public static void setNumeroMesa(int numeroMesa) {
        Datos.numeroMesa = numeroMesa;
    }

    public static int getEstadoMesa() {
        return estadoMesa;
    }

    public static void setEstadoMesa(int estadoMesa) {
        Datos.estadoMesa = estadoMesa;
    }

    public static double getTotalFactura() {
        return totalFactura;
    }

    public static void setTotalFactura(double totalFactura) {
        Datos.totalFactura = totalFactura;
    }

    public static int getNumeroFactura() {
        return numeroFactura;
    }

    public static void setNumeroFactura(int numeroFactura) {
        Datos.numeroFactura = numeroFactura;
    }
}
