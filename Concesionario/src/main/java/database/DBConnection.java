package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection; //Se marca como static para que pertenezca a la clase
    //por lo que si instancias varias, es siempre la misma

    //Se pueda crear la conexión --> esto solo se hace la primera vez

    //Pedir la conexión --> tantas como veces me pida -> te paso la que ya existe

    public Connection getConnection(){

        //la primera vez la creas
        if(connection == null){
            //Creas
            createConnection();
        }
        //La segunda vez, la devuelves sin crearla:
        return connection;
    }

    private void createConnection(){
        //1º protocolo de conexión jdbc:mysql
        //2º host 127.0.0.1
        // database que quiero conectar: concesionario_ue
    String url ="jdbc:mysql://127.0.0.1/concesionario_ue";
        try {
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Conexión creada con éxito");
        } catch (SQLException e) {
            System.out.println("Error en la conexión al servidor de BD");
        }

    }

}
