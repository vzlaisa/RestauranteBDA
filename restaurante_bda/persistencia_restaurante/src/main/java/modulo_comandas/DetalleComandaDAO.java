/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_comandas;

import conexion.Conexion;
import enums.EstadoComanda;
import exception.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author rocha
 */
public class DetalleComandaDAO implements IDetalleComandaDAO {
    private static DetalleComandaDAO instanceDetalleComandaDAO;
    
    private DetalleComandaDAO() {
        
    }
    
    /**
     * Obtiene la instancia única de la DAO.
     * 
     * Si no existe una instancia previa, se crea una nueva.
     * 
     * @return Instancia única de ProductoDAO.
     */
    public static DetalleComandaDAO getInstance() {
        if (instanceDetalleComandaDAO == null) {
            instanceDetalleComandaDAO = new DetalleComandaDAO();
        }

        return instanceDetalleComandaDAO;
    }

    @Override
    public boolean existeProductoEnComandaAbierta(String nombreProducto) throws PersistenciaException {
        if (nombreProducto == null) {
            throw new PersistenciaException("El id del producto no puede ser nulo");
        }
        
        EntityManager em = Conexion.crearConexion();
        String sentenciaJPQL = "SELECT COUNT(dc) FROM DetalleComanda dc WHERE dc.producto.nombre = :nombreProducto AND dc.comanda.estado = :estado";
        
        try {
            TypedQuery<Long> query = em.createQuery(sentenciaJPQL, Long.class);
            query.setParameter("nombreProducto", nombreProducto);
            query.setParameter("estado", EstadoComanda.ABIERTA);

            Long cantidad = query.getSingleResult();
            
            return cantidad > 0;
        } catch (NoResultException e) {
            return false; 
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el id del producto: " + e.getMessage());
        } finally {
            em.close();
        }
        
    }
}
