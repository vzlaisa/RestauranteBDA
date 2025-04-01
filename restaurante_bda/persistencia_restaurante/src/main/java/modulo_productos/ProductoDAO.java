/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

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
    
}
