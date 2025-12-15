package com.example.ejercicioexamen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProductoJSON {
    // Once fields are added, AllArgsConstructor will require arguments
    // and will no longer conflict with NoArgsConstructor.
    private int id;
    private String nombre;
    private double precio;
}