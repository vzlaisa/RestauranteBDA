/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_clientes;

import DTOs.ClienteDTO;
import conexion.Conexion;
import entidades.Cliente;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author dario
 */
public class ClientesDAO implements IClientesDAO{
    private static ClientesDAO instancia;
    
    private ClientesDAO() {}
    
    public static ClientesDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClientesDAO();
        }
        return instancia;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar cliente: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Cliente> buscarClientes(String criterio) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery(
                "SELECT c FROM Cliente c WHERE " +
                "LOWER(c.nombre) LIKE LOWER(:criterio) OR " +
                "LOWER(c.apellidoPaterno) LIKE LOWER(:criterio) OR " +
                "LOWER(c.apellidoMaterno) LIKE LOWER(:criterio) OR " +
                "c.telefono LIKE :criterio OR " +
                "LOWER(c.correo) LIKE LOWER(:criterio)", Cliente.class);
            
            query.setParameter("criterio", "%" + criterio + "%");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar clientes: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Cliente obtenerClientePorTelefono(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery(
                "SELECT c FROM Cliente c WHERE c.telefono = :telefono", Cliente.class)
                .setParameter("telefono", telefono)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean existeClienteConTelefono(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(c) FROM Cliente c WHERE c.telefono = :telefono", Long.class)
                .setParameter("telefono", telefono)
                .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al verificar teléfono: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}