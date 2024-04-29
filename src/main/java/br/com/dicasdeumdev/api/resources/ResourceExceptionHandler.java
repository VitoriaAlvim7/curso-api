package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.resources.exceptions.StandardError;
import br.com.dicasdeumdev.api.services.exceptions.ObjectNotFoundWxception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundWxception.class)
    public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundWxception ex, HttpServletRequest request) {
        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
