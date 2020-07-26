package com.github.fabriciolfj.cadastrologradouro.api.exceptions.controller;

import com.github.fabriciolfj.cadastrologradouro.api.exceptions.LogradouroNotFoundException;
import com.github.fabriciolfj.cadastrologradouro.api.exceptions.dto.StandardError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(LogradouroNotFoundException.class)
    public ResponseEntity<StandardError> logradouroNotFound(LogradouroNotFoundException e) {
        return ResponseEntity.badRequest().body(StandardError.builder().mensagem(e.getMessage()).build());
    }

}
