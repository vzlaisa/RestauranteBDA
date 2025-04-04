/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negocio_restaurante;

import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoIngredienteDTO;
import dependencyInjector.DependencyInjector;
import enums.TipoProducto;
import enums.UnidadMedida;
import exception.NegocioException;
import java.util.List;
import javax.persistence.PersistenceException;
import modulo_ingredientes.IIngredienteBO;
import modulo_productos.IProductoBO;

/**
 *
 * @author rocha
 */
public class Negocio_restaurante {
    private static IProductoBO productoBO = DependencyInjector.crearProductoBO();
    private static IIngredienteBO ingredienteBO = DependencyInjector.crearIngredienteBO();
    
    public static void main(String[] args) throws NegocioException {
        // registrarProducto();
        // registrarIngrediente();
        obtenerIngredientes();
    }
    
    private static void registrarProducto() throws NegocioException {
        IngredienteDTO ingrediente = new IngredienteDTO("Pan", UnidadMedida.PIEZAS, 20);
        ProductoDTO producto = new ProductoDTO("Sandwich", 30.0, TipoProducto.PLATILLO);
        ProductoIngredienteDTO productoIngrediente = new ProductoIngredienteDTO(2, producto, ingrediente);
        producto.getIngredientes().add(productoIngrediente);
        
        try {
            ProductoDTO productoRegistrado = productoBO.registrarProducto(producto);
            System.out.println(productoRegistrado);
        } catch (NegocioException e) {
            throw new NegocioException("Error al registrar ingrediente: " + e.getMessage());
        } 
    }
    
    private static void registrarIngrediente() throws NegocioException {
        IngredienteDTO ingrediente = new IngredienteDTO("Queso", UnidadMedida.PIEZAS, 10);
        
        try {
            IngredienteDTO ingredienteRegistrado = ingredienteBO.registrarIngrediente(ingrediente);
            System.out.println(ingredienteRegistrado);
        } catch (NegocioException e) {
            throw new NegocioException("Error al registrar ingrediente: " + e.getMessage());
        }
    }
    
    private static void obtenerIngredientes() throws NegocioException {
        try {
            List<IngredienteDTO> ingredientes = ingredienteBO.filtroBuscarIngredientes(null, null);
            for (IngredienteDTO i : ingredientes) {
                System.out.println("Nombre: " + i.getNombre() + " - Unidad medida: "
                        + i.getUnidadMedida() + " - Stock: " + i.getCantidadStock());
            }
            
            if (ingredientes.isEmpty()) {
                System.out.println("No hay ingredientes");
            }
        } catch (NegocioException e) {
            throw new NegocioException("Error al obtener ingredientes: " + e.getMessage());
        }
    }
}
