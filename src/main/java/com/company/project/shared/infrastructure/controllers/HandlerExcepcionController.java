package com.company.project.shared.infrastructure.controllers;

import com.company.project.register.supplier.application.validation.ExistsSupplierIdValidation;
import com.company.project.shared.model.ErrorException;
import com.company.project.shared.model.exceptions.NotFoundException;
import com.company.project.shared.model.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.UUID;

@RestControllerAdvice
public class HandlerExcepcionController {

    private  ErrorException errorEx;

    @ExceptionHandler( NotFoundException.class )
    public ResponseEntity<ErrorException> notFound(RuntimeException ex){
        errorEx = new ErrorException();
        errorEx.setDate(new Date());
        errorEx.setError("Resource not found...");
        errorEx.setMessage(ex.getMessage());
        errorEx.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(errorEx.getStatus()).body(errorEx);
    }

    @ExceptionHandler({UnprocessableEntityException.class})
    public ResponseEntity<ErrorException> unprocessableEntity(RuntimeException ex){
        errorEx = new ErrorException();
        errorEx.setDate(new Date());
        errorEx.setError("Resource not found...");
        errorEx.setMessage(ex.getMessage());
        errorEx.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return ResponseEntity.status(errorEx.getStatus()).body(errorEx);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorException> handleUUIDConversionError(HttpMessageNotReadableException ex) {
        errorEx = new ErrorException();
        errorEx.setDate(new Date());
        errorEx.setError("Check params sent by the client");
        errorEx.setMessage(ex.getMessage());
        errorEx.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return ResponseEntity.status(errorEx.getStatus()).body(errorEx);
    }

}