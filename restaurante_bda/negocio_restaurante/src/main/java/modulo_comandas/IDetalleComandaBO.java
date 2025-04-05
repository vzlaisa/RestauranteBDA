/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_comandas;

import exception.NegocioException;

/**
 *
 * @author rocha
 */
public interface IDetalleComandaBO {
    
    public boolean verificarProductoEnComandaAbierta(String nombre) throws NegocioException;
}
