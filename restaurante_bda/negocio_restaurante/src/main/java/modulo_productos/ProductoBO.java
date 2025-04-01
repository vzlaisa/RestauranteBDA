/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import entidades.Producto;
import enums.TipoProducto;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.Arrays;
import java.util.List;
import utilerias.Utilerias;

/**
 *
 * @author rocha
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;

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
        if (Utilerias.isNullOrEmpty(productoNuevo.getNombre())) {
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
            throw new NegocioException("El producto debe tener al menos 1 ingrediente.");
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
        if (Utilerias.isNullOrEmpty(nombre)) {
            throw new NegocioException("Es necesario el nombre del producto.");
        }

        try {
            List<String> nombresProductos = productoDAO.obtenerNombreProductos();

            return nombresProductos.stream()
                    .anyMatch(n -> n.equalsIgnoreCase(nombre));
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
}
