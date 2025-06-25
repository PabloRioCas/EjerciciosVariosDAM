package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Usuario;

import java.sql.*;

public class UsuarioDAO {
    //todas las acciones contra BD de cada clase, en este caso Usuario
    //CreateReadUpdateDelete
    private Connection connection;

    private PreparedStatement preparedStatement; //Para hacer inserciones y borrados de datos
    private ResultSet resultSet; //para poder hacer selecciones
    private Statement statement;

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUE (?,?,?,?,?)",
                SchemaDB.TAB_USER,
                SchemaDB.COL_NAME,SchemaDB.COL_MAIL,SchemaDB.COL_PASS,SchemaDB.COL_PH,SchemaDB.COL_ID_PER);
       // statement = connection.createStatement();
       //statement.execute(query); // devuelve booleano, true si ha habido fallos y false si no ha habido.
       // statement.executeUpdate(query); //devuelve un número, que es el Nº de elementos que se han visto
        //afectados por la query
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getPass());
        preparedStatement.setInt(4, usuario.getTelefono());
        preparedStatement.setInt(5, usuario.getIdPerfil());
        //connection.close(); // Este paso depende de lo que queramos hacer de si cerrar o no
        //la conexion una vez hayamos hecho el registro
       return preparedStatement.execute();
    }

    public boolean realizarLogin (String correo, String pass) throws SQLException {
        connection= new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?",
                SchemaDB.TAB_USER, SchemaDB.COL_MAIL, SchemaDB.COL_PASS);
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1, correo);
        preparedStatement.setString(2, pass);
        resultSet = preparedStatement.executeQuery();
        //si hay un resultado -> login ok -> true
        //si no hay un resultado -> login no ok -> false
        return resultSet.next();
    }
}
