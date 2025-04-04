/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rocha
 */
@Entity
@Table(name = "detalles_comandas")
public class DetalleComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "notas", nullable = true)
    private String notas;
    
    @ManyToOne
    @JoinColumn(name = "id_comanda", nullable = false)
    private Comanda comanda;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public DetalleComanda() {
    }

    public DetalleComanda(Long id, Double precio, Integer cantidad, String notas, Comanda comanda, Producto producto) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.notas = notas;
        this.comanda = comanda;
        this.producto = producto;
    }

    public DetalleComanda(Double precio, Integer cantidad, String notas, Comanda comanda, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.notas = notas;
        this.comanda = comanda;
        this.producto = producto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Double getImporteTotal() {
        return precio * cantidad;
    }

    @Override
    public String toString() {
        return "DetalleComanda{" + "id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", notas=" + notas + ", producto=" + producto + '}';
    }
}
