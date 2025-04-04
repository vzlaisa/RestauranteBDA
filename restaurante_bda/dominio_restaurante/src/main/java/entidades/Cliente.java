/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;
    
    @Column(name ="apellido_materno", nullable = false)
    private String apellidoMaterno;
    
    @Column(name="telefono", nullable = false, unique = true)
    private String telefono;
    
    @Column(name="email", nullable = true)
    private String email;
    
    @Column (name="fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    @Column(length = 20)
    private String tipo;
    
    @OneToMany(mappedBy = "cliente")
    private List<Comanda> comandas;
    
    @OneToMany(mappedBy = "comanda", fetch = FetchType.LAZY)
    private List<DetalleComanda> detallesComandas;

    public Cliente() {
        this.fechaRegistro = new Date();
        this.comandas = new ArrayList<>();
        this.detallesComandas = new ArrayList<>();

    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, 
                  String telefono, String email, String tipo, Date fechaRegistro) {
        this();
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.comandas = new ArrayList<>();
        this.detallesComandas = new ArrayList<>();



        this.tipo = tipo;
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + 
               (apellidoMaterno != null && !apellidoMaterno.isEmpty() ? " " + apellidoMaterno : "");
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    public List<DetalleComanda> getDetallesComandas() {
        return detallesComandas;
    }

    public void setDetallesComandas(List<DetalleComanda> detallesComandas) {
        this.detallesComandas = detallesComandas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", email=" + email + ", fechaRegistro=" + fechaRegistro + ", comandas=" + comandas + ", detallesComandas=" + detallesComandas + '}';
    }

}