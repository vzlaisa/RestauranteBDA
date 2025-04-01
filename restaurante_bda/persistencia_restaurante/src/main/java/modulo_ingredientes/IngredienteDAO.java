/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_ingredientes;

import conexion.Conexion;
import entidades.Ingrediente;
import exception.PersistenciaException;
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

    @Override
    public Ingrediente registrarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();
            return ingrediente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
