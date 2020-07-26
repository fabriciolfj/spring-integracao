package com.github.fabriciolfj.cadastropessoa.api.controller;

import com.github.fabriciolfj.cadastropessoa.api.dto.request.PessoaResquestDTO;
import com.github.fabriciolfj.cadastropessoa.api.dto.response.PessoaResponseDTO;
import com.github.fabriciolfj.cadastropessoa.domain.entity.Pessoa;
import com.github.fabriciolfj.cadastropessoa.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<PessoaResponseDTO> findByName(@PathVariable("nome") final String nome) {
        return ResponseEntity.ok().body(pessoaService.findPessoa(nome));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponseDTO create(@RequestBody final PessoaResquestDTO dto) {
        return pessoaService.create(dto);
    }

    @DeleteMapping("/{nome}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("nome") final String nome) {
        pessoaService.delete(nome);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PessoaResponseDTO update(@PathVariable("id") final Long id, @RequestBody final PessoaResquestDTO dto) {
        return pessoaService.update(id, dto);
    }
}
