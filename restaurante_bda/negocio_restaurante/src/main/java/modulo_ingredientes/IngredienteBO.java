/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_ingredientes;

import DTOs.IngredienteDTO;
import entidades.Ingrediente;
import enums.UnidadMedida;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.Arrays;
import java.util.List;
import utilerias.Utilerias;

/**
 *
 * @author Ximena
 */
public class IngredienteBO implements IIngredienteBO {
    private IIngredienteDAO ingredienteDAO;
    
    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
    }

    @Override
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingredienteNuevo) throws NegocioException {
        // Validar que el ingrediente no sea nulo
        if (ingredienteNuevo == null) {
            throw new NegocioException("El ingrediente no puede ser nulo.");
        }
        
        // Validar que el nombre del ingrediente no sea nulo
        if (ingredienteNuevo.getNombre() == null || ingredienteNuevo.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del ingrediente es obligatorio.");
        }
        // Validar que el ingrediente no sea repetido
        if (ingredienteExiste(ingredienteNuevo.getNombre(), ingredienteNuevo.getUnidadMedida())) {
            throw new NegocioException("El ingrediente ya existe.");
        }
        
        // Validar que la unidad de medida no sea nula
        if (ingredienteNuevo.getUnidadMedida() == null) {
            throw new NegocioException("La unidad de medida es obligatoria.");
        }
        // Obtener enums de ingredientes
        List<UnidadMedida> unidades = Arrays.asList(UnidadMedida.values());
        // Validar que la unidad esté dentro de las unidades permitidas
        if (!unidades.contains(ingredienteNuevo.getUnidadMedida())) {
            throw new NegocioException("La unidad de medida no es válida.");
        }
        
        // Validar que la cantidad de stock no sea nula
        if (ingredienteNuevo.getCantidadStock() == null) {
            throw new NegocioException("La cantidad stock debe ser obligatoria.");
        }
        // Validar que la cantidad del stock sea mayor a 0
        if (ingredienteNuevo.getCantidadStock() <= 0) {
            throw new NegocioException("El stock del ingrediente debe ser mayor a 0.");
        }
        
        // Intentar registrar el ingrediente
        try {
            // Registrar nuevo ingrediente desde la DAO
            Ingrediente ingredienteRegistrado = ingredienteDAO.registrarIngrediente(IngredienteMapper.toEntity(ingredienteNuevo));
            
            if (ingredienteRegistrado == null || ingredienteRegistrado.getId() == null) {
                throw new NegocioException("Error al registrar ingrediente.");
            }
            
            return IngredienteMapper.toDTO(ingredienteRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar ingrediente: " + e.getMessage());
        }
        
    }
    
    // Método auxiliar que valida si el ingrediente ya existe dentro de la base de datos
    private boolean ingredienteExiste(String nombre, UnidadMedida unidad) throws NegocioException {
        if (nombre == null || nombre.trim().isEmpty() || unidad == null) {
            throw new NegocioException("Es necesario el nombre y la unidad de medida del ingrediente.");
        }
        
        try {
            return ingredienteDAO.obtenerIngredientesNombreYUnidad(nombre, unidad);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
}
