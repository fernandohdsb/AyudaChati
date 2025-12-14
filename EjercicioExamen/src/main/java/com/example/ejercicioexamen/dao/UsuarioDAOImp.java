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

}
