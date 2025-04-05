/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_productos;

import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 * Interfaz de la capa de persistenca para la gestión de productos.
 *
 * Define los métodos que deben implementarse para gestionar la persistencia de
 * los productos en la base de datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha
 */
public interface IProductoDAO {
    
    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param producto Objeto producto a registrar.
     * @return Objeto producto con id si se registró.
     * @throws PersistenciaException Si hubo un error al intentar registrar el
     * producto.
     */
    public Producto registrarProducto(Producto producto) throws PersistenciaException;
    
    /**
     * Elimina un producto de la base de datos con el identificador
     * especificado.
     *
     * @param id Identificador del producto a eliminar.
     * @return True si la eliminación fue exitosa.
     * @throws PersistenciaException Si el id es nulo o si ocurre un error
     * durante la operación.
     */
    public boolean eliminarProducto(Long id) throws PersistenciaException;
    
    /**
     * Actualiza un producto en la base de datos.
     *
     * @param producto Producto con los nuevos datos.
     * @return El producto actualizado.
     * @throws PersistenciaException Si el producto es nulo o si ocurre un error
     * durante la actualización.
     */
    public Producto actualizarProducto(Producto producto) throws PersistenciaException;
    
    /**
     * Obtiene un producto de la base de datos por su identificador.
     *
     * @param id Identificador único del producto.
     * @return El producto correspondiente al identificador proporcionado.
     * @throws PersistenciaException Si el identificador es nulo o si ocurre un
     * error durante la búsqueda.
     */
    public Producto obtenerProductoPorId(Long id) throws PersistenciaException;
    
    /**
     * Obtiene el identificador de un producto a partir de su nombre.
     *
     * @param nombre Nombre del producto cuyo id se desea obtener.
     * @return El id del producto si se encuentra en la base de datos, o null si
     * no existe.
     * @throws PersistenciaException Si el nombre es nulo o si ocurre un error
     * durante la consulta.
     */
    public Long obtenerIdPorNombre(String nombre) throws PersistenciaException;
    
    public List<Producto> obtenerTodos() throws PersistenciaException;
    
    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException;
    
    /**
     * Obtiene los nombres de todos los productos registrados.
     *
     * @return Lista con los nombres obtenidos.
     * @throws PersistenciaException Si hubo un error al intentar consultar los
     * nombres.
     */
    public List<String> obtenerNombreProductos() throws PersistenciaException;
}
