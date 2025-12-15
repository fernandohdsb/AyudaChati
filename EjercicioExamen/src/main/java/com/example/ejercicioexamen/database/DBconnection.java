package com.example.ejercicioexamen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public static Connection connection;


    public static Connection getConnection(){
        if (connection == null){
            createConnection();
        }
        return connection;
    }


    private static void createConnection(){

        String url = "jdbc:mysql://localhost:3306/tienda_ret?allowPublicKeyRetrieval=true&useSSL=false";


        String user = "root";


        String pass = "135792468Fh";

        try {

            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión a la BD 'tienda_ret' establecida con éxito.");

        } catch (SQLException e) {

            System.err.println("Error en la conexión con la BD");

            e.printStackTrace();
            connection = null;
        }
    }
}