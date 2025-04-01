/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia_restaurante;

import entidades.Ingrediente;
import entidades.ProductosIngredientes;
import enums.UnidadMedida;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import modulo_ingredientes.IIngredienteDAO;
import modulo_ingredientes.IngredienteDAO;

/**
 *
 * @author rocha
 */
public class Persistencia_restaurante {

    public static void main(String[] args) throws PersistenciaException {
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstancia();
        
        try {
            Ingrediente ingrediente = new Ingrediente("Pan", UnidadMedida.PIEZAS, 20, null);
            ingredienteDAO.registrarIngrediente(ingrediente);
            System.out.println("Ingrediente registrado");
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar ingrediente: " + e.getMessage());
        }
    }
}
