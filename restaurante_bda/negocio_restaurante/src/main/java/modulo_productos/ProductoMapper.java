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
                null
        );
        
        // EN QUE PUEDE AFECTAR QUE EN MI CONSTRUCTOR AGREGUE LA LISTA AQUI?
        // Ahorita no, pero si en un futuro se quisiera editar el producto, aquí se le crea una lista de ProductosIngredientes vacía.
        // Afectaria en algo? O la persistencia detecta que si tiene y solo lo actualiza, pero los ProductosIngredientes queda igusl?
    }
}
