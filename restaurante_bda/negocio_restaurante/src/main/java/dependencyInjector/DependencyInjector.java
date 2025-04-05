/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dependencyInjector;

import modulo_clientes.ClienteBO;
import modulo_clientes.ClientesDAO;
import modulo_clientes.IClienteBO;
import modulo_clientes.IClientesDAO;
import modulo_comandas.DetalleComandaBO;
import modulo_comandas.DetalleComandaDAO;
import modulo_comandas.IDetalleComandaBO;
import modulo_comandas.IDetalleComandaDAO;
import modulo_ingredientes.IIngredienteBO;
import modulo_ingredientes.IIngredienteDAO;
import modulo_ingredientes.IngredienteBO;
import modulo_ingredientes.IngredienteDAO;
import modulo_productos.IProductoBO;
import modulo_productos.IProductoDAO;
import modulo_productos.ProductoBO;
import modulo_productos.ProductoDAO;

/**
 *
 * @author rocha
 */
public class DependencyInjector {
    
    /**
     * Crea y devuelve una instancia de la capa de negocio (BO) para productos.
     * Este método es útil para obtener una instancia lista para realizar operaciones como registrar, actualizar, eliminar o consultar productos.
     * Sigue el principio de inversión de dependencias.
     *
     * @return Instancia de IProductoBO con su DAO asociado.
     */
    public static IProductoBO crearProductoBO() {
        // Crear instancia del DAO  utilizar. Se obtiene la instancia única
        IProductoDAO productoDAO = ProductoDAO.getInstance();
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstancia();
        
        // Crear la instancia del BO, se inyecta el DAO como dependencia
        IProductoBO productoBO = new ProductoBO(productoDAO, ingredienteDAO);
        
        // Regresar la instancia del BO
        return productoBO;
    }
    
    /**
     * Crea y devuelve una instancia de la capa de negocio (BO) para ingredientes.
     * Obtiene una instancia lista para realizar operaciones como registrar, actualizar, eliminar o consultar ingredientes.
     * 
     * @return Instancia de IIngredienteBO con su DAO asociado.
     */
    public static IIngredienteBO crearIngredienteBO() {
        // Obtener instancia del DAO.
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstancia();
        // Inyectar el DAO como dependencia al BO
        IIngredienteBO ingredienteBO = new IngredienteBO(ingredienteDAO);
        // Regresar instancia del BO
        return ingredienteBO;
    }
    
    public static IClienteBO crearClienteBO() {
        IClientesDAO clientesDAO = ClientesDAO.getInstancia();
        return new ClienteBO(clientesDAO);
    }
    
    public static IDetalleComandaBO crearDetalleComandaBO() {
        IDetalleComandaDAO detalleComandaDAO = DetalleComandaDAO.getInstance();
        
        IDetalleComandaBO detalleComandaBO = new DetalleComandaBO(detalleComandaDAO);
        
        return detalleComandaBO;
    }
}
