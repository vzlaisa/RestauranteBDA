/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo_comandas;

/**
 *
 * @author rocha
 */
public class ComandaDAO implements IComandaDAO {

    private static ComandaDAO instanceComandaDAO;

    private ComandaDAO(){

    }
    
    /**
     * Obtiene la instancia única de la DAO.
     * 
     * Si no existe una instancia previa, se crea una nueva.
     * 
     * @return Instancia única de ProductoDAO.
     */
    public static ComandaDAO getInstance() {
        if (instanceComandaDAO == null) {
            instanceComandaDAO = new ComandaDAO();
        }

        return instanceComandaDAO;
    }
}
