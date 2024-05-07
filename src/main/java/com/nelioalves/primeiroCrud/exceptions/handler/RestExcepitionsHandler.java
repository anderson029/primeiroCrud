package com.nelioalves.primeiroCrud.exceptions.handler;

import com.nelioalves.primeiroCrud.exceptions.BusinessException;
import com.nelioalves.primeiroCrud.exceptions.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class RestExcepitionsHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDto>> handleMethodArgumentNotValidExcepetion(MethodArgumentNotValidException ex){
        log.info("RestExcepitionsHandler.handleMethodArgumentNotValidExcepetion");
        List<ErrorResponseDto> errorMessages = new ArrayList<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : errors){
            ErrorResponseDto errorDto = new ErrorResponseDto("1", error.getDefaultMessage());
            errorMessages.add(errorDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException ex){
        log.error("RestExcepitionsHandler.handleBusinessException");
        ErrorResponseDto error = new ErrorResponseDto(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(error);
    }
}
