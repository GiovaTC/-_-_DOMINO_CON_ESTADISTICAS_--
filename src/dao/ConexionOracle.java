package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionOracle {

    public static Connection getConexion() throws Exception {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/orcl",
                "system",
                "Tapiero123"
        );
    }
}   
