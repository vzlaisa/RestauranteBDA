/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinadores;

import DTOs.ClienteDTO;
import DTOs.IngredienteDTO;
import dependencyInjector.DependencyInjector;
import exception.NegocioException;
import java.util.List;
import modulo_clientes.ConsultarClientes;
import modulo_clientes.IClienteBO;
import modulo_clientes.RegistrarClientes;
import modulo_ingredientes.AdministrarIngredientesFrm;
import modulo_ingredientes.IIngredienteBO;
import modulo_ingredientes.IIngredienteDAO;
import modulo_ingredientes.IncrementarStockIngredienteFrm;
import modulo_ingredientes.IngredienteBO;
import modulo_ingredientes.IngredienteDAO;
import modulo_ingredientes.RegistrarIngredienteFrm;
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
    
    // Pantallas
    private Menu menu;
    private RegistrarProductoFrm registrarProductoFrm;
    private RegistrarIngredienteFrm registrarIngredienteFrm;
    private AdministrarIngredientesFrm administrarIngredientesFrm;
    private IncrementarStockIngredienteFrm incrementarStockIngredienteFrm;
    private RegistrarClientes registrarClientes;
    private ConsultarClientes consultarClientes;
    
    private CoordinadorAplicacion() {
        this.ingredienteBO = DependencyInjector.crearIngredienteBO();
        this.clienteBO = DependencyInjector.crearClienteBO();
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
    
    public void mostrarIncrementarStockIngredienteFrm() {
        if (this.incrementarStockIngredienteFrm == null) {
            this.incrementarStockIngredienteFrm = new IncrementarStockIngredienteFrm();
        }
        incrementarStockIngredienteFrm.setVisible(true);
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
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingrediente) throws NegocioException {
        return ingredienteBO.registrarIngrediente(ingrediente);
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
