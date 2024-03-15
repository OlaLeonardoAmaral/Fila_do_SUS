package br.com.impacta.filadosus.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.impacta.filadosus.exception.errors.PatientAlreadyExistsException;
import br.com.impacta.filadosus.exception.errors.PatientNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handlePatientNotFoundException(PatientNotFoundException e) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, "Patient not found.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(PatientAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> handlePatientAlreadyExistsException(PatientAlreadyExistsException e) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, "Patient already exists");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
