package Libreria;
////////////////////////////
import java.time.LocalDate;
import java.util.*;

import Libreria.utils.DatosComun;
import Libros.Libro;
import Libros.constants.Genero;
import javafx.scene.input.GestureEvent;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.Administrador;
import java.util.ArrayList;
import usuarios.utils.Rol;


public class Libreria {

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    private final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Libreria() {
        inicializarHashMaps();
        LocalDate fechaRegistro = LocalDate.of(2004, 2, 23);
        Asistente asistente = new Asistente("Juan", "Rivera", "443831893122", 15000, "RUJU231231", "juan123", "mar", "mar", fechaRegistro);
        usuarios.get(Rol.ASISTENTE).add(asistente);

    }

    public void inicializarHashMaps(){
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.ADMINISTRADOR, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
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

}



