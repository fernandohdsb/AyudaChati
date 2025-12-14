package com.example.ejercicioexamen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public  static Connection connection;

    public static  Connection getConnection(){
        if (connection==null){

            createConnection();
        }

        return connection;
    }

    private static void  createConnection(){
        //url
        String url = "jbc:mysql://localhost:3306/tienda_ret";
        //user
        String user = "root";
        //pass
        String pass = "root";

        try {
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la BD");
        }
    }
}
