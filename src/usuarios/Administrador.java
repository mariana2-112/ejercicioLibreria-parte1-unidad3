package usuarios;

import Libreria.Libreria;
import Libreria.utils.DatosComun;
import usuarios.utils.Rol;

import java.util.ArrayList;

public class Administrador extends Usuario {
    private Double sueldo;
    private String RFC;
    private String INE;

    public Administrador(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,
                         Double sueldo, String RFC, String INE) {
        super(nombre, apellido, telefono, Rol.ADMINISTRADOR, nombreUsuario, contraseña);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, Sueldo: %.3f, RFC: %s, INE: %s",
                super.toString(), sueldo, RFC, INE);
    }

    public static void registrarAdministrador() {
        DatosComun datosComunUtil = new DatosComun();
        ArrayList<String> datosComun = datosComunUtil.obtenerDatosComun(Rol.ADMINISTRADOR);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        Double sueldo = Double.parseDouble(datosComun.get(5));
        String RFC = datosComun.get(6);
        String INE = datosComun.get(7);

        Administrador administrador = new Administrador(nombre, apellido, telefono, nombreUsuario, contraseña, sueldo, RFC, INE);

        if (!Libreria.usuarios.containsKey(Rol.ADMINISTRADOR)) {
            Libreria.usuarios.put(Rol.ADMINISTRADOR, new ArrayList<Usuario>());
        }

        Libreria.usuarios.get(Rol.ADMINISTRADOR).add(administrador);
        System.out.println("\nAdministrador registrado exitosamente\n");
    }

    public static void mostrarAdministradores() {
        System.out.println("\nAdministradores en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.ADMINISTRADOR)) {
            Administrador administrador = (Administrador) usuario;
            System.out.println(administrador.toString());
        }
    }
}
