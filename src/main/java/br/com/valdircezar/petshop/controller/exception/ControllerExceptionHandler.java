package br.com.valdircezar.petshop.controller.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.time.LocalDateTime.now;
import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                         HttpServletRequest request) {
                return ResponseEntity.badRequest().body(
                        new StandardError(BAD_REQUEST.value(),
                                BAD_REQUEST.getReasonPhrase(), now(), ex.getMessage(), request.getRequestURI())
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException ex,
                                                                         HttpServletRequest request) {
        return ResponseEntity.badRequest().body(
                new StandardError(BAD_REQUEST.value(), "Validation error", now(),
                        requireNonNull(ex.getBindingResult().getFieldError().getDefaultMessage()), request.getRequestURI())
        );
    }
    
}
