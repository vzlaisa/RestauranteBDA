/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.UnidadMedida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Ingrediente en la base de datos.
 * 
 * @author Ximena
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "unidad_medida", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UnidadMedida unidadMedida;
    
    @Column(name = "cantidad_stock", nullable = false)
    private Integer cantidadStock;
    
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
    private List<ProductosIngredientes> productosIngredientes;

    public Ingrediente() {
        this.productosIngredientes = new ArrayList<>();
    }

    public Ingrediente(String nombre, UnidadMedida unidadMedida, Integer cantidadStock, List<ProductosIngredientes> productosIngredientes) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
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

    public List<ProductosIngredientes> getProductosIngredientes() {
        return productosIngredientes;
    }

    public void setProductosIngredientes(List<ProductosIngredientes> productosIngredientes) {
        this.productosIngredientes = productosIngredientes;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", cantidadStock=" + cantidadStock + ", productosIngredientes=" + productosIngredientes + '}';
    }
      
}