/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import exception.NegocioException;
import java.util.List;

/**
 * Interfaz de la capa de negocio para la gestión de productos.
 *
 * Esta interfaz define los métodos necesarios para registrar, eliminar y
 * actualizar productos. Se encarga de establecer las validaciones necesarias y
 * de definir la comunicación con la capa de acceso a datos (DAO) para la
 * persistencia en la base de datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha
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

    /**
     * Elimina un producto de la base de datos utilizando su nombre.
     *
     * @param nombre Nombre del producto a eliminar.
     * @return true si el producto fue eliminado correctamente, false en caso
     * contrario.
     * @throws NegocioException Si el nombre es nulo o vacío, si el producto no
     * existe, o si ocurre un error durante la eliminación.
     */
    public boolean eliminarProducto(String nombre) throws NegocioException;

    /**
     * Actualiza un producto en la base de datos con los datos proporcionados en
     * el DTO.
     *
     * @param productoEditado El DTO con los nuevos datos del producto a
     * actualizar.
     * @return El DTO del producto actualizado.
     * @throws NegocioException Si hay un error en la validación o en el proceso
     * de actualización.
     */
    public ProductoDTO actualizarProducto(ProductoDTO productoEditado) throws NegocioException;
    
    public List<ProductoDTO> obtenerTodos() throws NegocioException;
    
    public ProductoDTO obtenerProductoPorNombre(String nombre) throws NegocioException;
    
    public boolean hayProductosRegistrados() throws NegocioException;
}
