package com.server.myvns.common.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HTTPExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ConstraintViolationException.class)
    protected ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        String collect = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n"));
        return ResponseEntity.badRequest().body(collect);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<Object> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Object> entityNotFoundExceptionHandler(EntityNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    //TODO Change handling because when "Required body is missing" message is too long"
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(status).body(
                ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("\n"))
        );
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(status).body(ex.getMessage());
    }

}
