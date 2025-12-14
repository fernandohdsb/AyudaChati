package com.example.ejercicioexamen.dao;

import com.example.ejercicioexamen.database.DBconnection;
import com.example.ejercicioexamen.database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDAOImp implements PurchaseDAO{
    private Connection connection;
    private PreparedStatement preparedStatement;
    @Override
    public void addPurchase(int idUser, int idProduct) throws SQLException {
        connection = DBconnection.getConnection();

        String query = String.format("INSERT INTO %s (%s, %s) VALUES (?,?)",
                SchemaDB.TAB_PURCHAGE,
                SchemaDB.COL_ID_PRODUCT,
                SchemaDB.COL_ID_USER);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setInt(2, idUser);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new SQLException("Error al agregar la compra: " + e.getMessage(), e);
        }
    }


    @Override
    public void borrarTodoPurchases() throws SQLException {
        connection = DBconnection.getConnection();

        String query = String.format("DELETE FROM %s", SchemaDB.TAB_PURCHAGE);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Error al borrar todos los registros de Purchases: " + e.getMessage(), e);
        }
    }
}
