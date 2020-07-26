package com.github.fabriciolfj.cadastropessoa.api.exceptions.controller;

import com.github.fabriciolfj.cadastropessoa.api.exceptions.LogradouroException;
import com.github.fabriciolfj.cadastropessoa.api.exceptions.PessoaNotFoundException;
import com.github.fabriciolfj.cadastropessoa.api.exceptions.dto.StandardError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerHandler {

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<StandardError> pessoaNotFoundException(PessoaNotFoundException e) {
        return ResponseEntity.badRequest().body(StandardError.builder().mensagem(e.getMessage()).build());
    }

    @ExceptionHandler(LogradouroException.class)
    public ResponseEntity<StandardError> logradouroException(LogradouroException e) {
        return ResponseEntity.badRequest().body(StandardError.builder().mensagem(e.getMessage()).build());
    }
}
