/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

/**
 *
 * @author rocha
 */
public class Utilerias {
    
    /**
     * Método para validar si una cadena es nula o está vacía.
     *
     * @param str Cadena de texto a validar.
     * @return true si la cadena es nula o está vacía, false en caso contrario.
     */
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().isBlank();
    }
}
