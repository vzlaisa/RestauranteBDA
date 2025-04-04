/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_clientes;

import DTOs.ClienteDTO;
import entidades.Cliente;

/**
 *
 * @author dario
 */
public class ClienteMapper {
    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setApellidoPaterno(dto.getApellidoPaterno());
        cliente.setApellidoMaterno(dto.getApellidoMaterno());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getCorreo());
        cliente.setTipo(dto.getTipo());
        return cliente;
    }
    
    public ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setTelefono(entity.getTelefono());
        dto.setCorreo(entity.getEmail());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setTipo(entity.getTipo());
        return dto;
    }
}