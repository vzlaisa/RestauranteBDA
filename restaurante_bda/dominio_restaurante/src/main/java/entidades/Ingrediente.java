/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Enum unidadMedida;
    
    @Column(name = "cantidad_stock", nullable = false)
    private Integer cantidadStock;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, Enum unidadMedida, Integer cantidadStock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
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

    public Enum getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Enum unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", cantidadStock=" + cantidadStock + '}';
    }

    
}
