import dao.UsuarioDAO;
import model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario;

        System.out.println("Dime nombre a introducir:");
        String nombre =scanner.next();
        System.out.println("Dime correo a introducir:");
        String correo =scanner.next();
        System.out.println("Dime contraseña a introducir:");
        String pass =scanner.next();
        System.out.println("Dime telefono a introducir:");
        int telefono =scanner.nextInt();
        System.out.println("Dime id de perfil:");
        int id_perfil =scanner.nextInt();
        try {
            usuarioDAO.registrarUsuario(new Usuario(nombre,correo, pass,telefono,id_perfil));
        } catch (SQLException e) {
            System.out.println("Error en la ejecución");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }


    }
}
