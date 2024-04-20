package Libreria;
public class Libro {

    private static int CANTIDAD_LIBROS = 1;
    private String titulo, autor, genero, idioma;
    private double precio;
    private int id;

    public Libro(String titulo, String autor, String genero, String idioma, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.precio = precio;
        this.id = CANTIDAD_LIBROS;
        CANTIDAD_LIBROS++;
    }

    public String getData() {
        return String.format("Título: %s \nAutor: %s \nGénero: %s \nID: %d \nIdioma: %s \nPrecio: %.2f", titulo, autor, genero, id, idioma, precio);
    }


}
