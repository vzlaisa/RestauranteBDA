/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO que representa un producto editado.
 *
 * Esta clase contiene los datos necesarios para actualizar un producto en la
 * base de datos. Incluye el nombre, el precio y los ingredientes asociados al
 * producto. Se utiliza para transferir los datos de un producto modificado
 * entre la capa de negocio y la capa de presentación o de acceso a datos.
 *
 * @author 00000253301 Isabel Valenzuela Rocha
 */
public class ProductoEditadoDTO {

    private String nombre;
    private Double precio;
    private List<ProductoIngredienteDTO> ingredientes;

    /**
     * Constructor por defecto. Inicializa la lista de ProductosIngredientes.
     */
    public ProductoEditadoDTO() {
        this.ingredientes = new ArrayList<>();
    }

    /**
     * Constructor que permite crear un DTO con nombre y precio al valor de su
     * parámetro. Inicializa la lista de ProductosIngredientes.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     */
    public ProductoEditadoDTO(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto al valor de su parámetro.
     *
     * @param nombre Nombre a establecer al producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto al valor de su parámetro.
     *
     * @param precio Precio a establecer al producto.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la lista de ingredientes asociados al producto.
     *
     * @return Lista de ingredientes asociados al producto.
     */
    public List<ProductoIngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes asociados al producto.
     *
     * @param ingredientes Lista de ingreadientes asociados a establecer al
     * producto.
     */
    public void setIngredientes(List<ProductoIngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Representación en cadena del objeto.
     *
     * Este método devuelve una representación en formato de texto de los datos
     * contenidos en el DTO, facilitando la depuración y el registro de
     * información.
     *
     * @return Cadena con los atributos del producto editado.
     */
    @Override
    public String toString() {
        return "ProductoEditadoDTO{" + "nombre=" + nombre + ", precio=" + precio + ", ingredientes=" + ingredientes + '}';
    }
}
