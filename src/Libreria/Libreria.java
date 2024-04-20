package Libreria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Libreria {

    private ArrayList<Libro> libros = new ArrayList<Libro>();
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
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

    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);
        Cliente cliente = new Cliente(datosComun.get(0), datosComun.get(1), datosComun.get(2), datosComun.get(3), datosComun.get(4));

        usuarios.putIfAbsent(Rol.CLIENTE, new ArrayList<>());
        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente registrado exitosamente");
    }

    public void registrarAsistente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);
        Asistente asistente = new Asistente(datosComun.get(0), datosComun.get(1), datosComun.get(2), Double.parseDouble(datosComun.get(3)), datosComun.get(4), datosComun.get(5), datosComun.get(6));

        usuarios.putIfAbsent(Rol.ASISTENTE, new ArrayList<>());
        usuarios.get(Rol.ASISTENTE).add(asistente);
        System.out.println("\nRegistro exitoso");
    }

    public void registrarAdministrador() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ADMINISTRADOR);
        double sueldo = registrarSueldo();
        String RFC = registrarRFC();
        String INE = registrarINE();

        Administrador administrador = new Administrador(datosComun.get(0), datosComun.get(1), datosComun.get(2), datosComun.get(3), datosComun.get(4), sueldo, RFC, INE);

        usuarios.putIfAbsent(Rol.ADMINISTRADOR, new ArrayList<>());
        usuarios.get(Rol.ADMINISTRADOR).add(administrador);
        System.out.println("\nRegistro exitoso");
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        mostrarUsuarios(Rol.CLIENTE);
    }

    public void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        mostrarUsuarios(Rol.ASISTENTE);
    }

    public void mostrarAdministradores() {
        System.out.println("\nAdministradores en la biblioteca");
        mostrarUsuarios(Rol.ADMINISTRADOR);
    }

    private void mostrarUsuarios(Rol rol) {
        int x = 1;
        if (usuarios.containsKey(rol)) {
            for (Usuario usuario : usuarios.get(rol)) {
                System.out.println("\n---- " + rol + " " + x + " ----\n");
                System.out.println(usuario.toString());
                x++;
            }
        } else {
            System.out.println("No hay " + rol.toString().toLowerCase() + " registrados.");
        }
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

    public String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente;
        String telefono;

        do {
            System.out.println("\nIngresa el teléfono: ");
            telefono = scanner.nextLine();
            telefonoExistente = false;

            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        System.out.println("El teléfono ya se encuentra registrado. Intenta de nuevo.");
                        break;
                    }
                }
                if (telefonoExistente) break;
            }
        } while (telefonoExistente);

        return telefono;
    }

    public String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente;
        String nombreUsuario;

        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;

            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
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

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println(String.format("Bienvenido al registro del %s", rol));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        datosComun.add(scanner.nextLine());
        System.out.print("Apellido: ");
        datosComun.add(scanner.nextLine());
        System.out.print("Telefono: ");
        datosComun.add(registrarTelefonoUsuario());
        System.out.print("Nombre de usuario: ");
        datosComun.add(registrarNombreUsuario());
        System.out.print("Contraseña: ");
        datosComun.add(scanner.nextLine());

        if (rol == Rol.ASISTENTE) {
            System.out.print("Sueldo: ");
            datosComun.add(scanner.nextLine());
            System.out.print("RFC: ");
            datosComun.add(registrarRFC());
            System.out.print("INE: ");
            datosComun.add(registrarINE());
        }

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
