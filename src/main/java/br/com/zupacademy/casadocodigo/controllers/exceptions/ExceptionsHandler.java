package br.com.zupacademy.casadocodigo.controllers.exceptions;

import br.com.zupacademy.casadocodigo.entities.respostasDto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> catchValidationError(MethodArgumentNotValidException exception, HttpServletRequest request){

        List<ValidationErrorResponse> validationErrorResponse = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            ValidationErrorResponse validationError = new ValidationErrorResponse(HttpStatus.BAD_REQUEST.value(), error.getDefaultMessage(), error.getField());
            validationErrorResponse.add(validationError);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorResponse);

    }




}
