/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_ingredientes;

import DTOs.IngredienteDTO;
import entidades.Ingrediente;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ximena
 */
public class IngredienteMapper {
    
    // Convertir entidad a DTO
    public static IngredienteDTO toDTO(Ingrediente ingrediente) {
        return new IngredienteDTO(
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida(),
                ingrediente.getCantidadStock()
        );
    }
    
    // Convertir DTO a entidad
    public static Ingrediente toEntity(IngredienteDTO ingredienteDTO) {
        return new Ingrediente(
                ingredienteDTO.getNombre(),
                ingredienteDTO.getUnidadMedida(),
                ingredienteDTO.getCantidadStock()
        );
    }
    
    // Convertir una lista Entity a lista DTO
    public static List<IngredienteDTO> toDTOList(List<Ingrediente> ingredientes) {
        return ingredientes.stream()
                .map(IngredienteMapper::toDTO)
                .collect(Collectors.toList());
    }
    
}
