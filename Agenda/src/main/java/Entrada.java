import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("Dime nombre a introducir");
        String nombre = scanner.next();
        System.out.println("Dime correo a introducir");
        String correo = scanner.next();
        System.out.println("Dime pass a introducir");
        String pass = scanner.next();
        System.out.println("Dime teléfono a introducir");
        int telefono = scanner.nextInt();
        System.out.println("Dime id perfil a introducir");
        int id = scanner.nextInt();

        try {
            usuarioDAO.registrarUsuario(new Usuario(nombre,correo,pass,telefono,id));
        } catch (SQLException e) {
            System.out.println("Hay un error en la ejecución, quieres hacer XXX...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        System.out.println("Introduce el correo: ");
        String correo1=scanner.next();
        System.out.println("Introduce la contraseña: ");
        String pass2=scanner.next();
        try {
            if(usuarioDAO.realizarLogin(correo1, pass2)){
                System.out.println("Login correcto");
            } else System.out.println("Fallo de credenciales");
        } catch (SQLException e) {
            System.out.println("Hay un error en la ejecución, quieres hacer XXX...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }


    }
}
