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
    
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException;
    
    public List<IngredienteDTO> ingredientesPorNombre(String nombre) throws NegocioException;
    
    public List<IngredienteDTO> ingredientesPorUnidadMedida(UnidadMedida unidad) throws NegocioException;
    
    public IngredienteDTO obtenerIngredientePorNombreYUnidad(String nombre, UnidadMedida unidad) throws NegocioException;
}
