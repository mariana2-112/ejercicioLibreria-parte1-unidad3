package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }

    @Override
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }


//    @Override //Indica que se está sobre escribiendo un método, por eso sale el simbolito de crculitos azules..
//    public String mostrarInfo() {
//        return String.format("%s, Fecha registro: %s", super.mostrarInfo(), fechaRegistro);
//    }
}