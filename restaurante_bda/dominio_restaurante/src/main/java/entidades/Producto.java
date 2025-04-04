/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(
        name = "Producto.getNombres",
        query = "SELECT p.nombre FROM Producto p"
    )
})
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, unique = true) 
    private String nombre;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "tipo", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoProducto tipo;
    
    // Usar remove ya que es una relación fuerte (composición)
    // Usar merge para actualizar lista de ingredientes cuando se actualice el producto
    // orphanRemoval como true para eliminar los ProductosIngredientes si se elimina al modificar el producto
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProductosIngredientes> productosIngredientes;
    
    // FALTA AGREGAR LA RELACIÓN CON LAS COMANDAS

    public Producto() {
        this.productosIngredientes = new ArrayList<>();
    }

    public Producto(String nombre, Double precio, TipoProducto tipo, List<ProductosIngredientes> productosIngredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.productosIngredientes = productosIngredientes;
    }

    public Producto(String nombre, Double precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.productosIngredientes = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ProductosIngredientes> getProductosIngredientes() {
        return productosIngredientes;
    }

    public void setProductosIngredientes(List<ProductosIngredientes> productosIngredientes) {
        this.productosIngredientes = productosIngredientes;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", productosIngredientes=" + productosIngredientes + '}';
    }
      
}
