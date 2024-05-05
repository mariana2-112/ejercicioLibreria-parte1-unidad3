package usuarios;

import Libreria.Libreria;
import Libreria.utils.DatosComun;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña, String fechaNacimiento, String fechaRegistro ) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña);
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }


    @Override
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }

    public static void registrarCliente() {
        DatosComun datosComunUtil = new DatosComun(); // Crear una instancia de DatosComun
        ArrayList<String> datosComun = datosComunUtil.obtenerDatosComun(Rol.CLIENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);
        LocalDate fechaRegistro = LocalDate.now();

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimiento, fechaRegistro.toString());


        if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        Libreria.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\n Cliente registrado exitosamente\n");
    }

    public static void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
        }
    }

//    @Override //Indica que se está sobre escribiendo un método, por eso sale el simbolito de crculitos azules..
//    public String mostrarInfo() {
//        return String.format("%s, Fecha registro: %s", super.mostrarInfo(), fechaRegistro);
//    }
}