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
import modulo_ingredientes.AdministrarIngredientesFrm;
import modulo_ingredientes.IIngredienteBO;
import modulo_ingredientes.ActualizarStockIngredienteFrm;
import modulo_ingredientes.EliminarIngredienteFrm;
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
   //  private IncrementarStockIngredienteFrm incrementarStockIngredienteFrm; ///No se si desaparecio es te form asi que lo comentarie
    private RegistrarClientes registrarClientes;
    private ConsultarClientes consultarClientes;
    
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
        
        administrarProductosFrm.setVisible(true);
    }
    
    public void mostrarEditarProductoFrm() {
        if (this.editarProductoFrm == null) {
            this.editarProductoFrm = new EditarProductoFrm();
        }
        
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
        if (registrarClientes == null) {
            registrarClientes = new RegistrarClientes();
        }
        registrarClientes.setVisible(true);
    }
    
    public void mostrarConsultarClientes() {
        if (consultarClientes == null) {
            consultarClientes = new ConsultarClientes();
        }
        
       consultarClientes.setVisible(true);
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

          // Métodos para operaciones con clientes
          public ClienteDTO registrarClientes(ClienteDTO clienteDTO) throws NegocioException {
              return clienteBO.registrarCliente(clienteDTO);
          }

          public List<ClienteDTO> buscarClientes(String criterio) throws NegocioException {
              return clienteBO.buscarClientes(criterio);
          }

          public ClienteDTO obtenerClientePorTelefono(String telefono) throws NegocioException {
              return clienteBO.obtenerClientePorTelefono(telefono);
          }
}
