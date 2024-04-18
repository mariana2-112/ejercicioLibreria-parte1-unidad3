package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;

public class Asistente extends Usuario {
    private LocalDate fechaInicio;
    private Double sueldo;
    private String RFC;
    private String INE;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String RFC, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contraseña);
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, Fecha de ingreso: %s, Sueldo: %.3f, RFC: %s, INE: %s, ",
                super.toString(), fechaInicio, sueldo, RFC, INE);
    }
}
