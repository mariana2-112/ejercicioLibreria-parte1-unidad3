package Libreria;

import java.time.LocalDate;
import java.util.*;

import Libreria.utils.DatosComun;
import Libros.Libro;
import Libros.constants.Genero;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.Administrador;

import usuarios.utils.Rol;

public class Libreria {

    public static HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();


    private ArrayList<Libro> libros = new ArrayList<>();
    private Usuario usuarioEnSesion;

    public Libreria() {
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.ADMINISTRADOR, new ArrayList<>());

        LocalDate fechaRegistro = LocalDate.of(2004, 2, 23);
        Asistente asistente = new Asistente("Juan", "Rivera", "443831893122", 15000, "RUJU231231", "juan123", "mar", "mar", fechaRegistro);
        usuarios.get(Rol.ASISTENTE).add(asistente);

    }

    public static HashMap<Rol, ArrayList<Usuario>> getUsuarios() {
        return usuarios;
    }

    public void agregarAsistente(Asistente asistente) {
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);
    }
    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()){
            for(Usuario usuario : entry.getValue()){
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)){
                    return usuario;
                }
            }
        }
        return null;
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



