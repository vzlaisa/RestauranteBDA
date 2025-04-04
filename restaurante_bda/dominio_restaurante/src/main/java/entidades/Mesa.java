/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Mesa en la base de datos.
 * 
 * @author Ximena
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero", nullable = false, length = 10, unique = true)
    private String numero;
    
    @OneToMany(mappedBy = "mesa", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Comanda> comandas;

    public Mesa() {
        this.comandas = new ArrayList<>();
    }

    public Mesa(Long id, String numero, List<Comanda> comandas) {
        this.id = id;
        this.numero = numero;
        this.comandas = comandas;
    }
    
    public Mesa(String numero) {
        this.numero = numero;
        this.comandas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", numero=" + numero + '}';
    }

}