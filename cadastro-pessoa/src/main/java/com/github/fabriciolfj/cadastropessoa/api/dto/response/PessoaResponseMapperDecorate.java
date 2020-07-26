package com.github.fabriciolfj.cadastropessoa.api.dto.response;

import com.github.fabriciolfj.cadastropessoa.domain.entity.Pessoa;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class PessoaResponseMapperDecorate implements PessoaResponseMapper {

    @Override
    public PessoaResponseDTO toDto(Pessoa pessoa) {
        return PessoaResponseDTO.builder()
                .nome(pessoa.getNome())
                .logradouros(pessoa.getLogradouros().stream().map(logradouro ->
                        LogradouroResponseDTO.builder().code(logradouro.getCode()).build()).collect(Collectors.toList()))
                .build();
    }
}
