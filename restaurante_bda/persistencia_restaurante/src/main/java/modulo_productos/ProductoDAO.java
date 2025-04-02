/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

import conexion.Conexion;
import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Implementación del DAO para la entidad Producto.
 *
 * Se usa el patrón Singleton para evitar múltiples instancias y gestionar la
 * persistencia de productos en la base de datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha.
 */
public class ProductoDAO implements IProductoDAO {
    
    // Instancia única de la clase.
    private static ProductoDAO instanceProductoDAO;
    
    /**
     * Constructor privado para evitar instanciación directa,
     */
    private ProductoDAO() {

    }
    
    /**
     * Obtiene la instancia única de la DAO.
     * 
     * Si no existe una instancia previa, se crea una nueva.
     * 
     * @return Instancia única de ProductoDAO.
     */
    public static ProductoDAO getInstance() {
        if (instanceProductoDAO == null) {
            instanceProductoDAO = new ProductoDAO();
        }

        return instanceProductoDAO;
    }

    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param producto Objeto producto a registrar.
     * @return Objeto producto con id si se registró.
     * @throws PersistenciaException Si hubo un error al intentar registrar el
     * producto.
     */
    @Override
    public Producto registrarProducto(Producto producto) throws PersistenciaException {
        if (producto == null) {
            throw new PersistenciaException("El producto no puede ser nulo");
        }

        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();

            if (producto.getId() == null) {
                throw new PersistenciaException("No se generó un id para el producto.");
            }

            return producto;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un producto de la base de datos con el identificador
     * especificado.
     *
     * @param id Identificador del producto a eliminar.
     * @return True si la eliminación fue exitosa.
     * @throws PersistenciaException Si el id es nulo o si ocurre un error
     * durante la operación.
     */
    @Override
    public boolean eliminarProducto(Long id) throws PersistenciaException {
        if (id == null) {
            throw new PersistenciaException("El identificador no puede ser nulo");
        }

        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            Producto producto = em.find(Producto.class, id);
            
            if (producto == null) {
                throw new PersistenciaException("No se encontró el producto con ID: " + id);
            }
            
            em.remove(producto);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * Actualiza un producto en la base de datos.
     *
     * @param producto Producto con los nuevos datos.
     * @return El producto actualizado.
     * @throws PersistenciaException Si el producto es nulo o si ocurre un error
     * durante la actualización.
     */
    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        if (producto == null) {
            throw new PersistenciaException("El producto no puede ser nulo");
        }
        
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            Producto productoActualizado = em.merge(producto);
            em.getTransaction().commit();

            return productoActualizado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo editar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene un producto de la base de datos por su identificador.
     *
     * @param id Identificador único del producto.
     * @return El producto correspondiente al identificador proporcionado.
     * @throws PersistenciaException Si el identificador es nulo o si ocurre un
     * error durante la búsqueda.
     */
    @Override
    public Producto obtenerProductoPorId(Long id) throws PersistenciaException {
        if (id == null) {
            throw new PersistenciaException("El identificador no puede ser nulo");
        }

        EntityManager em = Conexion.crearConexion();

        try {
            return em.find(Producto.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el identificador de un producto a partir de su nombre.
     *
     * @param nombre Nombre del producto cuyo id se desea obtener.
     * @return El id del producto si se encuentra en la base de datos, o null si
     * no existe.
     * @throws PersistenciaException Si el nombre es nulo o si ocurre un error
     * durante la consulta.
     */
    @Override
    public Long obtenerIdPorNombre(String nombre) throws PersistenciaException {
        if (nombre == null) {
            throw new PersistenciaException("El nombre no puede ser nulo");
        }

        EntityManager em = Conexion.crearConexion();
        String sentenciaJPQL = "SELECT p.id FROM Producto p WHERE p.nombre = :nombre";

        try {
            TypedQuery<Long> query = em.createQuery(sentenciaJPQL, Long.class);
            query.setParameter("nombre", nombre);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no encuentra el id del producto, retorna null
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el id del producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene los nombres de todos los productos registrados.
     *
     * @return Lista con los nombres obtenidos.
     * @throws PersistenciaException Si hubo un error al intentar consultar los
     * nombres.
     */
    @Override
    public List<String> obtenerNombreProductos() throws PersistenciaException {
        List<String> nombresProductos;

        EntityManager em = Conexion.crearConexion();

        try {
            nombresProductos = em.createNamedQuery("Producto.getNombres", String.class).getResultList();

            return nombresProductos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo obtener los nombres de los productos: " + e.getMessage());
        }
    }
}
