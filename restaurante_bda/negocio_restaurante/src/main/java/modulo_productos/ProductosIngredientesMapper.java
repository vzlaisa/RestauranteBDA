/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import DTOs.ProductosIngredientesDTO;
import entidades.ProductosIngredientes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modulo_ingredientes.IngredienteMapper;

/**
 *
 * @author rocha
 */
public class ProductosIngredientesMapper {
    
    public static ProductosIngredientesDTO toDTO(ProductosIngredientes productosIngredientes) {
        
        return new ProductosIngredientesDTO(
                productosIngredientes.getCantidad(),
                ProductoMapper.toDTO(productosIngredientes.getProducto()),
                IngredienteMapper.toDTO(productosIngredientes.getIngrediente())
        );
    }
    
    public static ProductosIngredientes toEntity(ProductosIngredientesDTO productosIngredientesDTO) {
        return new ProductosIngredientes(
                productosIngredientesDTO.getCantidad(),
                ProductoMapper.toEntity(productosIngredientesDTO.getProducto()),
                IngredienteMapper.toEntity(productosIngredientesDTO.getIngrediente()));
    }

    // Mapeo de la lista de ProductosIngredientes
    public static List<ProductosIngredientes> toEntityList(List<ProductosIngredientesDTO> productosIngredientes) {
        return productosIngredientes.stream()
                .map(ProductosIngredientesMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<ProductosIngredientesDTO> toDTOList(List<ProductosIngredientes> productosIngredientes) {
        return productosIngredientes.stream()
                .map(ProductosIngredientesMapper::toDTO)
                .collect(Collectors.toList());
    }

}
