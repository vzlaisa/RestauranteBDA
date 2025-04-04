/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia_restaurante;

import entidades.Ingrediente;
import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.TipoProducto;
import enums.UnidadMedida;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import modulo_ingredientes.IIngredienteDAO;
import modulo_ingredientes.IngredienteDAO;
import modulo_productos.IProductoDAO;
import modulo_productos.ProductoDAO;

/**
 *
 * @author rocha
 */
public class Persistencia_restaurante {
    private static IProductoDAO productoDAO = ProductoDAO.getInstance();
    private static IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstancia();
    
    public static void main(String[] args) throws PersistenciaException {
        registrarProducto();
        obtenerNombresProductos();
//        
//        try {
//            Ingrediente ingrediente = new Ingrediente("Pan", UnidadMedida.PIEZAS, 20, null);
//            ingredienteDAO.registrarIngrediente(ingrediente);
//            System.out.println("Ingrediente registrado");
//        } catch (PersistenciaException e) {
//            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
//        }
    }
    
    private static void registrarProducto() throws PersistenciaException {
        try {
            Ingrediente ingrediente = new Ingrediente("Pan", UnidadMedida.PIEZAS, 20); // Ingrediente deberia de tener la lista en su constructor?
            ingredienteDAO.registrarIngrediente(ingrediente);
            
            Producto producto = new Producto("Sandwich 2", 30.0, TipoProducto.PLATILLO);
            ProductoIngrediente productoIngrediente = new ProductoIngrediente(2, producto, ingrediente);
            producto.getProductosIngredientes().add(productoIngrediente);
            ingrediente.getProductosIngredientes().add(productoIngrediente);
            
            Producto productoRegistrado = productoDAO.registrarProducto(producto);
            
            if (productoRegistrado != null) {
                 System.out.println("Producto registrado");
            }
           
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
        }
    }
    
    private static void obtenerNombresProductos() throws PersistenciaException {
        try {
            
            List<String> nombres = productoDAO.obtenerNombreProductos();
            
            nombres.forEach(nombre -> System.out.println(nombre));
           
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
        }
    }
}
