package br.com.impacta.filadosus.exception.errors;

public class PatientNotFoundException extends RuntimeException {
    
    
    
    public PatientNotFoundException() {
        super("Patient not found.");
    }
    public PatientNotFoundException(String message) {
        super(message);
    }
}
