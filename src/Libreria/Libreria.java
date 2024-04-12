package Libreria;
import usuarios.Usuario;
import java.util.ArrayList;

public class Libreria {
    //    @SuppressWarnings("rawTypes")
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


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


}
