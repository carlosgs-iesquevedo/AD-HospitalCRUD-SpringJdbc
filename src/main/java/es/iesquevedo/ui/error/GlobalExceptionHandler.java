package es.iesquevedo.ui.error;

import es.iesquevedo.domain.error.PacienteDuplicadoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PacienteDuplicadoError.class)
    public ResponseEntity<String> handleForeignKetException(PacienteDuplicadoError e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
