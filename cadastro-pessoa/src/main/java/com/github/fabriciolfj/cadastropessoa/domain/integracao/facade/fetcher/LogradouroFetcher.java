package com.github.fabriciolfj.cadastropessoa.domain.integracao.facade.fetcher;

import com.github.fabriciolfj.cadastropessoa.api.exceptions.LogradouroException;
import com.github.fabriciolfj.cadastropessoa.domain.entity.Logradouro;
import com.github.fabriciolfj.cadastropessoa.domain.integracao.request.LogradouroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogradouroFetcher {

    private final LogradouroClient client;

    public Logradouro get(final String cep) {
        try {
            var dto = client.getLogradouro(cep);
            return Logradouro.builder()
                    .code(dto.getCode())
                    .build();
        } catch (Exception e) {
            throw new LogradouroException("Falha ao buscar o logradouro. Detalhes: " + e.getMessage());
        }
    }
}
