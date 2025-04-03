/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_ingredientes;

import conexion.Conexion;
import entidades.Ingrediente;
import enums.UnidadMedida;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ximena
 */
public class IngredienteDAO implements IIngredienteDAO {
    private static IngredienteDAO instanceIngredienteDAO;
    
    private IngredienteDAO() {
    }
    
    public static IngredienteDAO getInstancia() {
        if (instanceIngredienteDAO == null) {
            instanceIngredienteDAO = new IngredienteDAO();
        }
        return instanceIngredienteDAO;
    }

    /**
     * Registra un nuevo ingrediente en la base de datos.
     * 
     * @param ingrediente Objeto ingrediente a registrar.
     * @return El objeto ingrediente creado.
     * @throws PersistenciaException En caso de que hubo un error al registrar el ingrediente.
     */
    @Override
    public Ingrediente registrarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        if (ingrediente  == null) {
            throw new PersistenciaException("El ingrediente no puede ser nulo");
        }
        
        EntityManager em = Conexion.crearConexion();
        
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();
            
            if (ingrediente.getId() == null) {
                throw new PersistenciaException("No se generó ID para el ingrediente.");
            }
            return ingrediente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * Valida si un ingrediente con el mismo nombre y unidad existe dentro
     * de la base de datos.
     * 
     * @param nombre Nombre del ingrediente.
     * @param unidad Unidad de medida del ingrediente.
     * @return True si se encontró coincidencia, false en caso contrario.
     * @throws PersistenciaException En caso de que hubo un error al validar.
     */
    @Override
    public boolean obtenerIngredientesNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        try {
            Long ingrediente = em.createQuery("SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidad", Long.class)
                    .setParameter("nombre", nombre)
                    .setParameter("unidad", unidad)
                    .getSingleResult();
            return ingrediente > 0; // Devuelve true si se encontró más de un ingrediente que coincidiera con la búsqueda
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar producto por nombre y unidad: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un ingrediente dentro de la base de datos.
     * 
     * @param id ID del ingrediente.
     * @return True si se eliminó el ingrediente, false en caso contrario.
     * @throws PersistenciaException En caso de que hubo un error al eliminar el ingrediente.
     */
    @Override
    public boolean eliminarIngrediente(Long id) throws PersistenciaException {
        if (id == null) {
            throw new PersistenciaException("El identificador no puede ser nulo");
        }
        
        EntityManager em = Conexion.crearConexion();
        try {
            Ingrediente ingrediente = em.find(Ingrediente.class, id);
            
            if (ingrediente == null) {
                throw new PersistenciaException("Ingrediente no encontrado.");
            }
            
            em.getTransaction().begin();
            em.remove(ingrediente);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el ingrediente: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de ingredientes: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ingrediente> ingredientesPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.nombre LIKE :nombre", Ingrediente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ingredientes con el nombre " + nombre + ": " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ingrediente> ingredientesPorUnidadMedida(UnidadMedida unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.unidadMedida LIKE :unidad", Ingrediente.class)
                    .setParameter("unidad", "%" + unidad + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ingredientes con la unidad de medida " + unidad + ": " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Ingrediente obtenerIngredientePorNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.nombre LIKE :nombre AND i.unidadMedida LIKE :unidad", Ingrediente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .setParameter("unidad", "%" + unidad + "%")
                    .getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ingrediente con nombre " + nombre
                    + " y unidad de medida " + unidad + ": " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Ingrediente obtenerIngredientePorId(Long id) throws PersistenciaException {
        if (id == null) {
            throw new PersistenciaException("El identificador no puede ser nulo.");
        }
        EntityManager em = Conexion.crearConexion();
        try {
            return em.find(Ingrediente.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ingrediente con ID " + id + ": " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Long obtenerIdPorNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT i.id FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidad", Long.class);
            query.setParameter("nombre", nombre);
            query.setParameter("unidadMedida", unidad);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ID: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public boolean actualizarStock(Long id, Integer nuevoStock) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Ingrediente i SET i.cantidadStock = :nuevoStock WHERE i.id = :id", Ingrediente.class);
            query.setParameter("id", id);
            query.setParameter("nuevoStock", nuevoStock);
            int filasActualizadas = query.executeUpdate();
            
            return filasActualizadas > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar stock: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
