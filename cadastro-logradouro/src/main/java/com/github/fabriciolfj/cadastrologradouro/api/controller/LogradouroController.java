package com.github.fabriciolfj.cadastrologradouro.api.controller;

import com.github.fabriciolfj.cadastrologradouro.api.dto.response.LogradouroResponseDTO;
import com.github.fabriciolfj.cadastrologradouro.domain.entity.Logradouro;
import com.github.fabriciolfj.cadastrologradouro.domain.service.LogradouroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logradouros")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class LogradouroController {

    private final LogradouroService service;

    @GetMapping
    public ResponseEntity<List<LogradouroResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{cep}")
    public ResponseEntity<LogradouroResponseDTO> findLogradouro(@PathVariable("cep") final String cep) {
        return ResponseEntity.ok().body(service.findLogradouro(cep));
    }
}
