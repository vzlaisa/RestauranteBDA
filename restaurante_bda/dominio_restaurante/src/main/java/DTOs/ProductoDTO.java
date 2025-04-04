/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO que representa un producto.
 *
 * Esta clase contiene todos los datos para un producto. Se utiliza para
 * transferir los datos de un producto entre la capa de negocio y la capa de
 * presentación o de acceso a datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha
 */
public class ProductoDTO {

    private String nombre;
    private Double precio;
    private TipoProducto tipo;
    private List<ProductosIngredientesDTO> ingredientes;
    
    /**
     * Constructor por defecto. Inicializa la lista de ProductosIngredientes.
     */
    public ProductoDTO() {
        this.ingredientes = new ArrayList<>();
    }
    
    public ProductoDTO(String nombre, Double precio, TipoProducto tipo, List<ProductosIngredientesDTO> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
    }

    public ProductoDTO(String nombre, Double precio, TipoProducto tipo) {
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

    public List<ProductosIngredientesDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductosIngredientesDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "ProductoNuevoDTO{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientes=" + ingredientes + '}';
    }
}
