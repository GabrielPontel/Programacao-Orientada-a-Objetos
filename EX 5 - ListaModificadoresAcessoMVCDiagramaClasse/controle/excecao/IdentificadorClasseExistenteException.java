/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controle.excecao;

/**
 *
 * @author gbpon
 */
public class IdentificadorClasseExistenteException extends Exception {

    /**
     * Creates a new instance of
     * <code>IdentificadorClasseExistenteException</code> without detail
     * message.
     */
    public IdentificadorClasseExistenteException() {
    }

    /**
     * Constructs an instance of
     * <code>IdentificadorClasseExistenteException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public IdentificadorClasseExistenteException(String msg) {
        super(msg);
    }
}
