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
}
