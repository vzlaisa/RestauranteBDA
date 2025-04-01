/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_productos;

import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author rocha
 */
public interface IProductoDAO {
    
    public Producto registrarProducto(Producto producto) throws PersistenciaException;
    
    public List<String> obtenerNombreProductos() throws PersistenciaException;
}
