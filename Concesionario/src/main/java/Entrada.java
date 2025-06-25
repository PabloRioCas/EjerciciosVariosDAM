import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entrada {

    public static void main(String[] args) {

//        agregarCoche("mercedes","E63 AMG", 290000);
//        agregarCoche("mercedes","C 300", 43453);
        agregarCoche("mercedes","S200", 340000);
        borrarCoche("C300");
    }

    public static void agregarCoche(String marca, String modelo, int precio){
        Connection connection = new DBConnection().getConnection();
        //Una vez tengo la conexión, ahora habría que hacer un CRUD sobre la DB
        // CRUD -> Create, Select, Update, Delete
        //Tenemos 3 objetos para trabajar con DB
        //Statement -> Ejecuta una query directa-> INSERT/UPDATE/DELETE
        // PrepareStatement -> Ejecuta una query parametrizada -> INSERT/UPDATE/DELETE
        //Resultset -> Ejecuya una query de SELECCIÓN ->SELECT
        String query = String.format("INSERT INTO %s (%s, %s, %s) VALUE (?, ?, ?)",
                "coches","marca","modelo","precio");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,marca);
            preparedStatement.setString(2,modelo);
            preparedStatement.setInt(3,precio);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("La petición es incorrecta");
            System.out.println(e.getMessage());
        }
    }

    public static void borrarCoche(String modelo){
        Connection connection = new DBConnection().getConnection();
        //Una vez tengo la conexión, ahora habría que hacer un CRUD sobre la DB
        // CRUD -> Create, Select, Update, Delete
        //Tenemos 3 objetos para trabajar con DB
        //Statement -> Ejecuta una query directa-> INSERT/UPDATE/DELETE
        // PrepareStatement -> Ejecuta una query parametrizada -> INSERT/UPDATE/DELETE
        //Resultset -> Ejecuya una query de SELECCIÓN ->SELECT
        String query = String.format("DELETE FROM %s WHERE %s=?",
                "coches","modelo");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,modelo);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("La petición es incorrecta");
            System.out.println(e.getMessage());
        }
    }
}
