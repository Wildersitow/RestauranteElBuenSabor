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

    private static final Producto[] catalogo = {
            new Producto("Bandeja Paisa",       32000),
            new Producto("Sancocho de Gallina", 28000),
            new Producto("Arepa con Huevo",      8000),
            new Producto("Jugo Natural",         7000),
            new Producto("Gaseosa",              4500),
            new Producto("Cerveza Poker",        6000),
            new Producto("Agua Panela",          3500),
            new Producto("Arroz con Pollo",     25000),
    };

    private static int    numeroMesa    = 0;
    private static int    estadoMesa    = 0;   // 0 = libre, 1 = activa
    private static double totalFactura  = 0;
    private static int    numeroFactura = 1;

    //Constructor privado para que no se pueda instanciar un new Datos
    private Datos() { }

    public static Producto[] getCatalogo() {
        return catalogo;
    }

    public static int getTotalProductosEnCarta() {
        return catalogo.length;
    }

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

    public static void   incrementarNumeroFactura() {
        numeroFactura++; }
}
