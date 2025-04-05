/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocha
 */
public class ProductoEditarDTO {
    private String nombre;
    private Double precio;
    private TipoProducto tipo;
    private List<ProductoIngredienteConIdDTO> ingredientes;

    public ProductoEditarDTO() {
        this.ingredientes = new ArrayList<>();
    }

    public ProductoEditarDTO(String nombre, Double precio, TipoProducto tipo, List<ProductoIngredienteConIdDTO> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
    }

    public ProductoEditarDTO(String nombre, Double precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.ingredientes = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public List<ProductoIngredienteConIdDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductoIngredienteConIdDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "ProductoEditarDTO{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientes=" + ingredientes + '}';
    }
}
