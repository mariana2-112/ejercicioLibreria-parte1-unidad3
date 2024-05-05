import Libreria.Menu;
import usuarios.Cliente;
import usuarios.utils.Rol;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Cliente - ver los libros, consultar sus rentas
//Asistente - CRUD (Create, Reed, Update, Delete), consultar rentas
//Gerente - CRUD completo del sistemea ademas de realizar rentas, eliminar asistentes y hacer rentas

//CTRL+ALT+L

//Clases Abstractas
//Interfaces
public class Main {
    public static void main (String [] args) {
        Menu menu = new Menu();
        menu.iniciarSesion();

        LocalDate fecha= LocalDate.of(2000, 9,23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(fecha);
//
//        LocalTime hora = LocalTime.of(50, 5, 10);
//
//        LocalDateTime fechaCompleta = LocalDateTime.of(2024, 11, 0, 9, 11, 23);
//        System.out.println(fechaCompleta);
//
//        DateTimeFormatter fechaCustom = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//        String fechaFormateada = fechaCustom.format(fecha);
//        System.out.println(fechaFormateada);

    }
}
