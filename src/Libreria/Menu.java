package Libreria;

import usuarios.Usuario;

import java.util.Scanner;

public class Menu {
    private Libreria libreria = new Libreria();
    private Scanner scanner = new Scanner(System.in);
    boolean datosCorrectos;
    private boolean salir = false;

    public void iniciarSesion() {
        do {
            System.out.println("Bienvenido a la Biblioteca");
            System.out.println("Inicia sesion\n ");

            System.out.println("Ingresa tu usuario");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña");
            String contraseña = scanner.nextLine();
            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null) {
                //Datos correctos y mostramos menu correspondiente
                datosCorrectos = true;
                while (salir==false) {
                    seleccionarMenu(usuarioActual);
                }

            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo");
            }

        } while (!datosCorrectos);
    }

    private void seleccionarMenu(Usuario usuario) {
        switch (usuario.getRol()) {
            case CLIENTE:
                mostrarMenuCliente();
            case ASISTENTE:
                mostrarMenuAsistente();
            case GERENTE:
                mostrarMenuGerente();
                // -> es en vez de los puntos
        }

    }

    private void mostrarMenuCliente() {
        //hacer el menu para cada usuario con sus opciones pero cada caso vacio, solo tendra el break
        // Ctrl + Alt + L
        // Cada menu tiene la opcion de cerrar sesion
        System.out.println("----- Menu Cliente :) ------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Ver los libros");
        System.out.println("2. Consultar rentas");
        System.out.println("3. Salir");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1" :
                //Ver los libros
                break;
            case "2":
                //Consultar rentas
                break;
            case "3":
                salir= true;
                break;
            default:
                System.out.println("Ingrese una opcion valida");

        }

    }
    private void mostrarMenuAsistente() {
        System.out.println("----- Menu Cliente :) ------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Clientes");
        System.out.println("2. Libros");
        System.out.println("3. Consultar rentas");
        System.out.println("4. Salir");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("------ Clientes ------");
                System.out.println("1. Registrar Clientes");
                System.out.println("2. Consultar Clientes");
                System.out.println("3. Modificar Clientes");
                System.out.println("4. Eliminar Clientes");
                String opcion2 = scanner.nextLine();
                switch (opcion2) {
                    case "1":
                        //Registrar clientes
                        break;
                    case "2":
                        //Consultar clientes
                        break;
                    case "3":
                        //Modificar clientes
                        break;
                    case "4":
                        //Eliminar clientes
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
                break;
            case "2":
                System.out.println("------ Libros ------");
                System.out.println("1. Registrar Libro");
                System.out.println("2. Consultar Libro");
                System.out.println("3. Modificar Libro");
                System.out.println("4. Eliminar Libro");
                String opcion3 = scanner.nextLine();
                switch (opcion3) {
                    case "1":
                        //Registrar libro
                        break;
                    case "2":
                        //Consultar libro
                        break;
                    case "3":
                        //Modificar libro
                        break;
                    case "4":
                        //Eliminar libro
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
                break;
            case "3":
                salir= true;
                break;
            case "4":
                //Eliminar clientes
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }

    }

    private void mostrarMenuGerente() {
        System.out.println("----- Menu Gerente :) ------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Clientes");
        System.out.println("2. Libros");
        System.out.println("3. Rentas");
        System.out.println("4. Eliminar Asistente");
        System.out.println("5. Salir");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("------ Clientes ------");
                System.out.println("1. Registrar Clientes");
                System.out.println("2. Consultar Clientes");
                System.out.println("3. Modificar Clientes");
                System.out.println("4. Eliminar Clientes");
                String opcion2 = scanner.nextLine();
                switch (opcion2) {
                    case "1":
                        //Registrar clientes
                        break;
                    case "2":
                        //Consultar clientes
                        break;
                    case "3":
                        //Modificar clientes
                        break;
                    case "4":
                        //Eliminar clientes
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
                break;
            case "2":
                System.out.println("------ Libros ------");
                System.out.println("1. Registrar Libro");
                System.out.println("2. Consultar Libro");
                System.out.println("3. Modificar Libro");
                System.out.println("4. Eliminar Libro");
                String opcion3 = scanner.nextLine();
                switch (opcion3) {
                    case "1":
                        //Registrar libro
                        break;
                    case "2":
                        //Consuktar libro
                        break;
                    case "3":
                        //Modificar libro
                        break;
                    case "4":
                        //Eliminar libro
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
                break;
            case "3":
                System.out.println("------ Rentas ------");
                System.out.println("1. Registrar Renta");
                System.out.println("2. Consultar Renta");
                System.out.println("3. Modificar Renta");
                System.out.println("4. Eliminar Renta");
                String opcion4 = scanner.nextLine();
                switch (opcion4) {
                    case "1":
                        //Regustrar renta
                        break;
                    case "2":
                        //Consultar renta
                        break;
                    case "3":
                        //Modificar renta
                        break;
                    case "4":
                        //Eliminar renta
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
                break;
            case "4":
                //Eliminar Asistente
                break;
            case "5":
                salir= true;
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }

    }
}
