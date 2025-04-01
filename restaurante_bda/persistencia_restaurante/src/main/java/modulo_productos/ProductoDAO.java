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

/**
 *
 * @author rocha
 */
public class ProductoDAO implements IProductoDAO {

    private static ProductoDAO instanceProductoDAO;

    private ProductoDAO() {

    }

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
