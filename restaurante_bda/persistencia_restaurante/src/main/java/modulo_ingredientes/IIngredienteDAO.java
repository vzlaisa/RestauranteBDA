/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_ingredientes;

import entidades.Ingrediente;
import enums.UnidadMedida;
import exception.PersistenciaException;

/**
 *
 * @author Ximena
 */
public interface IIngredienteDAO {
    
    public Ingrediente registrarIngrediente(Ingrediente ingrediente) throws PersistenciaException;
    
    public boolean obtenerIngredientesNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException;
    
}
