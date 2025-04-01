/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_productos;

/**
 *
 * @author rocha
 */
public class ProductoBO implements IProductoBO {
    private IProductoDAO productoDAO;
    
    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
}
