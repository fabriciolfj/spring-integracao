package com.github.fabriciolfj.cadastrologradouro.api.exceptions.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardError {

    private String mensagem;
}
