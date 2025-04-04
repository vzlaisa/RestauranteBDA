/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import excepciones.PresentacionException;
import javax.swing.JComboBox;
import javax.swing.table.TableModel;

/**
 * Clase que proporciona métodos de validación para entradas de usuario en presentación.
 *
 * @author 00000252267 Darío Cortez Vazquez
 * @author 00000253088 Ximena Rosales Panduro
 * @author 00000253301 Isabel Valenzuela Rocha
 * 
 */
public class Validaciones {
    
    /**
     * Valida que el texto ingresado no sea nulo, vacío y que contenga al menos una letra.
     *
     * @param texto Texto a validar.
     * @param campo Nombre del campo para generar mensajes de error.
     * @throws PresentacionException Si el texto es inválido.
     */
    public static void validarTexto(String texto, String campo) throws PresentacionException {
        // Verifica si el texto es nulo o está en blanco
        if (isNullOrBlank(texto)) {
            throw new PresentacionException("El " + campo + " es obligatorio.");
        }
        
        // Elimina espacios en blanco al inicio y final
        texto = texto.trim();
        
        // Verifica que el texto contenga al menos una letra (cualquier carácter de un idioma)
        if (!texto.matches(".*\\p{L}.*")) {
            throw new PresentacionException("El " + campo + " debe contener al menos una letra.");
        }
    }
    
    /**
     * Valida que el texto ingresado sea un número válido y mayor que cero.
     *
     * @param texto Texto a validar.
     * @param campo Nombre del campo para generar mensajes de error.
     * @throws PresentacionException Si el número es inválido o menor o igual a cero.
     */
    public static void validarNumero(String texto, String campo) throws PresentacionException {
        // Verifica si el texto es nulo o está en blanco
        if (isNullOrBlank(texto)) {
            throw new PresentacionException("El " + campo + " es obligatorio.");
        }
        
        // Verifica que el texto sea un número válido
        if (!esNumeroValido(texto)) {
            throw new PresentacionException("El formato de " + campo + " no es válido.");
        }
        
        // Convierte el texto a número para validación adicional
        double numero = Double.parseDouble(texto);
        
        // Verifica que el número sea mayor a 0
        if (numero <= 0) {
            throw new PresentacionException("El " + campo + " debe ser mayor a 0.");
        }
    }
    
    /**
     * Valida que el usuario haya seleccionado una opción válida en un JComboBox.
     *
     * @param combobox JComboBox a validar.
     * @param campo Nombre del campo para generar mensajes de error.
     * @throws PresentacionException Si la selección no es válida.
     */
    public static void validarCombobox(JComboBox combobox, String campo) throws PresentacionException {
        // Valida que la elección del combobox sea válido, es decir, que no sea la default ("No seleccionado")
        if (combobox == null || combobox.getSelectedItem().equals(combobox.getItemAt(0))) {
            throw new PresentacionException("El " + campo + " es obligatorio.");
        }
    }
    
    /**
     * Valida que una tabla tenga al menos una fila seleccionada.
     *
     * @param modelo Modelo de la tabla a validar.
     * @param campo Nombre del campo para generar mensajes de error.
     * @throws PresentacionException Si no hay filas seleccionadas.
     */
    public static void validarSeleccionTabla(TableModel modelo, String campo) throws PresentacionException {
        if (modelo.getRowCount() < 1) {
            throw new PresentacionException("Debe seleccionar al menos un " + campo + ".");
        }
    }
    
    /**
     * Determina si un texto representa un número válido.
     *
     * @param texto Texto a evaluar.
     * @return true si el texto es un número válido, false en caso contrario.
     */
    private static boolean esNumeroValido(String texto) {
        try {
            Double.valueOf(texto);  // Intenta convertirlo a número
            return true;  // Es un número válido
        } catch (NumberFormatException e) {
            return false; // No es un número
        }
    }
    
    /**
     * Verifica si un texto es nulo o está en blanco.
     *
     * @param texto Texto a evaluar.
     * @return true si el texto es nulo o vacío, false en caso contrario.
     */
    private static boolean isNullOrBlank(String texto) {
        return texto == null || texto.isBlank();
    }
        public static void validarTelefono(String telefono) throws PresentacionException {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new PresentacionException("El teléfono es obligatorio");
        }
        String telefonoLimpio = telefono.replaceAll("[^0-9]", "");
        if (telefonoLimpio.length() != 10) {
            throw new PresentacionException("El teléfono debe tener 10 dígitos numéricos");
        }
    }
    
    public static void validarEmail(String email) throws PresentacionException {
        if (email != null && !email.isEmpty() && 
            !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new PresentacionException("El correo electrónico no es válido");
        }
    }
}



