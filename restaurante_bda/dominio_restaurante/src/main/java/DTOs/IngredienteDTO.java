/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.UnidadMedida;

/**
 * DTO de entrada para entidad Ingrediente.
 * @author Ximena
 */
public class IngredienteDTO {
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;

    public IngredienteDTO() {
    }

    public IngredienteDTO(String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    
    
}
