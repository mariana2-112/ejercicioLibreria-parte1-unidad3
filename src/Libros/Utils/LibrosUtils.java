package Libros.Utils;

import Libros.Libro;
import Libros.constants.Genero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {

    public static ArrayList<String> registrarLibroDatosComun() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del Libro");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el nombre del autor");
        String autor = scanner.nextLine();

        System.out.println("Ingresa la editorial");
        String editorial = scanner.nextLine();

        System.out.println("Ingresa el dia de publicacion del libro");
        int diaPublicacion = scanner.nextInt();

        System.out.println("Ingresa el mes de publicacion");
        int mesPublicacion = scanner.nextInt();

        System.out.println("Ingrese el año de publicacion");
        int añoPublicacion = scanner.nextInt();

        LocalDate fecha = LocalDate.of(añoPublicacion, mesPublicacion, diaPublicacion);

        System.out.println("Ingresa el precio del libro");
        double precio = scanner.nextDouble();

        System.out.println("Ingresa el stock del libro");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, String.valueOf(fecha), String.valueOf(precio), String.valueOf(stock)));

        return datosComun;
    }


    public void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Registrar libro ----");
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nTítulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Libro libro = new Libro(titulo, autor, idioma, LocalDate.now(), precio, Genero.valueOf(genero.toUpperCase()), 1);

        libros.add(libro);
        System.out.println("\nRegistro exitoso");
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados aún");
        } else {
            System.out.println("\nLibros en la biblioteca");
            int x = 1;
            for (Libro libro : libros) {
                System.out.println("\n---- Libro " + x + " ----\n");
                System.out.println(libro.toString());
                x++;
            }
        }
    }
}
