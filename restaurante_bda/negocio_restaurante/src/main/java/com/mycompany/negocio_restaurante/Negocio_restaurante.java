/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negocio_restaurante;

import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import DTOs.ProductosIngredientesDTO;
import dependencyInjector.DependencyInjector;
import enums.TipoProducto;
import enums.UnidadMedida;
import exception.NegocioException;
import modulo_productos.IProductoBO;

/**
 *
 * @author rocha
 */
public class Negocio_restaurante {
    private static IProductoBO productoBO = DependencyInjector.crearProductoBO();
    
    public static void main(String[] args) throws NegocioException {
        registrarProducto();
    }
    
    private static void registrarProducto() throws NegocioException {
        IngredienteDTO ingrediente = new IngredienteDTO("Pan", UnidadMedida.PIEZAS, 20);
        ProductoDTO producto = new ProductoDTO("Sandwich", 30.0, TipoProducto.PLATILLO);
        ProductosIngredientesDTO productoIngrediente = new ProductosIngredientesDTO(2, producto, ingrediente);
        producto.getIngredientes().add(productoIngrediente);
        
        try {
            ProductoDTO productoRegistrado = productoBO.registrarProducto(producto);
            System.out.println(productoRegistrado);
        } catch (NegocioException e) {
            throw new NegocioException("Error al registrar ingrediente: " + e.getMessage());
        }
        
        
        
    }
}
