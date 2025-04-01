/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinadores;

import modulo_ingredientes.AdministrarIngredientesFrm;
import modulo_ingredientes.IncrementarStockIngredienteFrm;
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
    
    // Pantallas
    private Menu menu;
    private RegistrarProductoFrm registrarProductoFrm;
    private RegistrarIngredienteFrm registrarIngredienteFrm;
    private AdministrarIngredientesFrm administrarIngredientesFrm;
    private IncrementarStockIngredienteFrm incrementarStockIngredienteFrm;
    
    private CoordinadorAplicacion() {
        
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
    
    public void mostrarMenu() {
        if (this.menu == null) {
            this.menu = new Menu();
        }
        
        menu.setVisible(true);
    }
}
