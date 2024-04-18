package Libreria;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
    //    @SuppressWarnings("rawTypes")
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Libreria(){
        Asistente asistente = new Asistente("Juan", "Rivera", "4433210999", 15000, "RUJU1234123", "juan123", "12345");

        usuarios.add(asistente);
    }


    public Usuario verificarInicioSesion(String nombreUusario, String contraseña){
        for(Usuario usuario : usuarios){
            if(usuario.getNombre().equals(nombreUusario)){
                if (usuario.getContraseña().equals(contraseña)){
                    return usuario;
                }
                return null;
            }
        }
        return null;
    }


    ////////////////////////////////////  CLIENTE  ////////////////////////////////////////


    public void registrarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrando Cliente");
        System.out.println("Ingresa los siguientes datos para continar");

        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuaraio();

        String nombreUsuario = registrarUsuario();

        System.out.println("Ingrese la contraseña");
        String contraseña = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);
        usuarios.add(cliente);
        System.out.println("\n Cliente añadido exitosamente");
    }

    public void mostrarClientes(){
        System.out.println("\n Clientes en la biblioteca");
        for(Usuario usuario : usuarios){
            if(usuario.getRol() == Rol.CLIENTE){
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }
    private String registrarTelefonoUsuaraio(){
        Scanner scanner = new Scanner(System.in);
        String telefono = "";
        boolean telefonoCorrecto = false;

        while (!telefonoCorrecto) {
            System.out.println("Ingrese el telefono");
            telefono = scanner.nextLine();

            telefonoCorrecto = true;  // Suponemos que el teléfono es correcto

            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)){
                    telefonoCorrecto = false;  // Cambiamos a falso si el teléfono ya existe
                    System.out.println("El telefono ya esta registrado");
                    break;
                }
            }
        }

        return telefono;
    }

    private String registrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombredeUsuarioExistente = true;  // Inicializamos en true para que entre en el bucle

        while (nombredeUsuarioExistente) {
            System.out.println("Ingrese el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombredeUsuarioExistente = false;  // Suponemos que el nombre de usuario es único

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)){
                    nombredeUsuarioExistente = true;  // Cambiamos a true si el nombre de usuario ya existe
                    System.out.println("El nombre de usuario ya existe");
                    break;
                }
            }
        }

        return nombreUsuario;
    }


    public void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminando Cliente");

        if (usuarios.isEmpty()) {
            System.out.println("No hay clientes registrados en la biblioteca.");
            return;
        }

        System.out.println("Ingrese el nombre de usuario del cliente que desea eliminar:");
        String nombreUsuarioEliminar = scanner.nextLine(); // Convertimos a minúsculas

        boolean encontrado = false; // Variable para verificar si se encontró el cliente

        // Usamos un bucle for para recorrer la lista de usuarios
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            String nombreUsuarioActual = usuario.getNombreUsuario().toLowerCase(); // Convertimos a minúsculas

            if (nombreUsuarioActual.contains(nombreUsuarioEliminar)) {
                usuarios.remove(i); // Eliminamos el usuario de la lista
                System.out.println("Cliente eliminado exitosamente.");
                encontrado = true; // Cambiamos el valor de la variable a true
                break; // Salimos del bucle una vez encontrado el usuario
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un cliente con el nombre de usuario ingresado.");
        }
    }


    ////////////////////////////////////  ASISTENTE  ////////////////////////////////////////

    public void registrarAsistente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrando Asistente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoAsistente();

        System.out.println("Ingrese el sueldo");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese el RFC");
        String RFC = scanner.nextLine();

        String nombreAsistente = registrarUsuarioAsistente();

        System.out.println("Ingrese la contraseña");
        String contraseña = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, RFC, nombreAsistente, contraseña);
        usuarios.add(asistente);
        System.out.println("\nAsistente añadido exitosamente");
    }

    public void mostrarAsistentes(){
        System.out.println("\nAsistentes en la biblioteca");
        for(Usuario usuario : usuarios){
            if(usuario.getRol() == Rol.ASISTENTE){
                Asistente asistente = (Asistente) usuario;
                System.out.println(asistente.toString());
            }
        }
    }

    private String registrarTelefonoAsistente(){
        Scanner scanner = new Scanner(System.in);
        String telefono = "";
        boolean telefonoCorrecto = false;

        while (!telefonoCorrecto) {
            System.out.println("Ingrese el telefono");
            telefono = scanner.nextLine();

            telefonoCorrecto = true;

            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)){
                    telefonoCorrecto = false;
                    System.out.println("El telefono ya está registrado");
                    break;
                }
            }
        }

        return telefono;
    }

    private String registrarUsuarioAsistente(){
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;

        while (nombreUsuarioExistente) {
            System.out.println("Ingrese el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)){
                    nombreUsuarioExistente = true;
                    System.out.println("El nombre de usuario ya existe");
                    break;
                }
            }
        }

        return nombreUsuario;
    }

////////////////////////////////////  ADMINISTRADOR  ////////////////////////////////////////

    public void registrarAdministrador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrando Administrador");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoAdministrador();

        String nombreUsuario = registrarUsuarioAdministrador();

        System.out.println("Ingrese la contraseña");
        String contraseña = scanner.nextLine();

        System.out.println("Ingrese el sueldo");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese el RFC");
        String RFC = scanner.nextLine();

        System.out.println("Ingrese el INE");
        String INE = scanner.nextLine();


        Administrador administrador = new Administrador(nombre, apellido, telefono, nombreUsuario, contraseña, sueldo, RFC, INE);
        usuarios.add(administrador);
        System.out.println("\nAdministrador añadido exitosamente");
    }

    public void mostrarAdministradores(){
        System.out.println("\nAdministradores en la biblioteca");
        for(Usuario usuario : usuarios){
            if(usuario.getRol() == Rol.ADMINISTRADOR){
                Administrador administrador = (Administrador) usuario;
                System.out.println(administrador.toString());
            }
        }
    }

    private String registrarTelefonoAdministrador(){
        Scanner scanner = new Scanner(System.in);
        String telefono = "";
        boolean telefonoCorrecto = false;

        while (!telefonoCorrecto) {
            System.out.println("Ingrese el telefono");
            telefono = scanner.nextLine();

            telefonoCorrecto = true;

            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)){
                    telefonoCorrecto = false;
                    System.out.println("El telefono ya está registrado");
                    break;
                }
            }
        }

        return telefono;
    }

    private String registrarUsuarioAdministrador(){
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;

        while (nombreUsuarioExistente) {
            System.out.println("Ingrese el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)){
                    nombreUsuarioExistente = true;
                    System.out.println("El nombre de usuario ya existe");
                    break;
                }
            }
        }

        return nombreUsuario;
    }
}