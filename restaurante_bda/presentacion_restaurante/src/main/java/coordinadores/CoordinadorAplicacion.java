/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinadores;

import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import dependencyInjector.DependencyInjector;
import enums.UnidadMedida;
import excepciones.PresentacionException;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;
import modulo_ingredientes.AdministrarIngredientesFrm;
import modulo_ingredientes.IIngredienteBO;
import modulo_ingredientes.IIngredienteDAO;
import modulo_ingredientes.ActualizarStockIngredienteFrm;
import modulo_ingredientes.EliminarIngredienteFrm;
import modulo_ingredientes.IngredienteBO;
import modulo_ingredientes.IngredienteDAO;
import modulo_ingredientes.RegistrarIngredienteFrm;
import modulo_productos.IProductoBO;
import modulo_productos.RegistrarProductoFrm;
import presentacion.Menu;

/**
 *
 * @author rocha
 */
public class CoordinadorAplicacion {
    // Instancia única estática del coordinador
    private static CoordinadorAplicacion instance;
    
    private IIngredienteBO ingredienteBO;
    private IProductoBO productoBO;
    
    // Pantallas
    private Menu menu;
    private RegistrarProductoFrm registrarProductoFrm;
    private RegistrarIngredienteFrm registrarIngredienteFrm;
    private AdministrarIngredientesFrm administrarIngredientesFrm;
    private ActualizarStockIngredienteFrm actualizarStockIngredienteFrm;
    private EliminarIngredienteFrm eliminarIngredienteFrm;
    
    private CoordinadorAplicacion() {
        this.ingredienteBO = DependencyInjector.crearIngredienteBO();
        this.productoBO = DependencyInjector.crearProductoBO();
    }
    
    // Método para obtener una única instancia
    public static CoordinadorAplicacion getInstancia() {
        if (instance == null) {
            instance = new CoordinadorAplicacion();
        }
        return instance;
    }
    
    public void mostrarRegistrarProductoFrm() {
        if (this.registrarProductoFrm == null) {
            this.registrarProductoFrm = new RegistrarProductoFrm();
        }
        
        registrarProductoFrm.setVisible(true);
    }
    
    public void mostrarRegistrarIngredienteFrm() {
        if (this.registrarIngredienteFrm == null) {
            this.registrarIngredienteFrm = new RegistrarIngredienteFrm();
        }
        registrarIngredienteFrm.setVisible(true);
    }
    
    public void mostrarActualizarStockIngredienteFrm() {
        if (this.actualizarStockIngredienteFrm == null) {
            this.actualizarStockIngredienteFrm = new ActualizarStockIngredienteFrm();
        }
        actualizarStockIngredienteFrm.setVisible(true);
    }
    
    public void mostrarEliminarIngredienteFrm() {
        if (this.eliminarIngredienteFrm == null) {
            this.eliminarIngredienteFrm = new EliminarIngredienteFrm();
        }
        eliminarIngredienteFrm.setVisible(true);
    }
    
    public void mostrarAdministrarIngredientes() {
        if (this.administrarIngredientesFrm == null) {
            this.administrarIngredientesFrm = new AdministrarIngredientesFrm();
        }
        administrarIngredientesFrm.setVisible(true);
    }
    
    public void mostrarMenu() {
        if (this.menu == null) {
            this.menu = new Menu();
        }
        
        menu.setVisible(true);
    }
    
    // Método para registrar un ingrediente nuevo
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingrediente) throws PresentacionException {
        try {
            
            return ingredienteBO.registrarIngrediente(ingrediente);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
        
    }
    
    public List<IngredienteDTO> filtrarIngredientes(String nombre, UnidadMedida unidad) throws PresentacionException {
        try {
            return ingredienteBO.filtroBuscarIngredientes(nombre, unidad);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    public ProductoDTO registrarProducto(ProductoDTO producto) throws PresentacionException {
        if (producto == null) {
            throw new PresentacionException("El producto no puede ser nulo.");
        }
        
        try {
            return productoBO.registrarProducto(producto);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
}
