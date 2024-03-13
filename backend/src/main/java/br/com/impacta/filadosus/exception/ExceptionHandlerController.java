package br.com.impacta.filadosus.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.impacta.filadosus.exception.errors.PatientAlreadyExistsException;
import br.com.impacta.filadosus.exception.errors.PatientNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PatientAlreadyExistsException.class)
    public ResponseEntity<String> handlePatientAlreadyExistsException(PatientAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
