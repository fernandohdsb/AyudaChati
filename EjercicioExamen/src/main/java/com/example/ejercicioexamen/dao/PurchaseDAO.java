package com.example.ejercicioexamen.dao;

import java.sql.SQLException;

public interface PurchaseDAO {
    void addPurchase(int idUser, int idProduct) throws SQLException;
    void borrarTodoPurchases() throws SQLException;
}
