/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinadores;

import DTOs.ClienteDTO;
import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import dependencyInjector.DependencyInjector;
import enums.UnidadMedida;
import excepciones.PresentacionException;
import exception.NegocioException;
import java.util.List;
import modulo_clientes.ConsultarClientes;
import modulo_clientes.IClienteBO;
import modulo_clientes.RegistrarClientes;
import modulo_ingredientes.ActualizarStockIngredienteFrm;
import modulo_ingredientes.AdministrarIngredientesFrm;
import modulo_ingredientes.EliminarIngredienteFrm;
import modulo_ingredientes.IIngredienteBO;
import modulo_ingredientes.RegistrarIngredienteFrm;
import modulo_productos.AdministrarProductosFrm;
import modulo_productos.EditarProductoFrm;
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
    private IClienteBO clienteBO;
    private IProductoBO productoBO;
    
    // Pantallas
    private Menu menu;
    private RegistrarProductoFrm registrarProductoFrm;
    private AdministrarProductosFrm administrarProductosFrm;
    private EditarProductoFrm editarProductoFrm;
    private RegistrarIngredienteFrm registrarIngredienteFrm;
    private AdministrarIngredientesFrm administrarIngredientesFrm;
    private ActualizarStockIngredienteFrm actualizarStockIngredienteFrm;
    private EliminarIngredienteFrm eliminarIngredienteFrm;
    private RegistrarClientes registrarClienteFrm;
    private ConsultarClientes consultarClientesFrm;
    
    private CoordinadorAplicacion() {
        this.ingredienteBO = DependencyInjector.crearIngredienteBO();
        this.clienteBO = DependencyInjector.crearClienteBO();
        this.productoBO = DependencyInjector.crearProductoBO();
    }
    
    // Método para obtener una única instancia
    public static CoordinadorAplicacion getInstancia() {
        if (instance == null) {
            instance = new CoordinadorAplicacion();
        }
        return instance;
    }
    
    // --------- FLUJO ENTRE PANTALLAS ---------
    public void mostrarRegistrarProductoFrm() {
        if (this.registrarProductoFrm == null) {
            this.registrarProductoFrm = new RegistrarProductoFrm();
        }
        
        registrarProductoFrm.setVisible(true);
    }
    
    public void mostrarAdministrarProductosFrm() {
        if (this.administrarProductosFrm == null) {
            this.administrarProductosFrm = new AdministrarProductosFrm();
        }
        
        administrarProductosFrm.cargarProductos();
        administrarProductosFrm.setVisible(true);
    }
    
    public void mostrarEditarProductoFrm() {
        if (this.editarProductoFrm == null) {
            this.editarProductoFrm = new EditarProductoFrm();
        }
        
        editarProductoFrm.cargarInformacion();
        editarProductoFrm.setVisible(true);
        
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
    
    public void mostrarRegistrarClientes() {
        if (registrarClienteFrm == null) {
            registrarClienteFrm = new RegistrarClientes();
        }
        registrarClienteFrm.setVisible(true);
    }
    
    public void mostrarConsultarClientes() {
        if (consultarClientesFrm == null) {
            consultarClientesFrm = new ConsultarClientes();
        }
        
       consultarClientesFrm.setVisible(true);
    }
    
    public void mostrarMenu() {
        if (this.menu == null) {
            this.menu = new Menu();
        }
        
        menu.setVisible(true);
    }
    
    // --------- INGREDIENTES ---------
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
    
    public void actualizarStockIngrediente(String nombre, UnidadMedida unidad, Integer nuevoStock) throws PresentacionException {
        try {
            ingredienteBO.actualizarIngrediente(nombre, unidad, nuevoStock);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    // --------- PRODUCTOS ---------
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
    
    public void establecerProductoElegido(ProductoDTO productoElegido) throws PresentacionException {
        if (productoElegido == null) {
            throw new PresentacionException("Es necesario elegir un producto para editar.");
        }
        
        if (editarProductoFrm == null) {
            this.editarProductoFrm = new EditarProductoFrm();
        }
        
        editarProductoFrm.setProductoElegido(productoElegido);
    }
    
    public List<ProductoDTO> obtenerProductosConIngredientes() throws PresentacionException {
        try {
            return productoBO.obtenerTodos();
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }
    
    public ProductoDTO obtenerProductoPorNombre(String nombre) throws PresentacionException {
        try {
            return productoBO.obtenerProductoPorNombre(nombre);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }
    
    public boolean actualizarProducto(ProductoDTO productoEditado) throws PresentacionException {
        if (productoEditado == null) {
            throw new PresentacionException("El producto no puede ser nulo.");
        }
        
        try {
            return productoBO.actualizarProducto(productoEditado) != null;
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    // --------- CLIENTES ---------
    public ClienteDTO registrarClientes(ClienteDTO clienteDTO) throws PresentacionException {
        try {
            return clienteBO.registrarCliente(clienteDTO);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    public List<ClienteDTO> buscarClientes(String criterio) throws  PresentacionException{
        try {
            return clienteBO.buscarClientes(criterio);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
        
    }

    public ClienteDTO obtenerClientePorTelefono(String telefono) throws PresentacionException {
        try {
            return clienteBO.obtenerClientePorTelefono(telefono);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
}
