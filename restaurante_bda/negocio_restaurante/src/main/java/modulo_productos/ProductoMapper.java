/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import entidades.Producto;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rocha
 */
public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getTipo()
        );
    }
    
    public static Producto toEntity(ProductoDTO productoDTO) {
        return new Producto(
                productoDTO.getNombre(),
                productoDTO.getPrecio(),
                productoDTO.getTipo());
    }
    
    public static List<ProductoDTO> toDTOList(List<Producto> productos) {
        return productos.stream().
                map(ProductoMapper::toDTO).
                collect(Collectors.toList());
    }
}
