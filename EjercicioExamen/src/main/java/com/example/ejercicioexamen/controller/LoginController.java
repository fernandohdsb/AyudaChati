package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button botonIniciarSesion;
    @FXML
    public Button botonRegistrarse;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        botonRegistrarse.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));
                Parent root = loader.load();

                // FormController formController = loader.getController();

                Stage ventanaRegistro = new Stage();
                ventanaRegistro.initModality(Modality.APPLICATION_MODAL);
                ventanaRegistro.setTitle("Registro de Usuario");
                ventanaRegistro.setScene(new Scene(root));
                ventanaRegistro.showAndWait();

            } catch (IOException e) {
                System.err.println("Error al cargar la ventana de registro: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void onLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String pass = txtPassword.getText();

        if (Objects.equals(pass, "") || Objects.equals(usuario, "")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No has completado todos los campos");
            alert.setTitle("Datos incompletos");
            alert.show();
        } else {
            System.out.println("Intentando iniciar sesión con: " + usuario);
            // Aquí iría tu lógica para comprobar el usuario en la base de datos
        }
    }
}