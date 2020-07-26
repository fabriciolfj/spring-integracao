package com.github.fabriciolfj.cadastropessoa.api.dto.response;

import com.github.fabriciolfj.cadastropessoa.domain.entity.Pessoa;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(PessoaResponseMapperDecorate.class)
public interface PessoaResponseMapper {

    PessoaResponseDTO toDto(final Pessoa pessoa);
}
