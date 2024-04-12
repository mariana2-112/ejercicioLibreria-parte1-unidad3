import Libreria.Menu;
import usuarios.Cliente;
import usuarios.utils.Rol;

// Cliente - ver los libros, consultar sus rentas
//Asistente - CRUD (Create, Reed, Update, Delete), consultar rentas
//Gerente - CRUD completo del sistemea ademas de realizar rentas, eliminar asistentes y hacer rentas


public class Main {
    public static void main (String [] args) {
        Menu menu = new Menu();
        menu.iniciarSesion();
    }
}
