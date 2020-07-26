package com.github.fabriciolfj.cadastrologradouro.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logradouro")
public class Logradouro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "endereco", nullable = false)
    private String endereco;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "pais", nullable = false)
    private String pais;
    @Column(name = "code", length = 36, unique = true, nullable = false)
    private String code;

    @PrePersist
    private void gerarCodigo() {
        setCode(UUID.randomUUID().toString());
    }
}
