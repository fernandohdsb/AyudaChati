package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.HelloApplication;
import com.example.ejercicioexamen.dao.UsuarioDAO;
import com.example.ejercicioexamen.dao.UsuarioDAOImp;
import com.example.ejercicioexamen.model.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node; // Necesario para obtener la Stage del evento
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuarioDAO = new UsuarioDAOImp();

        botonRegistrarse.setOnAction(event -> {
            try {

                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));
                Parent root = loader.load();



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
        String correo = txtUsuario.getText();
        String pass = txtPassword.getText();

        if (Objects.equals(pass, "") || Objects.equals(correo, "")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No has completado todos los campos");
            alert.setTitle("Datos incompletos");
            alert.show();
        } else {
            System.out.println("Intentando iniciar sesión con: " + correo);

            try {
                Usuario usuarioLogueado = usuarioDAO.comprobarUsuario(correo, pass);

                if (usuarioLogueado != null) {

                    cargarVistaPrincipal(event, usuarioLogueado);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Credenciales incorrectas. Verifica tu correo y contraseña.");
                    alert.setTitle("Error de Autenticación");
                    alert.show();
                }

            } catch (SQLException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error de conexión con la base de datos: " + e.getMessage());
                alert.setTitle("Error de Sistema");
                alert.show();
                e.printStackTrace();
            } catch (IOException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error al cargar la vista principal.");
                alert.setTitle("Error de Interfaz");
                e.printStackTrace();
            }
        }
    }


    private void cargarVistaPrincipal(ActionEvent event, Usuario usuarioLogueado) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();

        MainController mainController = fxmlLoader.getController();
        mainController.setUsuarioLogueado(usuarioLogueado);

        stage.setTitle("Vista Principal de Compras");
        stage.setScene(new Scene(root));
        stage.show();
    }
}