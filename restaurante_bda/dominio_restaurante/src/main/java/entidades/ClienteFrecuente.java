/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoCliente;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "clientes_frecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    @Transient
    private Long totalGastado;

    @Transient
    private Integer cantidadVisitas;

    @Transient
    private Integer puntos;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, Date fechaRegistro, TipoCliente tipo, List<Comanda> comandas) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, tipo, comandas);
    }

    public ClienteFrecuente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email, Date fechaRegistro, TipoCliente tipo) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, email, fechaRegistro, tipo);
    }

    public Long getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Long totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(Integer cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "ClienteFrecuente{" + "totalGastado=" + totalGastado + ", cantidadVisitas=" + cantidadVisitas + ", puntos=" + puntos + '}';
    }
}
