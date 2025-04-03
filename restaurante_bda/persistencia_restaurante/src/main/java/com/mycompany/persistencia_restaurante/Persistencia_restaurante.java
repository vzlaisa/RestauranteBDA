/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia_restaurante;

import entidades.Ingrediente;
import entidades.Producto;
import entidades.ProductosIngredientes;
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
//        registrarIngrediente();
//        registrarProducto();
//        obtenerNombresProductos();

        actualizarIngrediente();
    }
    
    private static void registrarProducto() throws PersistenciaException {
        try {
            Ingrediente ingrediente = new Ingrediente("Pan", UnidadMedida.PIEZAS, 20); // Ingrediente deberia de tener la lista en su constructor?
            ingredienteDAO.registrarIngrediente(ingrediente);
            
            Producto producto = new Producto("Sandwich 2", 30.0, TipoProducto.PLATILLO);
            ProductosIngredientes productoIngrediente = new ProductosIngredientes(2, producto, ingrediente);
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
    
    private static void obtenerIngredientes() throws PersistenciaException {
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();
            for (Ingrediente i : ingredientes) {
                System.out.println("Nombre: " + i.getNombre() + " - Unidad: " + i.getUnidadMedida()
                        + " - Stock: " + i.getCantidadStock());
            }
            
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener ingredientes: " + e.getMessage());
        }
    }
    
    private static void ingredientesPorNombre() throws PersistenciaException {
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.ingredientesPorNombre("Lechuga");
            for (Ingrediente i : ingredientes) {
                System.out.println("Nombre: " + i.getNombre() + " - Unidad: " + i.getUnidadMedida()
                        + " - Stock: " + i.getCantidadStock());
            }
            
            if (ingredientes.isEmpty()) {
                System.out.println("No hay ingredientes.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener ingredientes: " + e.getMessage());
        }
    }
    
    private static void ingredientesPorUnidad() throws PersistenciaException {
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.ingredientesPorUnidadMedida(UnidadMedida.PIEZAS);
            for (Ingrediente i : ingredientes) {
                System.out.println("Nombre: " + i.getNombre() + " - Unidad: " + i.getUnidadMedida()
                        + " - Stock: " + i.getCantidadStock());
            }
            
            if (ingredientes.isEmpty()) {
                System.out.println("No hay ingredientes");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener ingredientes: " + e.getMessage());
        }
    }
    
    private static void ingredienteNombreYUnidad() throws PersistenciaException {
        try {
            Ingrediente ingrediente = ingredienteDAO.obtenerIngredientePorNombreYUnidad("Pan", UnidadMedida.PIEZAS);
            if (ingrediente != null) {
                System.out.println("Ingrediente encontrado.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener ingrediente: " + e.getMessage());
        }
    }
    
    private static void eliminarIngrediente() throws PersistenciaException {
        try {
            Long idIngrediente = 4L;
            boolean ingredienteEliminado = ingredienteDAO.eliminarIngrediente(idIngrediente);
            if (ingredienteEliminado) {
                System.out.println("Ingrediente eliminado.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al eliminar ingrediente: " + e.getMessage());
        }
    }
    
    private static void actualizarIngrediente() throws PersistenciaException {
        try {
            Long idIngrediente = 5L;
            boolean ingredienteActualizado = ingredienteDAO.actualizarStock(idIngrediente, 700);
            if (ingredienteActualizado) {
                System.out.println("Ingrediente actualizado.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al actualizar stock: " + e.getMessage());
        }
    }
}
