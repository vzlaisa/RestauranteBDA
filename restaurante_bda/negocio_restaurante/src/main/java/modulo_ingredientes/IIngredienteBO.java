/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_ingredientes;

import DTOs.IngredienteDTO;
import exception.NegocioException;

/**
 *
 * @author Ximena
 */
public interface IIngredienteBO {
    
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingredienteNuevo) throws NegocioException;
    
}
