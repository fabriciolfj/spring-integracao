package com.github.fabriciolfj.cadastropessoa.api.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResquestDTO {

    private String nome;
    private String cep;
}
