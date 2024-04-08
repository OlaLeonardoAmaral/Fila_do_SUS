
package br.com.impacta.filadosus.domain.patient.exceptions;

public class PatientAlreadyExistsException extends RuntimeException {

    public PatientAlreadyExistsException() {
        super("Patient already exists.");
    }

    public PatientAlreadyExistsException(String message) {
        super(message);
    }
}