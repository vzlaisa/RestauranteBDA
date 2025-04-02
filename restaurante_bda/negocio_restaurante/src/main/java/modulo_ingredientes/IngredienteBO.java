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
import java.util.ArrayList;
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

    @Override
    public boolean eliminarIngrediente(String nombre, UnidadMedida unidad) throws NegocioException {
        // Validar que se hayan ingresado los datos
        if (nombre == null || nombre.trim().isEmpty() || unidad == null) {
            throw new NegocioException("Es necesario el nombre y unidad de medida del ingrediente");
        }
        
        try {
            // Buscar el ID del ingrediente en base a su nombre y unidad
            Long idIngrediente = ingredienteDAO.obtenerIdPorNombreYUnidad(nombre, unidad);
            // Lanzar excepción si no se encontró el ID
            if (idIngrediente == null) {
                throw new NegocioException("El ingrediente con nombre " + nombre + " y unidad " + unidad + " no existe.");
            }
            // Eliminar ingrediente con método de la DAO
            return ingredienteDAO.eliminarIngrediente(idIngrediente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar ingrediente: " + e.getMessage());
        }
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException {
        try {
            // Buscar lista de ingredientes con el método de la DAO
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();
            // Crear nueva lista de tipo IngredienteDTO
            List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
            // Recorrer para cada vez que se encuentre un ingrediente en la lista de ingredientes
            for (Ingrediente i : ingredientes) {
                // Agregar ingrediente a la lista, convirtiéndolo a DTO
                ingredientesDTO.add(IngredienteMapper.toDTO(i));
            }
            return ingredientesDTO;
        } catch (PersistenciaException e) { 
            throw new NegocioException("Error al obtener ingredientes: " + e.getMessage());
        }
    }

    @Override
    public List<IngredienteDTO> ingredientesPorNombre(String nombre) throws NegocioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NegocioException("El nombre del ingrediente es obligatorio.");
        }
        
        try {
            // Buscar lista de ingredientes con el método de la DAO
            List<Ingrediente> ingredientes = ingredienteDAO.ingredientesPorNombre(nombre);
            // Crear nueva lista de tipo IngredienteDTO
            List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
            for (Ingrediente i : ingredientes) {
                // Agregar ingrediente a la lista, convirtiéndolo a DTO
                ingredientesDTO.add(IngredienteMapper.toDTO(i));
            }
            return ingredientesDTO;
        } catch (PersistenciaException e) { 
            throw new NegocioException("Error al obtener ingredientes con nombre " + nombre + ": " + e.getMessage());
        }
    }

    @Override
    public List<IngredienteDTO> ingredientesPorUnidadMedida(UnidadMedida unidad) throws NegocioException {
        // Validar que se ingrese una unidad de medida
        if (unidad == null) {
            throw new NegocioException("La unidad de medida es obligatoria.");
        }
        // Validar que la unidad de medida sea válida
        List<UnidadMedida> unidades = Arrays.asList(UnidadMedida.values());
        if (!unidades.contains(unidad)) {
            throw new NegocioException("La unidad de medida " + unidad + " no es válida.");
        }
        
        try {
            // Buscar lista de ingredientes con el método de la DAO
            List<Ingrediente> ingredientes = ingredienteDAO.ingredientesPorUnidadMedida(unidad);
            // Crear nueva lista de tipo IngredienteDTO
            List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
            for (Ingrediente i : ingredientes) {
                // Agregar ingrediente a la lista, convirtiéndolo a DTO
                ingredientesDTO.add(IngredienteMapper.toDTO(i));
            }
            return ingredientesDTO;
        } catch (PersistenciaException e) { 
            throw new NegocioException("Error al obtener ingredientes con unidad " + unidad + ": " + e.getMessage());
        }
    }

    @Override
    public IngredienteDTO obtenerIngredientePorNombreYUnidad(String nombre, UnidadMedida unidad) throws NegocioException {
        // Validar que se ingresen los datos
        if (nombre == null || nombre.trim().isEmpty() || unidad == null) {
            throw new NegocioException("Es necesario el nombre y unidad de medida del ingrediente");
        }
        
        try {
            // Buscar ingrediente con método de la DAO
            Ingrediente ingrediente = ingredienteDAO.obtenerIngredientePorNombreYUnidad(nombre, unidad);
            if (ingrediente == null) {
                throw new NegocioException("No se encontró el ingrediente.");
            }
            // Regresar el ingrediente convertido a DTO
            return IngredienteMapper.toDTO(ingrediente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener ingrediente: " + e.getMessage());
        }
    }
    
}
