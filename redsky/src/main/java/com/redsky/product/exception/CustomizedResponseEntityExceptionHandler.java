package com.redsky.product.exception;

import com.redsky.product.constant.RedSkyConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@RestController

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ErrorDetails> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleProductServiceProcessingException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(RedSkyConstant.GENERIC_ERROR_MESSAGE);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
