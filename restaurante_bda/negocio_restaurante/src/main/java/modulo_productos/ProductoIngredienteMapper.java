/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoIngredienteDTO;
import entidades.ProductoIngrediente;
import java.util.List;
import java.util.stream.Collectors;
import modulo_ingredientes.IngredienteMapper;

/**
 *
 * @author rocha
 */
public class ProductoIngredienteMapper {
    
    public static ProductoIngredienteDTO toDTO(ProductoIngrediente productosIngredientes) {
        
        return new ProductoIngredienteDTO(
                productosIngredientes.getCantidad(),
                ProductoMapper.toDTO(productosIngredientes.getProducto()),
                IngredienteMapper.toDTO(productosIngredientes.getIngrediente())
        );
    }
    
    public static ProductoIngrediente toEntity(ProductoIngredienteDTO productosIngredientesDTO) {
        return new ProductoIngrediente(
                productosIngredientesDTO.getCantidad(),
                ProductoMapper.toEntity(productosIngredientesDTO.getProducto()),
                IngredienteMapper.toEntity(productosIngredientesDTO.getIngrediente()));
    }

    // Mapeo de la lista de ProductosIngredientes
    public static List<ProductoIngrediente> toEntityList(List<ProductoIngredienteDTO> productosIngredientes) {
        return productosIngredientes.stream()
                .map(ProductoIngredienteMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<ProductoIngredienteDTO> toDTOList(List<ProductoIngrediente> productosIngredientes) {
        return productosIngredientes.stream()
                .map(ProductoIngredienteMapper::toDTO)
                .collect(Collectors.toList());
    }

}
