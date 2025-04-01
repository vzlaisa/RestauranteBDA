/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_ingredientes;

import entidades.Ingrediente;
import exception.PersistenciaException;

/**
 *
 * @author Ximena
 */
public interface IIngredienteDAO {
    
    Ingrediente registrarIngrediente(Ingrediente ingrediente) throws PersistenciaException;
    
}
