package com.github.fabriciolfj.cadastropessoa.domain.service;

import com.github.fabriciolfj.cadastropessoa.api.dto.request.PessoaResquestDTO;
import com.github.fabriciolfj.cadastropessoa.api.dto.response.PessoaResponseDTO;
import com.github.fabriciolfj.cadastropessoa.api.dto.response.PessoaResponseMapper;
import com.github.fabriciolfj.cadastropessoa.api.exceptions.PessoaNotFoundException;
import com.github.fabriciolfj.cadastropessoa.domain.entity.Pessoa;
import com.github.fabriciolfj.cadastropessoa.domain.integracao.facade.fetcher.LogradouroFetcher;
import com.github.fabriciolfj.cadastropessoa.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaResponseMapper mapper;
    private final LogradouroFetcher logradouroFetcher;

    public PessoaResponseDTO findPessoa(final String nome) {
        return mapper.toDto(getPessoa(nome));
    }

    private Pessoa getPessoa(String nome) {
        return pessoaRepository.findByNome(nome)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada pelo nome: " + nome));
    }

    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PessoaResponseDTO create(final PessoaResquestDTO resquestDTO) {
        var logradouro = logradouroFetcher.get(resquestDTO.getCep());
        var pessoa = Pessoa.builder()
                .logradouros(Arrays.asList(logradouro))
                .nome(resquestDTO.getNome())
                .build();
        logradouro.setPessoa(pessoa);
        return mapper.toDto(pessoaRepository.save(pessoa));
    }

    public PessoaResponseDTO update(final Long id, final PessoaResquestDTO resquestDTO) {
        return pessoaRepository.findById(id)
                .map(p -> {
                    p.setNome(resquestDTO.getNome());
                    return pessoaRepository.save(p);
                })
                .map(mapper::toDto)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id: " + id));
    }

    public void delete(final String nome) {
        var pessoa = getPessoa(nome);
        pessoaRepository.delete(pessoa);
    }
}
