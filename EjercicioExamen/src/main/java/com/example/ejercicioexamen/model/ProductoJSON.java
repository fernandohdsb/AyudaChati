package com.example.ejercicioexamen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoJSON {
    // Once fields are added, AllArgsConstructor will require arguments
    // and will no longer conflict with NoArgsConstructor.
    private int id;
    private String nombre;
    private double precio;
}