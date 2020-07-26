package com.github.fabriciolfj.cadastrologradouro.api.dto.response;

import com.github.fabriciolfj.cadastrologradouro.domain.entity.Logradouro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LogradouroResponseMapper {

    @Mapping(source = "code", target = "code")
    @Mapping(source = "cep", target = "cep")
    LogradouroResponseDTO toDto(final Logradouro logradouro);
}
