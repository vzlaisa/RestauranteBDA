/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_comandas;

import exception.PersistenciaException;

/**
 *
 * @author rocha
 */
public interface IDetalleComandaDAO {
    
    public boolean existeProductoEnComandaAbierta(String nombreProducto) throws PersistenciaException;
}
