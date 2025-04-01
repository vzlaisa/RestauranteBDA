/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dependencyInjector;

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
        
        // Crear la instancia del BO, se inyecta el DAO como dependencia
        IProductoBO productoBO = new ProductoBO(productoDAO);
        
        // Regresar la instancia del BO
        return productoBO;
    }
}
