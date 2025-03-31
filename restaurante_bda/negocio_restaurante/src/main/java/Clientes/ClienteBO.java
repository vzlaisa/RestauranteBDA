/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import entidades.Cliente;
import entidades.Comanda;
import java.util.List;

/**
 *
 * @author dario
 */
public class ClienteBO implements IClienteBO{
    @Override
    public double calcularTotalGastado(Cliente cliente){
        List<Comanda> comandas =cliente.getComandas();
        return(comandas !=null)? comandas.stream().mapToDouble(Comanda::getTotal).sum():0.0;
    } 
    @Override
    public int obtenerNumeroVisitas(Cliente cliente){
        return(cliente.getComandas()!=null)? cliente.getComandas().size():0;
    }
    @Override
    public int calcularPuntosFidelidad(Cliente cliente){
        return(int) (calcularTotalGastado(cliente)/20); 
    }
}
