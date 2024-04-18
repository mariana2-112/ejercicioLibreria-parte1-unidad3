package Libreria;

import usuarios.Usuario;
import utils.UsuarioEnSesion;

import java.sql.SQLOutput;
import java.util.Scanner;

/*
ELIMINAR CLIENTES, ASISTENTES Y GERENTES
ELIMINACION DE GERENTES solo se puede hacer por otro gerente
Listado de asistentes y gerentes
 */
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
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();

            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo");
            }

        } while (!datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE:
                mostrarMenuCliente();
            case ASISTENTE:
                mostrarMenuAsistente();
            case ADMINISTRADOR:
                mostrarMenuAdministrador();
                // -> es en vez de los puntos
        }

    }

    private void mostrarMenuCliente() {
        do {
            System.out.println("----- Menu Cliente :) ------");
            System.out.println("Elige la opcion: ");
            System.out.println("1. Ver los libros disponibles");
            System.out.println("2. Consultar mis rentas");
            System.out.println("3. Mostrar mis datos");
            System.out.println("4. Editar mi info");
            System.out.println("5. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    // Ver los libros
                    System.out.println("Opción 1 seleccionada");
                    break;
                case "2":
                    // Consultar rentas
                    System.out.println("Opción 2 seleccionada");
                    break;
                case "3":
                    // Mostrar mis datos
                    System.out.println("Opción 3 seleccionada");
                    break;
                case "4":
                    // Editar info
                    System.out.println("Opción 4 seleccionada");
                    break;
                case "5":
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }

        } while (!salir);
    }



    private void mostrarMenuAsistente() {
        do {
            System.out.println("----- Menu Asistente :) ------");
            System.out.println("Elige la opcion: ");
            System.out.println("1. Clientes");
            System.out.println("2. Libros");
            System.out.println("3. Cerrar Sesion");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    // Clientes
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("1. Registrar Cliente");
                    System.out.println("2. Modificar Cliente");
                    System.out.println("3. Eliminar Cliente");
                    System.out.println("4. Mostrar Clientes");
                    String op = scanner.nextLine();
                    switch (op) {
                        case "1":
                            //Registrar Cliente
                            libreria.registrarCliente();
                            break;
                        case "2":
                            //Modificar Cliente
                            break;
                        case "3":
                            //Eliminar Cliente
                            libreria.eliminarCliente();
                            break;
                        case "4":
                            //Mostrar Clientes
                            libreria.mostrarClientes();
                            break;
                    }
                    break;

                case "2":
                    // Libro
                    System.out.println("Opción 4 seleccionada");
                    System.out.println("1. Registrar Libro");
                    System.out.println("2. Modificar Libro");
                    System.out.println("3. Eliminar Libro");
                    System.out.println("4. Mostrar Libros");
                    System.out.println("5. Mostrar Libros Rentados");
                    System.out.println("6. Rentar libro");
                    String op3 = scanner.nextLine();
                    switch (op3) {
                        case "1":
                            //Registrar Libros
                            break;
                        case "2":
                            //Modificar Libro
                            break;
                        case "3":
                            //Eliminar Libro
                            break;
                        case "4":
                            //Mostrar Libros
                            break;
                    }
                    break;

                case "3":
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }

        } while (!salir);
    }


    ////////////////////////////////////  ADMINISTRADOR  ////////////////////////////////////////

    private void mostrarMenuAdministrador() {

        do {
            System.out.println("----- Menu Gerente :) ------");
            System.out.println("Elige la opcion: ");
            System.out.println("1. Clientes");
            System.out.println("2. Asistentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Libros");
            System.out.println("5. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    // Clientes
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("1. Registrar Cliente");
                    System.out.println("2. Modificar Cliente");
                    System.out.println("3. Eliminar Cliente");
                    System.out.println("4. Mostrar Clientes");
                    String op = scanner.nextLine();
                    switch (op) {
                        case "1":
                            //Registrar Cliente
                            libreria.registrarCliente();
                            break;
                        case "2":
                            //Modificar Cliente
                            break;
                        case "3":
                            //Eliminar Cliente
                            libreria.eliminarCliente();
                            break;
                        case "4":
                            //Mostrar Clientes
                            libreria.mostrarClientes();
                            break;
                    }
                    break;

                case "2":
                    // Asistente
                    System.out.println("Opción 2 seleccionada");
                    System.out.println("1. Registrar Asiente");
                    System.out.println("2. Modificar Asiente");
                    System.out.println("3. Eliminar Asiente");
                    System.out.println("4. Mostrar Asientes");
                    String op1 = scanner.nextLine();
                    switch (op1) {
                        case "1":
                            //Registrar Asistente
                            libreria.registrarAsistente();
                            break;
                        case "2":
                            //Modificar Asistene
                            break;
                        case "3":
                            //Eliminar Asistente
                            break;
                        case "4":
                            //Mostrar Asistentes
                            libreria.mostrarAsistentes();
                            break;
                    }
                    break;

                case "3":
                    // Gerente
                    System.out.println("Opción 3 seleccionada");
                    System.out.println("1. Registrar Gerente");
                    System.out.println("2. Modificar Gerente");
                    System.out.println("3. Eliminar Gerente");
                    System.out.println("4. Mostrar Gerentes");
                    String op2 = scanner.nextLine();
                    switch (op2) {
                        case "1":
                            //Registrar Gerente
                            libreria.registrarAdministrador();
                            break;
                        case "2":
                            //Modificar Gerente
                            break;
                        case "3":
                            //Eliminar Gerente
                            break;
                        case "4":
                            //Mostrar Gerentes
                            libreria.mostrarAdministradores();
                            break;
                    }
                    break;

                case "4":
                    // Libro
                    System.out.println("Opción 4 seleccionada");
                    System.out.println("1. Registrar Libro");
                    System.out.println("2. Modificar Libro");
                    System.out.println("3. Eliminar Libro");
                    System.out.println("4. Mostrar Libros");
                    System.out.println("5. Mostrar Libros Rentados");
                    System.out.println("6. Rentar libro");
                    String op3 = scanner.nextLine();
                    switch (op3) {
                        case "1":
                            //Registrar Libros
                            break;
                        case "2":
                            //Modificar Libro
                            break;
                        case "3":
                            //Eliminar Libro
                            break;
                        case "4":
                            //Mostrar Libros
                            break;
                    }
                    break;

                case "5":
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        } while (!salir);
    }
}
