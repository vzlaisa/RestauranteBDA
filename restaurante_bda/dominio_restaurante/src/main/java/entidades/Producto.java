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
 * @author 00000253301 Isabel Valenzuela Rocha
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(
            name = "Producto.getNombres",
            query = "SELECT p.nombre FROM Producto p"
    ),
    @NamedQuery(
            name = "Producto.getTodos",
            query = "SELECT p FROM Producto p"
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
    // orphanRemoval como true para eliminar los ProductosIngredientes si se elimina el producto
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProductoIngrediente> productosIngredientes;
    // cascada merge ??
    
    // orphanRemoval como false para no perder los detalles de la comanda si se elimina el producto
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<DetalleComanda> detallesComandas;

    public Producto() {
        this.productosIngredientes = new ArrayList<>();
        this.detallesComandas = new ArrayList<>();
    }

    public Producto(Long id, String nombre, Double precio, TipoProducto tipo, List<ProductoIngrediente> productosIngredientes, List<DetalleComanda> detallesComandas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.productosIngredientes = productosIngredientes;
        this.detallesComandas = detallesComandas;
    }

    public Producto(String nombre, Double precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.productosIngredientes = new ArrayList<>();
        this.detallesComandas = new ArrayList<>();
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

    public List<ProductoIngrediente> getProductosIngredientes() {
        return productosIngredientes;
    }

    public void setProductosIngredientes(List<ProductoIngrediente> productosIngredientes) {
        this.productosIngredientes = productosIngredientes;
    }

    public List<DetalleComanda> getDetallesComandas() {
        return detallesComandas;
    }

    public void setDetallesComandas(List<DetalleComanda> detallesComandas) {
        this.detallesComandas = detallesComandas;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", productosIngredientes=" + productosIngredientes + '}';
    }
}
