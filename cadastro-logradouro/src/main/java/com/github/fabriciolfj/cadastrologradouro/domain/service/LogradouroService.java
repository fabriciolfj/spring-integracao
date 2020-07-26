package com.github.fabriciolfj.cadastrologradouro.domain.service;

import com.github.fabriciolfj.cadastrologradouro.api.dto.response.LogradouroResponseDTO;
import com.github.fabriciolfj.cadastrologradouro.api.dto.response.LogradouroResponseMapper;
import com.github.fabriciolfj.cadastrologradouro.api.exceptions.LogradouroNotFoundException;
import com.github.fabriciolfj.cadastrologradouro.domain.repository.LogradouroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LogradouroService {

    private final LogradouroRepository logradouroRepository;
    private final LogradouroResponseMapper mapper;

    public LogradouroResponseDTO findLogradouro(final String cep) {
        return logradouroRepository.findByCep(cep)
                .map(mapper::toDto)
                .orElseThrow(() -> new LogradouroNotFoundException("Logradouro não encontrado para o cep: " + cep));
    }

    public List<LogradouroResponseDTO> findAll() {
        return logradouroRepository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
