
package br.com.impacta.filadosus.exception.errors;

public class PatientAlreadyExistsException extends RuntimeException {

    public PatientAlreadyExistsException() {
        super("Patient already exists.");
    }

    public PatientAlreadyExistsException(String message) {
        super(message);
    }
}