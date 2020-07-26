package com.github.fabriciolfj.cadastropessoa.domain.repository;

import com.github.fabriciolfj.cadastropessoa.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByNome(final String nome);
}
