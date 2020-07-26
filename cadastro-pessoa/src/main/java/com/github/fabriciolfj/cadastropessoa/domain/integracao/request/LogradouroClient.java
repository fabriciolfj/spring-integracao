package com.github.fabriciolfj.cadastropessoa.domain.integracao.request;

import com.github.fabriciolfj.cadastropessoa.domain.integracao.dto.LogradouroResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "logradouro-service",
            decode404 = true,
            url = "${api.logradouro}")
public interface LogradouroClient {

    @GetMapping(value = "/logradouros/{cep}", consumes = MediaType.APPLICATION_JSON_VALUE)
    LogradouroResponseDTO getLogradouro(@PathVariable("cep") final String cep);
}
