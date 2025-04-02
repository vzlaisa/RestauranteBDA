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
}
