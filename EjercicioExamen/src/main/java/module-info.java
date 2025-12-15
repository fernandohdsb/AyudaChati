module com.example.ejercicioexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires lombok;
    requires java.sql;
    requires java.desktop;
    requires com.fasterxml.jackson.annotation;

    opens  com.example.ejercicioexamen.model to lombok;
    exports com.example.ejercicioexamen.model;
    opens com.example.ejercicioexamen.dao to java.sql;
    exports com.example.ejercicioexamen.dao;
    opens com.example.ejercicioexamen to javafx.fxml;
    exports com.example.ejercicioexamen;
    exports com.example.ejercicioexamen.controller;
    opens com.example.ejercicioexamen.controller to javafx.fxml;
}