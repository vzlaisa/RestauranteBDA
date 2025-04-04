/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_clientes;

import DTOs.ClienteDTO;
import entidades.Cliente;
import entidades.Comanda;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dario
 */
public class ClienteBO implements IClienteBO {
    private final IClientesDAO clientesDAO;

    public ClienteBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) throws NegocioException {
        try {           
            if (clientesDAO.existeClienteConTelefono(clienteDTO.getTelefono())) {
                throw new NegocioException("Ya existe un cliente con este número de teléfono");
            }
            
            Cliente cliente = new Cliente(
                clienteDTO.getNombre(),
                clienteDTO.getApellidoPaterno(),
                clienteDTO.getApellidoMaterno(),
                clienteDTO.getTelefono(),
                clienteDTO.getEmail(),
                clienteDTO.getTipo(),
                clienteDTO.getFechaRegistro()
            );
            
            cliente = clientesDAO.registrarCliente(cliente);
            return convertirADTO(cliente);
        } catch (NegocioException e) {
            // Convertir PresentacionException (de Validaciones) a NegocioException
            throw new NegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar cliente: " + e.getMessage());
        }
    }

       @Override
    public List<ClienteDTO> buscarClientes(String criterio) throws NegocioException {
        try {
            List<Cliente> clientes = clientesDAO.buscarClientes(criterio);
            return clientes.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar clientes: " + e.getMessage());
        }
    }

    @Override
    public ClienteDTO obtenerClientePorTelefono(String telefono) throws NegocioException {
        try {
            Cliente cliente = clientesDAO.obtenerClientePorTelefono(telefono);
            return cliente != null ? convertirADTO(cliente) : null;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener cliente: " + e.getMessage());
        }
    }

    private ClienteDTO convertirADTO(Cliente cliente) {
        return new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellidoPaterno(),
            cliente.getApellidoMaterno(),
            cliente.getTelefono(),
            cliente.getEmail(),
            cliente.getFechaRegistro(),
            cliente.getTipo()
        );
    }


}