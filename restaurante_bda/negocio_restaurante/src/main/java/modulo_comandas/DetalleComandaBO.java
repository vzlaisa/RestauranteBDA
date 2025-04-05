/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_comandas;

import exception.NegocioException;
import exception.PersistenciaException;

/**
 *
 * @author rocha
 */
public class DetalleComandaBO implements IDetalleComandaBO {
    private IDetalleComandaDAO detalleComandaDAO;

    public DetalleComandaBO(IDetalleComandaDAO detalleComandaDAO) {
        this.detalleComandaDAO = detalleComandaDAO;
    }

    @Override
    public boolean verificarProductoEnComandaAbierta(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre no puede ser nulo.");
        }
        
        try {
            return detalleComandaDAO.existeProductoEnComandaAbierta(nombre);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo verificar si el producto está en comanda abierta." + e.getMessage(), e);
        }
    }
    
    
}
