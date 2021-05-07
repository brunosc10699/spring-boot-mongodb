package com.bruno.workshopspringmongo.resources.exceptions;

import com.bruno.workshopspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado!",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }
}
