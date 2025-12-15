package com.example.ejercicioexamen.dao;

import com.example.ejercicioexamen.database.DBconnection;
import com.example.ejercicioexamen.database.SchemaDB;
import com.example.ejercicioexamen.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAOImp implements UsuarioDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resulSet;


    @Override
    public void addUsuario(Usuario usuario) throws SQLException {
        connection = DBconnection.getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                SchemaDB.TAB_USERS, SchemaDB.COL_NAME, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Error al registrar el usuario: " + e.getMessage(), e);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }


    // EN UsuarioDAOImp.java

    @Override
    public Usuario comprobarUsuario(String correo, String password) throws SQLException {
        Usuario usuario = null;
        // 1. Obtener la conexión (si es nula, se recrea con la URL corregida)
        Connection connection = DBconnection.getConnection();

        // Si la conexión falló (connection == null), no podemos continuar
        if (connection == null) {
            System.err.println("Fallo al obtener la conexión en comprobarUsuario.");
            return null;
        }

        String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?",
                SchemaDB.TAB_USERS, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);

        PreparedStatement preparedStatement = null;
        ResultSet resulSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, correo.trim());
            preparedStatement.setString(2, password.trim());

            resulSet = preparedStatement.executeQuery();

            if (resulSet.next()) {
                int id = resulSet.getInt(SchemaDB.COL_ID);
                String nombre = resulSet.getString(SchemaDB.COL_NAME);
                String mail = resulSet.getString(SchemaDB.COL_CORREO);
                String pass = resulSet.getString(SchemaDB.COL_PASS);

                usuario = new Usuario(nombre, mail, pass);
            }

        } catch (SQLException e) {
            System.err.println("Error en la autenticación (comprobarUsuario): " + e.getMessage());
        } finally {

            if (resulSet != null) resulSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

        return usuario;
    }
}