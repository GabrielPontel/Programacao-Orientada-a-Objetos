/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package modelo.exceptions;

/**
 *
 * @author gabriel
 */
public class NotExistException extends Exception {

    /**
     * Creates a new instance of <code>NotExistException</code> without detail
     * message.
     */
    public NotExistException() {
    }

    /**
     * Constructs an instance of <code>NotExistException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistException(String msg) {
        super(msg);
    }
}
