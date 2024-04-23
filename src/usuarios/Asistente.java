package usuarios;

import Libreria.Libreria;
import Libreria.utils.DatosComun;
import usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.Scanner;

import java.util.ArrayList;

public class Asistente extends Usuario {
    private LocalDate fechaInicio;
    private Double sueldo;
    private String RFC;
    private String INE;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String RFC, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contraseña);
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, Fecha de ingreso: %s, Sueldo: %.3f, RFC: %s, INE: %s, ",
                super.toString(), fechaInicio, sueldo, RFC, INE);
    }

    public static void registrarAsistente() {
        DatosComun datosComunUtil = new DatosComun();
        ArrayList<String> datosComun = datosComunUtil.obtenerDatosComun(Rol.ASISTENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        System.out.println("\nIngresa el sueldo: ");
        double sueldo = new Scanner(System.in).nextDouble();
        System.out.println("\nIngresa el RFC: ");
        String RFC = new Scanner(System.in).nextLine();
        System.out.println("\nIngresa el INE: ");
        String INE = new Scanner(System.in).nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, RFC, nombreUsuario, contraseña);

        if (!Libreria.usuarios.containsKey(Rol.ASISTENTE)) {
            Libreria.usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }

        Libreria.usuarios.get(Rol.ASISTENTE).add(asistente);
        System.out.println("\nAsistente registrado exitosamente\n");
    }

    public static void mostrarAsistentes() {
        System.out.println("\nAsistentes de la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
        }
    }

}
