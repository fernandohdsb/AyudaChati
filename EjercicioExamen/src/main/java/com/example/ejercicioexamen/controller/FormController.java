package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.dao.UsuarioDAO;
import com.example.ejercicioexamen.dao.UsuarioDAOImp;
import com.example.ejercicioexamen.model.Usuario;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnRegistrar;

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarioDAO = new UsuarioDAOImp();

        btnRegistrar.setOnAction(event -> handleRegistro());
    }



    private void handleRegistro() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String pass = txtPassword.getText();

        if (Objects.equals(nombre, "") || Objects.equals(correo, "") || Objects.equals(pass, "")) {
            mostrarAlerta(Alert.AlertType.ERROR, "Datos incompletos", "Por favor, completa todos los campos.");
            return;
        }

        try {

            Usuario nuevoUsuario = new Usuario( nombre, correo, pass);

            usuarioDAO.addUsuario(nuevoUsuario);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Registro Exitoso", "¡Usuario registrado con éxito! Ya puedes iniciar sesión.");

            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            String mensaje = "Error al registrar el usuario.";
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Base de Datos", mensaje);
            e.printStackTrace();
        }
    }


    private void mostrarAlerta(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}