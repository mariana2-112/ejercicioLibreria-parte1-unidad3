package Libreria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Libreria.utils.DatosComun;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Libreria {

    private ArrayList<Libro> libros = new ArrayList<Libro>();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private Usuario usuarioEnSesion;

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> lista : usuarios.values()) {
            for (Usuario usuario : lista) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contrasena)) {
                    usuarioEnSesion = usuario;
                    return usuario;
                }
            }
        }
        return null;
    }

    public void registrarCliente(){
        Cliente.registrarCliente();
    }

    public void mostarClientes(){
        Cliente.mostrarClientes();
    }

    public void obtenerDatosComun(Rol rol) {
        DatosComun.obtenerDatosComun(rol);
    }

    public void registrarAsistente() {
        Asistente.registrarAsistente();
    }

    public void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }
   public void registrarAdministrador() {
        Administrador.registrarAdministrador();
   }
   public void mostrarAdministradores() {
        Administrador.mostrarAdministradores();
   }




    public void eliminarUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Eliminar usuario ----\n");
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String nombreUsuario = scanner.nextLine();

        if (usuarios.containsKey(rol)) {
            ArrayList<Usuario> listaUsuarios = usuarios.get(rol);
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    listaUsuarios.remove(usuario);
                    System.out.println("\nUsuario eliminado");
                    return;
                }
            }
        }
        System.out.println("\nEste nombre no pertenece a ningún usuario");
    }

    private double registrarSueldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa el sueldo: ");
        return scanner.nextDouble();
    }

    private String registrarRFC() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa el RFC: ");
        return scanner.nextLine();
    }

    private String registrarINE() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa el INE: ");
        return scanner.nextLine();
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

        Libro libro = new Libro(titulo, autor, genero, idioma, precio);
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
                System.out.println(libro.getData());
                x++;
            }
        }
    }
}
