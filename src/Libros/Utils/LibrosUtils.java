package Libros.Utils;

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
}
