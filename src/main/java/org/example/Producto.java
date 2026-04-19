package org.example;

public class Producto {

    private int nombre;
    private int precio;
    private int cantidad;

    public Producto(int nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
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
