package org.example;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    //Cantidad no esta presente en el constructor ya que esta inicia como 0 siempre
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
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
