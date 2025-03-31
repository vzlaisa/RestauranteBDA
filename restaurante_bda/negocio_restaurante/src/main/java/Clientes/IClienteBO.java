/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clientes;

import entidades.Cliente;

/**
 *
 * @author dario
 */
public interface IClienteBO {
    double calcularTotalGastado(Cliente cliente);
    int obtenerNumeroVisitas(Cliente cliente);
    int calcularPuntosFidelidad(Cliente cliente);
    
}
