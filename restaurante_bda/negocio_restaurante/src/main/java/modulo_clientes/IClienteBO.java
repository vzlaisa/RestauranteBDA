/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_clientes;

import DTOs.ClienteDTO;
import entidades.Cliente;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author dario
 */
public interface IClienteBO {
    ClienteDTO registrarCliente(ClienteDTO clienteDTO) throws NegocioException;
    List<ClienteDTO> buscarClientes(String criterio) throws NegocioException;
    ClienteDTO obtenerClientePorTelefono(String telefono) throws NegocioException;
}