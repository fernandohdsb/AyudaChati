package com.example.ejercicioexamen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    // Adding fields resolves the constructor conflict
    private String nombre;
    private String correo;
    private String password;
}