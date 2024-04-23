package Libreria.utils;

import Libreria.Libreria;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Administrador";
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));

        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");

        System.out.print("\n Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        DatosComun datos = new DatosComun();
        String telefono = datos.registrarTelefonoUsuario();
        String nombreUsuario = datos.registrarNombreUsuario();

        System.out.println("Ingrese la contraseña");
        String contraseña = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña));

        return datosComun;
    }

    public String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);

        boolean telefonoExistente = true;
        String telefono = "";

        do {
            System.out.println("\nIngresa el teléfono: ");
            telefono = scanner.nextLine();

            telefonoExistente = false;
            for (Map.Entry<Rol, ArrayList<Usuario>> entry : Libreria.usuarios.entrySet()) {
                for (Usuario usuario : entry.getValue()) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
                }
                if (telefonoExistente) break;
                System.out.println("\n El teléfono ya se encuentra registrado. Intenta de nuevo\n");
            }
        } while (telefonoExistente);

        return telefono;
    }

    public String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;

            for (Map.Entry<Rol, ArrayList<Usuario>> entry : Libreria.usuarios.entrySet()) {
                for (Usuario usuario : entry.getValue()) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
                        break;
                    }
                }
                if (nombreUsuarioExistente) break;
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }
}
