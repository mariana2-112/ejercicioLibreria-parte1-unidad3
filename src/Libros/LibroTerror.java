package Libros;

import Libros.Utils.LibrosUtils;
import Libros.constants.Genero;
import Libros.constants.TerrorSubgenero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroTerror extends Libro {
    private TerrorSubgenero subgenero;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock, TerrorSubgenero subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.TERROR, stock);
        this.subgenero = subgenero;
    }

    public static void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros de Terror");
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        TerrorSubgenero subgeneroInput = null;
        System.out.println("Ingrese el subgénero del libro:");
        System.out.println("1. Psicológico\n2. Monjas");
        int opcionSubgenero = scanner.nextInt();

        if (opcionSubgenero == 1) {
            subgeneroInput = TerrorSubgenero.PSICOLOGICO;
        } else if (opcionSubgenero == 2) {
            subgeneroInput = TerrorSubgenero.MONJAS;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
        System.out.println("\nRegistro exitoso de libro de terror.");
    }

    @Override
    public void filtrarPorPrecioMeyorA(double precio) {
        Libreria.getLibros().get(Genero.TERROR).stream().filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.getLibros().get(Genero.TERROR).stream().filter(libro -> libro.getAutor().toLowerCase().contains(inicial)).forEach(libro -> System.out.println(libro.toString()));
    }

}




