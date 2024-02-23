package br.com.impacta.filadosus.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.impacta.filadosus.pacientes.errors.PacienteNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
    

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<String> handlePacienteNotFoundException (PacienteNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
