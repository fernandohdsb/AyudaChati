package com.example.ejercicioexamen.controller;

import com.example.ejercicioexamen.model.ProductoJSON;
import com.example.ejercicioexamen.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {

    @FXML
    public Button botonAñadir,botonVaciar,botonVer;
    private Usuario loggedUser;
    @FXML
    private ListView<Producto> listViewProductos;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        initGUI();
        acciones();

    }

    private void acciones() {
    }

    private void initGUI() {
    }

    private void instancias() {
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
    }
}
