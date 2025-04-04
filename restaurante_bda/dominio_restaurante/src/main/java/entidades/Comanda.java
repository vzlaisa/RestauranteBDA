/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoComanda;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "comanda")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;
    
    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoComanda estado;
    
    @Column(name = "total_venta", nullable = false)
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
    
    
    private Cliente cliente;

    public Comanda() {
    }

    public Comanda(Date fechaHora, EstadoComanda estado, Mesa mesa, Cliente cliente) {
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    public Comanda(Long id, Date fechaHora, EstadoComanda estado, Mesa mesa, Cliente cliente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Override
    public String toString() {
        return "entidades.Comanda[ id=" + id + " ]";
    }
    
}
