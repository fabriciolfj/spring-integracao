package com.github.fabriciolfj.cadastropessoa.api.exceptions.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardError {

    private String mensagem;
}
