/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author rocha
 */
public class ProductoIngredienteConIdDTO {
    private Long id;
    private Integer cantidad;
    private ProductoEditarDTO producto;
    private IngredienteDTO ingrediente;

    public ProductoIngredienteConIdDTO() {
    }

    public ProductoIngredienteConIdDTO(Long id, Integer cantidad, ProductoEditarDTO producto, IngredienteDTO ingrediente) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoEditarDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoEditarDTO producto) {
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
        return "ProductoIngredienteConIdDTO{" + "id=" + id + ", cantidad=" + cantidad + ", ingrediente=" + ingrediente + '}';
    }
}
