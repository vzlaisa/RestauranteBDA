/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import exception.NegocioException;

/**
 *
 * @author rocha
 */
public interface IProductoBO {
    
    /**
     * Registra un nuevo producto.
     *
     * Valida las especificaciones del producto que se quiere registrar e
     * intenta registrarlo mediante la DAO.
     *
     * @param productoNuevo Producto que se quiere registrar.
     * @return Producto si se registró, o mensaje de excepción en caso
     * contrario.
     * @throws NegocioException Si alguna especificación no es correcta o si
     * hubo un error al intentar registrar el producto.
     */
    public ProductoDTO registrarProducto(ProductoDTO productoNuevo) throws NegocioException;
}
