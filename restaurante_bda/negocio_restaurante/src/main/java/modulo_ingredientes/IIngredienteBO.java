/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_ingredientes;

import DTOs.IngredienteDTO;
import enums.UnidadMedida;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Ximena
 */
public interface IIngredienteBO {
    
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingredienteNuevo) throws NegocioException;
    
    public boolean eliminarIngrediente(String nombre, UnidadMedida unidad) throws NegocioException;
    
    // Método de prueba para usar filtro de búsqueda en presentación
    public List<IngredienteDTO> filtroBuscarIngredientes(String nombre, UnidadMedida unidad) throws NegocioException;
    
    public void actualizarIngrediente(String nombre, UnidadMedida unidad, Integer nuevoStock) throws NegocioException;
    
    public IngredienteDTO ingredientePorNombreYUnidad(String nombre, UnidadMedida unidad) throws NegocioException;
}
