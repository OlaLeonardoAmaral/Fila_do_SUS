package br.com.impacta.filadosus.domain.patient.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient not found.");
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
