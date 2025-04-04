/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoComanda;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "folio", nullable = false, unique = true, length = 15)
    private String folio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;
    
    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoComanda estado;
    
    @Column (name = "total_venta", nullable = false)
    private Double totalVenta;
    
    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private Cliente cliente;
    
    // Cascada Persist para guardar los detalles de la comanda al guardar la comanda.
    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<DetalleComanda> detallesComanda;

    public Comanda() {
        this.detallesComanda = new ArrayList<>();
    }

    public Comanda(Long id, String folio, Date fechaHora, EstadoComanda estado, Double totalVenta, Mesa mesa, Cliente cliente, List<DetalleComanda> detallesComanda) {
        this.id = id;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.totalVenta = totalVenta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detallesComanda = detallesComanda;
    }

    public Comanda(String folio, Date fechaHora, EstadoComanda estado, Double totalVenta, Mesa mesa, Cliente cliente, List<DetalleComanda> detallesComanda) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.totalVenta = totalVenta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detallesComanda = detallesComanda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<DetalleComanda> getDetallesComanda() {
        return detallesComanda;
    }

    public void setDetallesComanda(List<DetalleComanda> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", totalVenta=" + totalVenta + ", mesa=" + mesa + ", cliente=" + cliente + ", detallesComanda=" + detallesComanda + '}';
    }
}
