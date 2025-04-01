/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author rocha
 */
public class ProductoNuevoDTO {
    private String nombre;
    private Double precio;
    private Enum tipo;
    // FALTA AGREGAR LISTA DE INGREDIENTES DTO

    public ProductoNuevoDTO() {
    }

    public ProductoNuevoDTO(String nombre, Double precio, Enum tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ProductoNuevoDTO{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + '}';
    }
}
