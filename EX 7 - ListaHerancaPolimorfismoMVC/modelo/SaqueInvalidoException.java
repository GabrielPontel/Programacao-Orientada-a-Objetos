/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class SaqueInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>SaqueInvalidoException</code> without
     * detail message.
     */
    public SaqueInvalidoException() {
    }

    /**
     * Constructs an instance of <code>SaqueInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SaqueInvalidoException(String msg) {
        super(msg);
    }
}
