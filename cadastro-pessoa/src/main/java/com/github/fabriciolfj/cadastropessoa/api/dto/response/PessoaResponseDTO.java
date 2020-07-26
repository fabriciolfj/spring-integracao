package com.github.fabriciolfj.cadastropessoa.api.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PessoaResponseDTO {

    private String nome;
    private List<LogradouroResponseDTO> logradouros;
}
