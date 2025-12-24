/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package modelo.excecao;

/**
 *
 * @author gbpon
 */
public class ValorNegativoException extends Exception {

    /**
     * Creates a new instance of <code>ValorNegativoException</code> without
     * detail message.
     */
    public ValorNegativoException() {
    }

    /**
     * Constructs an instance of <code>ValorNegativoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValorNegativoException(String msg) {
        super(msg);
    }
}
