/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author rocha
 */
public class DatosInvalidosException extends Exception {

    public DatosInvalidosException() {
    }

    public DatosInvalidosException(String message) {
        super(message);
    }

    public DatosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
