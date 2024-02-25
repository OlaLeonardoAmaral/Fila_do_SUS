
package br.com.impacta.filadosus.exception.errors;


public class PacienteAlreadyExistsException extends RuntimeException {
    public PacienteAlreadyExistsException(String message) {
        super(message);
    }
}