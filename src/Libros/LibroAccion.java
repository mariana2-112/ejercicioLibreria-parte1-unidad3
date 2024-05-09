package Libros;

import Libros.Utils.LibrosUtils;
import Libros.constants.ClasificacionLibro;
import Libros.constants.Genero;
import Libros.constants.TerrorSubgenero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class
LibroAccion extends Libro {
    private ClasificacionLibro clasificacion;

    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock, ClasificacionLibro clasificacion) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.ACCION, stock);
        this.clasificacion = clasificacion;
    }

    public static void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros de Accion");
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        ClasificacionLibro clasificacionInput = null;
        System.out.println("Ingrese la clasificacion:");
        System.out.println("1. A\n2. B\n3. C");
        int opcionClasificacion = scanner.nextInt();

        if (opcionClasificacion == 1) {
            clasificacionInput = ClasificacionLibro.A;
        } else if (opcionClasificacion == 2) {
            clasificacionInput = ClasificacionLibro.B;
        } else if (opcionClasificacion == 3) {
            clasificacionInput = ClasificacionLibro.C;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock, clasificacionInput);
        System.out.println("\nRegistro exitoso de libro de terror.");
    }

}