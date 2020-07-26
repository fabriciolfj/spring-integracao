package com.github.fabriciolfj.cadastropessoa.service;

import br.com.six2six.fixturefactory.Fixture;
import com.github.fabriciolfj.cadastropessoa.CadastroPessoaApplicationTests;
import com.github.fabriciolfj.cadastropessoa.api.dto.request.PessoaResquestDTO;
import com.github.fabriciolfj.cadastropessoa.api.dto.response.PessoaResponseDTO;
import com.github.fabriciolfj.cadastropessoa.domain.service.PessoaService;
import com.github.fabriciolfj.cadastropessoa.wiremock.MockLogradouro;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.fabriciolfj.cadastropessoa.template.loader.PessoaRequestDTOLoader.PESSOA_REQUEST_VALIDA;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@DisplayName("Cenários para testar os processos da entidade pessoa")
public class PessoaServiceTest extends CadastroPessoaApplicationTests {

    private final PessoaService pessoaService;

    @Test
    @DisplayName("Criando uma pessoa")
    public void testWhenPeronCreated() throws JSONException {
        final PessoaResquestDTO request = Fixture.from(PessoaResquestDTO.class)
                .gimme(PESSOA_REQUEST_VALIDA);

        MockLogradouro.getLogradouro("14150-000");
        final PessoaResponseDTO response = pessoaService.create(request);

        assertTrue(response.getLogradouros().size() > 0);
        assertTrue(response.getNome() != null);
    }
}
