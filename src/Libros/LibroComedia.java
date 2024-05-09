package Libros;

import Libros.Utils.LibrosUtils;
import Libros.constants.Genero;
import Libros.constants.TerrorSubgenero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro {

    public LibroComedia(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.COMEDIA, stock);
    }


    public static void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros de Comedia");
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroComedia libroComedia = new LibroComedia(nombre, autor, editorial, fechaPublicacion, precio, stock);
        System.out.println("\nRegistro exitoso de libro de terror.");
    }
}
