/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_clientes;

import DTOs.ClienteDTO;
import entidades.Cliente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author dario
 */
public interface IClientesDAO {
    Cliente registrarCliente(Cliente cliente) throws PersistenciaException;
    List<Cliente> buscarClientes(String criterio) throws PersistenciaException;
    Cliente obtenerClientePorTelefono(String telefono) throws PersistenciaException;
    boolean existeClienteConTelefono(String telefono) throws PersistenciaException;
}