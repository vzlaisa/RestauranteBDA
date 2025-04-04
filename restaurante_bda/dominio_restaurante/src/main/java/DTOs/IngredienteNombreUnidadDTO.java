/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.UnidadMedida;

/**
 *
 * @author rocha
 */
public class IngredienteNombreUnidadDTO {
    String nombre;
    UnidadMedida unidad;

    public IngredienteNombreUnidadDTO() {
    }

    public IngredienteNombreUnidadDTO(String nombre, UnidadMedida unidad) {
        this.nombre = nombre;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "IngredienteNombreUnidadDTO{" + "nombre=" + nombre + ", unidad=" + unidad + '}';
    }
    
    
}
