/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ximena
 */
@Entity
@Table(name = "clientes_frecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    public ClienteFrecuente() {
        super();
    }

    public ClienteFrecuente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email, Date fechaRegistro) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, email, "FRECUENTE", fechaRegistro);
    }
    
    public int getCantidadVisitas() {
        // Si existen comandas, regresar el tamaño de la lista de comandas, sino regresar 0
        return this.getComandas() != null ? this.getComandas().size() : 0;
    }
    
    public Double getGastoTotal() {
        Double total = 0.0;
        if (this.getComandas() != null) {
            for (Comanda comanda : this.getComandas()) {
                if (comanda.getDetallesComanda() != null) { // Obtiene de las comandas los detalles de la comanda
                    for (DetalleComanda detalle : comanda.getDetallesComanda()) {
                        Double importeTotal = detalle.getImporteTotal();
                        if (importeTotal != null) {
                            total = total + importeTotal;
                        }
                    }
                }
            }
        }
        return total;
    }
    
    public Integer getPuntosFidelidad() {
        Double gastoTotal = getGastoTotal();
        if (gastoTotal != null) {
            return (int) (gastoTotal / 20.0); // Convertir resultado a entero para manejar los puntos
        }
        return 0;
    }
}
