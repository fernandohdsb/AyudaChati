package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.model.ProductoJSON;
import com.example.ejercicioexamen.model.Usuario;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {

    @FXML
    public Button botonAniadir,botonVaciar,botonVer;
    private Usuario loggedUser;
    @FXML
    private ListView<ProductoJSON> listViewProductos;
    private ObservableList<ProductoJSON> lista;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        initGUI();
        acciones();

    }

    private void acciones() {
        botonAñadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        botonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        botonVer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private void initGUI() {
    }

    private void instancias() {
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
    }
}
