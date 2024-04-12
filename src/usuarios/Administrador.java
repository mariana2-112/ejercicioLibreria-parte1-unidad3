package usuarios;

import usuarios.utils.Rol;

public class Administrador extends Usuario {
    private Double sueldo;
    private String RFC;
    private String INE;

    public Administrador(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,
                         Double sueldo, String RFC, String INE) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contraseña); // Llamada al constructor del padre
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, Sueldo: %.3f, RFC: %s, INE: %s",
                super.toString(), sueldo, RFC, INE);
    }
}
