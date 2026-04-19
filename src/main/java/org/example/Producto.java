package org.example;

public class Producto {

    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }

    public void agregarCantidad(int unidades) {
        if (unidades > 0) {
            this.cantidad += unidades;
        }
    }

    public double getSubtotalProducto() {
        return precio * cantidad;
    }

    public boolean tieneUnidades() {
        return cantidad > 0;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre=" + nombre +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
