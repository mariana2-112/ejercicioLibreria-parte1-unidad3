package Libros;

import Libros.constants.Genero;

import java.time.LocalDate;

public abstract class Libro {

    private static int CANTIDAD_LIBROS = 1;
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
    private double precio;
    private Genero genero;
    private int stock;

    public Libro(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, Genero genero, int stock) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.genero = genero;
        this.stock = stock;
        CANTIDAD_LIBROS++;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", precio=" + precio +
                ", genero=" + genero +
                ", stock=" + stock +
                '}';
    }

    protected abstract void filtrarPorPrecioMeyorA(double precio);

    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);

    public double getPrecio() {
        return precio;
    }

    public String getAutor() {
        return autor;
    }
}

