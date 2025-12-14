package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.dao.UsuarioDAOImp;
import com.example.ejercicioexamen.model.Usuario;
import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class FormController implements Initializable {
    private UsuarioDAOImp usuarioDAOImp;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void agregarUsuario() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        Usuario usuario = new Usuario(nombre,correo,password);
        boolean fallo = false;
        do {

            try {
                usuarioDAOImp.addUsuario(usuario);
                fallo = false;

            }catch (SQLException e){
                TextInputDialog textInputDialog = new TextInputDialog();
                textInputDialog.setContentText("Introduce el nuevo correo");
                textInputDialog.setTitle("Clave duplicada");
                Optional<String> nuevoCorreo = textInputDialog.showAndWait();
                String correoIntroducido = nuevoCorreo.get();
                usuario.setCorreo(correoIntroducido);
                fallo = true;
            }
        }while (fallo);
    }
}

