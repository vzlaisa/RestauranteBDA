/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import DTOs.ProductoEditadoDTO;
import entidades.Producto;
import enums.TipoProducto;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.Arrays;
import java.util.List;
import utilerias.Utilerias;

/**
 * Clase de la capa de negocio para la gestión de productos.
 *
 * Esta clase implementa la interfaz IProductoBO y contiene la lógica de negocio
 * para el manejo de productos. Se encarga de validar los datos, registrar,
 * actualizar y eliminar productos, así como de comunicarse con la capa de
 * acceso a datos (DAO) para la persistencia en la base de datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;

    /**
     * Constructor de la clase. Inicializa la DAO al valor de su parámetro.
     * @param productoDAO DAO para la gestión de persistencia de productos.
     */
    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

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
    @Override
    public ProductoDTO registrarProducto(ProductoDTO productoNuevo) throws NegocioException {
        // Validar que el producto no sea nulo
        if (productoNuevo == null) {
            throw new NegocioException("El producto no puede ser nulo.");
        }

        // Validar que el nombre no sea nulo
        if (Utilerias.isNullOrBlank(productoNuevo.getNombre())) {
            throw new NegocioException("El nombre del producto es obligatorio.");
        }

        // Validar que el producto no sea repetido
        if (nombreProductoExiste(productoNuevo.getNombre())) {
            throw new NegocioException("Ya existe un producto con el nombre " + productoNuevo.getNombre() + ".");
        }

        // Validar que el precio no sea nulo
        if (productoNuevo.getPrecio() == null) {
            throw new NegocioException("El precio del producto es obligatorio.");
        }

        // Validar que el precio sea mayor que 0
        if (productoNuevo.getPrecio() <= 0) {
            throw new NegocioException("El precio del producto debe ser mayor a 0.");
        }

        // Validar que el tipo no sea nulo
        if (productoNuevo.getTipo() == null) {
            throw new NegocioException("El tipo de producto es obligatorio.");
        }

        // Obtener los enums de tipo de producto
        List<TipoProducto> tipos = Arrays.asList(TipoProducto.values());

        // Validar que el tipo sea alguno de los enum
        if (!tipos.contains(productoNuevo.getTipo())) {
            throw new NegocioException("El tipo de producto no es válido.");
        }

        // Validar que tenga al menos 1 ingrediente asociado
        if (productoNuevo.getIngredientes() == null || productoNuevo.getIngredientes().isEmpty()) {
            throw new NegocioException("El producto debe tener al menos 1 ingrediente.");
        }

        // Intentar registrar el producto
        try {
            // Registrar el producto mediante la DAO
            Producto productoRegistrado = productoDAO.registrarProducto(ProductoMapper.toEntity(productoNuevo));

            if (productoRegistrado == null || productoRegistrado.getId() == null) {
                throw new NegocioException("No se pudo registrar el producto.");
            }

            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("ENo se pudo registrar el producto.", e);
        }
    }

    /**
     * Elimina un producto de la base de datos utilizando su nombre.
     *
     * @param nombre Nombre del producto a eliminar.
     * @return true si el producto fue eliminado correctamente, false en caso
     * contrario.
     * @throws NegocioException Si el nombre es nulo o vacío, si el producto no
     * existe, o si ocurre un error durante la eliminación.
     */
    @Override
    public boolean eliminarProducto(String nombre) throws NegocioException {
        // Validar que el nombre no sea nulo
        if (Utilerias.isNullOrBlank(nombre)) {
            throw new NegocioException("El nombre del producto es obligatorio.");
        }

        // Intentar eliminar el producto
        try {
            // Obtiene el producto mediante la DAO
            Long idProducto = productoDAO.obtenerIdPorNombre(nombre);

            // Si el producto no existe
            if (idProducto == null) {
                throw new NegocioException("El producto con nombre " + nombre + " no existe.");
            }

            // Elimina el producto mediante la DAO
            return productoDAO.eliminarProducto(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo eliminar el producto.", e);
        }
    }

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
    @Override
    public ProductoDTO actualizarProducto(ProductoEditadoDTO productoEditado) throws NegocioException {
        // Validar que el producto no sea nulo
        if (productoEditado == null) {
            throw new NegocioException("El producto no puede ser nulo.");
        }

        // Validar que el nombre no sea nulo o vacío
        if (Utilerias.isNullOrBlank(productoEditado.getNombre())) {
            throw new NegocioException("El nombre del producto es necesario para actualizar.");
        }

        // Validar que el precio no sea nulo
        if (productoEditado.getPrecio() == null) {
            throw new NegocioException("El precio del producto es obligatorio.");
        }

        // Validar que el precio sea mayor que 0
        if (productoEditado.getPrecio() <= 0) {
            throw new NegocioException("El precio del producto debe ser mayor a 0.");
        }

        // Validar que tenga al menos 1 ingrediente asociado
        if (productoEditado.getIngredientes() == null || productoEditado.getIngredientes().isEmpty()) {
            throw new NegocioException("El producto debe tener al menos 1 ingrediente.");
        }

        // Intentar eliminar el producto
        try {
            // Obtiene el producto mediante la DAO
            Long idProducto = productoDAO.obtenerIdPorNombre(productoEditado.getNombre());

            // Si el producto no existe
            if (idProducto == null) {
                throw new NegocioException("El producto con nombre " + productoEditado.getNombre() + " no existe.");
            }

            // Obtener el producto que se quiere editar
            Producto producto = productoDAO.obtenerProductoPorId(idProducto);

            // Settear los datos editados
            producto.setPrecio(productoEditado.getPrecio());
            producto.setProductosIngredientes(ProductosIngredientesMapper.toEntityList(productoEditado.getIngredientes()));

            // Actualizar el producto mediante la DAO
            return ProductoMapper.toDTO(productoDAO.actualizarProducto(producto));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo eliminar el producto.", e);
        }
    }

    /**
     * Método auxiliar. Verifica si un producto con el nombre especificado ya
     * existe en la base de datos.
     *
     * @param nombre El nombre del producto a verificar.
     * @return true si el nombre del producto ya existe, false en caso
     * contrario.
     * @throws NegocioException Si el nombre es nulo o vacío, o si ocurre un
     * error al acceder a la persistencia.
     */
    private boolean nombreProductoExiste(String nombre) throws NegocioException {
        // Valida el nombre pasado como argumento
        if (Utilerias.isNullOrBlank(nombre)) {
            throw new NegocioException("Es necesario el nombre del producto.");
        }

        try {
            // Obtiene todos los nombres de los productos registrados
            List<String> nombresProductos = productoDAO.obtenerNombreProductos();
            
            // Recorre la lista y verifica si hay coincidencia con el nombre
            return nombresProductos.stream()
                    .anyMatch(n -> n.equalsIgnoreCase(nombre));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener los nombres de productos.");
        }
    }
}
