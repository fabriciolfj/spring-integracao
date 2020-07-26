package com.github.fabriciolfj.cadastrologradouro.domain.repository;

import com.github.fabriciolfj.cadastrologradouro.domain.entity.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

    Optional<Logradouro> findByCep(final String cep);
}
