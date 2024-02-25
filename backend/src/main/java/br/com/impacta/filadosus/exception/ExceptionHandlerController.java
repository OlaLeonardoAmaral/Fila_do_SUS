package br.com.impacta.filadosus.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.impacta.filadosus.exception.errors.PacienteAlreadyExistsException;
import br.com.impacta.filadosus.exception.errors.PacienteNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<String> handlePacienteNotFoundException(PacienteNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PacienteAlreadyExistsException.class)
    public ResponseEntity<String> handlePacienteAlreadyExistsException(PacienteAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
