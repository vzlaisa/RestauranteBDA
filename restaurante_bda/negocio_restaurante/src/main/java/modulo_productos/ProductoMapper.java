/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import entidades.Producto;

/**
 *
 * @author rocha
 */
public class ProductoMapper {
    
    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getTipo(),
                null //CAMBIAR A LISTA DE PRODUCTOS INGREDIENTE DTO
        );
    }
    
    public static Producto toEntity(ProductoDTO productoDTO) {
        return new Producto(
                productoDTO.getNombre(),
                productoDTO.getPrecio(),
                productoDTO.getTipo(),
                null // CAMBIAR A LISTA DE PRODUCTOS INGREDIENTE DTO
        );
    }
}
