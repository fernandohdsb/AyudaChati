package com.example.ejercicioexamen.dao;

import com.example.ejercicioexamen.database.DBconnection;
import com.example.ejercicioexamen.database.SchemaDB;
import com.example.ejercicioexamen.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImp implements UsuarioDAO {

    private ResultSet resulSet;

    @Override
    public void addUsuario(Usuario usuario) throws SQLException {
        Connection connection = DBconnection.getConnection();
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                SchemaDB.TAB_USERS,SchemaDB.COL_NAME, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,usuario.getNombre());
        preparedStatement.setString(2,usuario.getCorreo());
        preparedStatement.setString(3,usuario.getPassword());
        preparedStatement.executeUpdate();

    }



    @Override
    public Usuario comprobarUsuario(String correo, String password) throws SQLException {
        Usuario usuario = null;
        Connection connection = DBconnection.getConnection();


        String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?",
                SchemaDB.TAB_USERS, SchemaDB.COL_CORREO, SchemaDB.COL_PASS);

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, password);

            resulSet = preparedStatement.executeQuery();

            if (resulSet.next()) {
                int id = resulSet.getInt(SchemaDB.COL_ID);
                String nombre = resulSet.getString(SchemaDB.COL_NAME);
                String mail = resulSet.getString(SchemaDB.COL_CORREO);
                String pass = resulSet.getString(SchemaDB.COL_PASS);

                usuario = new Usuario(nombre, mail, pass);
            }

        } catch (SQLException e) {
            System.err.println("Error en el login: " + e.getMessage());
            throw e;
        } finally {
            // Cierre de recursos crucial
            if (resulSet != null) resulSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        return usuario;
    }

}
