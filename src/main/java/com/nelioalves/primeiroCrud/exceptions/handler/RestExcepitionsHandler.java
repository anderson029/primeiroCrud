package com.nelioalves.primeiroCrud.exceptions.handler;

import com.nelioalves.primeiroCrud.exceptions.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExcepitionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDto>> handleMethodArgumentNotValidExcepetion(MethodArgumentNotValidException ex){
        List<ErrorResponseDto> errorMessages = new ArrayList<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : errors){
            errorMessages.add(new ErrorResponseDto("1", error.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }
}
