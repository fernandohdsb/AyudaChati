package com.example.ejercicioexamen.dao;

import com.example.ejercicioexamen.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsuarioDAO {
    void addUsuario(Usuario usuario) throws SQLException;

}
