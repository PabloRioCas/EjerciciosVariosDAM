package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;



    public boolean registrarUsuario(Usuario usuario) throws SQLException {

        connection = new DBConnection().getConnection();

        preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUE (?,?,?,?,?)",
                SchemaDB.TAB_NAME,
                SchemaDB.COL_NAME,SchemaDB.COL_MAIL,SchemaDB.COL_PASS,SchemaDB.COL_PH,SchemaDB.COL_ID_PERFIL));
        preparedStatement.setString(1,usuario.getNombre());
        preparedStatement.setString(2,usuario.getCorreo());
        preparedStatement.setString(3,usuario.getPass());
        preparedStatement.setInt(4,usuario.getTelefono());
        preparedStatement.setInt(5,usuario.getId_perfiles());
        return preparedStatement.execute();
    }
}
