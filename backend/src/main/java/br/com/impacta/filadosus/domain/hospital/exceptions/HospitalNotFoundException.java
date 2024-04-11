package br.com.impacta.filadosus.domain.hospital.exceptions;

public class HospitalNotFoundException extends RuntimeException {

    public HospitalNotFoundException() {
        super("Hospital not found");
    }
    
    public HospitalNotFoundException(String message) {
        super(message);
    }
    
}
