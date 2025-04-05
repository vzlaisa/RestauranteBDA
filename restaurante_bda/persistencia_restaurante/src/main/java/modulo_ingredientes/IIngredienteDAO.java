/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modulo_ingredientes;

import entidades.Ingrediente;
import enums.UnidadMedida;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Ximena
 */
public interface IIngredienteDAO {
    
    /**
     * Método que registra un ingrediente nuevo en la base de datos.
     * 
     * @param ingrediente Objeto ingrediente.
     * @return El objeto ingrediente creado.
     * @throws PersistenciaException En caso de haber un error en el registro de ingredientes.
     */
    public Ingrediente registrarIngrediente(Ingrediente ingrediente) throws PersistenciaException;
    
    /**
     * Método que elimina un ingrediente de la base de datos.
     * 
     * @param id ID del ingrediente.
     * @return True si se eliminó el ingrediente, false en caso contrario.
     * @throws PersistenciaException En caso de haber un error en la eliminación del ingrediente.
     */
    public boolean eliminarIngrediente(Long id) throws PersistenciaException;
    
    /**
     * Método que verifica si un ingrediente ya está registrado dentro de la base de datos.
     * 
     * @param nombre Nombre del ingrediente.
     * @param unidad Unidad de medida del ingrediente.
     * @return True si se encontró el ingrediente, false en caso contrario.
     * @throws PersistenciaException En caso de haber un error en la verificación del ingrediente.
     */
    public boolean obtenerIngredientesNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException;
    
    /**
     * Método que obtiene una lista de todos los ingredientes registrados.
     * 
     * @return Lista de ingredientes registrados.
     * @throws PersistenciaException En caso de haber un error al consultar ingredientes.
     */
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException;
    
    /**
     * Método que obtiene una lista de los ingredientes filtrados por nombre.
     * 
     * @param nombre Nombre del ingrediente.
     * @return Lista de ingredientes registrados con un nombre específico.
     * @throws PersistenciaException En caso de haber un error al consultar ingredientes filtrados por nombre.
     */
    public List<Ingrediente> ingredientesPorNombre(String nombre) throws PersistenciaException;
    
    /**
     * Método que obtiene una lista de los ingredientes filtrados por unidad de medida.
     * 
     * @param unidad Unidad de medida del ingrediente.
     * @return Lista de ingredientes registrados con una unidad de medida específica.
     * @throws PersistenciaException En caso de haber un error al consultar ingredientes filtrados por unidad de medida.
     */
    public List<Ingrediente> ingredientesPorUnidadMedida(UnidadMedida unidad) throws PersistenciaException;
    
    /**
     * Método que devuelve un ingrediente registrado con un nombre y unidad de
     * medida específicos.
     * 
     * @param nombre Nombre del ingrediente.
     * @param unidad Unidad de medida del ingrediente.
     * @return El objeto ingrediente si se encontró coincidencia.
     * @throws PersistenciaException En caso de haber un error al obtener el ingrediente.
     */
    public Ingrediente obtenerIngredientePorNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException;
    
    /**
     * Obtiene un ingrediente por su identificador.
     * 
     * @param id ID del ingrediente.
     * @return Ingrediente que coincide con el identificador.
     * @throws PersistenciaException En caso de haber un error al obtener el ingrediente.
     */
    public Ingrediente obtenerIngredientePorId(Long id) throws PersistenciaException;
    
    /**
     * Obtiene el identificador del ingrediente a partir de su nombre y unidad de medida.
     * 
     * @param nombre Nombre del ingrediente.
     * @param unidad Unidad de medida del ingrediente.
     * @return Identificador del ingrediente encontrado.
     * @throws PersistenciaException En caso de haber un error al obtener el ID.
     */
    public Long obtenerIdPorNombreYUnidad(String nombre, UnidadMedida unidad) throws PersistenciaException;
    
    public Ingrediente actualizar(Ingrediente ingrediente) throws PersistenciaException;
    
}
