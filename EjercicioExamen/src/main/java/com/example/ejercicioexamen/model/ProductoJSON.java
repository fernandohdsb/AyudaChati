package com.example.ejercicioexamen.model;

import com.example.ejercicioexamen.database.DBconnection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoJSON {

    private String nombre;
    private double precio;

    // Puedes definir las variables de conexión aquí o usar un patrón Singleton/DAO
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    // Asegúrate de tener una clase DBConnection con getConnection()
    // public static Connection getConnection() { ... }

    public void insertarProducto() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            List<ProductoJSON> listaDesdeJson = objectMapper.readValue(
                    new File("productos.json"),
                    new TypeReference<List<ProductoJSON>>(){}
            );


            connection = DBconnection.getConnection();
            String query = "INSERT INTO productos (nombre, precio) VALUES (?,?)";

            if (listaDesdeJson != null) {
                for (ProductoJSON producto : listaDesdeJson) {
                    try {
                        preparedStatement = connection.prepareStatement(query);

                        // Solo mapeamos nombre y precio (posiciones 1 y 2)
                        preparedStatement.setString(1, producto.getNombre());
                        preparedStatement.setDouble(2, producto.getPrecio());

                        preparedStatement.execute();
                    } catch (SQLException e) {
                        System.out.println("Error al insertar fila (Producto: " + producto.getNombre() + "): " + e.getMessage());
                    }
                }
                System.out.println("Productos cargados desde JSON correctamente (Nombre y Precio).");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

}