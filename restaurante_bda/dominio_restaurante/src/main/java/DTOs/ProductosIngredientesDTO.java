/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author rocha
 */
public class ProductosIngredientesDTO {
    private Integer cantidad;
    private ProductoDTO producto;
    private IngredienteDTO ingrediente;

    public ProductosIngredientesDTO() {
    }

    public ProductosIngredientesDTO(Integer cantidad, ProductoDTO producto, IngredienteDTO ingrediente) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public IngredienteDTO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "ProductosIngredientesDTO{" + "cantidad=" + cantidad + ", ingrediente=" + ingrediente + '}';
    } 
}
