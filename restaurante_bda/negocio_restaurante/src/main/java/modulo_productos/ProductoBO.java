/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import DTOs.ProductoDTO;
import DTOs.ProductoIngredienteDTO;
import entidades.Ingrediente;
import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.TipoProducto;
import enums.UnidadMedida;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modulo_ingredientes.IIngredienteDAO;

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
    private IIngredienteDAO ingredienteDAO;

    /**
     * Constructor de la clase. Inicializa la DAO al valor de su parámetro.
     * @param productoDAO DAO para la gestión de persistencia de productos.
     * @param ingredienteDAO
     */
    public ProductoBO(IProductoDAO productoDAO, IIngredienteDAO ingredienteDAO) {
        this.productoDAO = productoDAO;
        this.ingredienteDAO = ingredienteDAO;
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
        if (productoNuevo.getNombre() == null || productoNuevo.getNombre().isBlank()) {
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
            Producto producto = ProductoMapper.toEntity(productoNuevo);
            List<ProductoIngrediente> productosIngredientes = ProductoIngredienteMapper.toEntityList(productoNuevo.getIngredientes());

            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                // Obtener el Ingrediente del contexto de persistencia
                Ingrediente ingrediente = ingredienteDAO.obtenerIngredientePorId(
                        ingredienteDAO.obtenerIdPorNombreYUnidad(
                                productoIngrediente.getIngrediente().getNombre(),
                                UnidadMedida.valueOf(productoIngrediente.getIngrediente().getUnidadMedida().toString())
                        )
                );

                // Establecer las relaciones
                productoIngrediente.setProducto(producto);
                productoIngrediente.setIngrediente(ingrediente);
            }

            producto.setProductosIngredientes(productosIngredientes);
            
            // Registrar el producto mediante la DAO
            Producto productoRegistrado = productoDAO.registrarProducto(producto);

            if (productoRegistrado == null || productoRegistrado.getId() == null) {
                throw new NegocioException("No se pudo registrar el producto.");
            }

            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo registrar el producto." + e.getMessage(), e);
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
        if (nombre == null || nombre.isBlank()) {
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
    public ProductoDTO actualizarProducto(ProductoDTO productoEditado) throws NegocioException {
        // Validar que el producto no sea nulo
        if (productoEditado == null) {
            throw new NegocioException("El producto no puede ser nulo.");
        }

        // Validar que el nombre no sea nulo o vacío
        if (productoEditado.getNombre() == null || productoEditado.getNombre().isBlank()) {
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

        // Intentar actualizar el producto
        try {
            // Obtiene el producto mediante la DAO
            Producto producto = productoDAO.obtenerProductoPorNombre(productoEditado.getNombre());

            // Si el producto no existe
            if (producto == null) {
                throw new NegocioException("El producto con nombre " + productoEditado.getNombre() + " no existe.");
            }

            // Settear los datos editados (solo se puede precio o productos ingredientes
            producto.setPrecio(productoEditado.getPrecio());
            producto.setProductosIngredientes(ProductoIngredienteMapper.toEntityList(productoEditado.getIngredientes())); // settear la lista convertida
            
            // Obtener el ingrediente de la persistencia y setearselo a cada uno (al convertirse no se hace esto)
            for (ProductoIngrediente productoIngrediente : producto.getProductosIngredientes()) {
                // Obtener el ingrediente del contexto de persistencia
                Ingrediente ingrediente = ingredienteDAO.obtenerIngredientePorNombreYUnidad(productoIngrediente.getIngrediente().getNombre(), productoIngrediente.getIngrediente().getUnidadMedida());
                System.out.println(ingrediente);
                
                // Establecer las relaciones
                productoIngrediente.setProducto(producto);
                productoIngrediente.setIngrediente(ingrediente);
            }

            // Actualizar el producto mediante la DAO
            return ProductoMapper.toDTO(productoDAO.actualizarProducto(producto));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar el producto.", e);
        }
    }
    
    @Override
    public List<ProductoDTO> obtenerTodos() throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerTodos();
            
            List<ProductoDTO> productosDTO = new ArrayList<>();
            
            for (Producto producto : productos) {
                ProductoDTO productoDTO = ProductoMapper.toDTO(producto);
                List<ProductoIngredienteDTO> productosIngredientesDTO = ProductoIngredienteMapper.toDTOList(producto.getProductosIngredientes());
                productoDTO.setIngredientes(productosIngredientesDTO);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener todos los productos", e);
        }
    }
    
    @Override
    public ProductoDTO obtenerProductoPorNombre(String nombre) throws NegocioException {
        // Validar que el nombre no sea nulo
        if (nombre == null) {
            throw new NegocioException("El nombre no puede ser nulo.");
        }
        
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(nombre);
            
            if (producto == null) {
                throw new NegocioException("No se encontró producto con nombre " + nombre);
            }
            
            ProductoDTO productoDTO = ProductoMapper.toDTO(producto);
            
            productoDTO.setIngredientes(ProductoIngredienteMapper.toDTOList(producto.getProductosIngredientes()));
            
            return productoDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el producto " + nombre + ".", e);
        }
    }
    
    @Override
    public boolean hayProductosRegistrados() throws NegocioException {
        try {
            return !productoDAO.obtenerTodos().isEmpty();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo verificar si hay productos registrados.", e);
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
        if (nombre == null || nombre.isBlank()) {
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
