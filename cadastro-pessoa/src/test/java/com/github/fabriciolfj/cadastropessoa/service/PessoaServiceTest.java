package com.github.fabriciolfj.cadastropessoa.service;

import br.com.six2six.fixturefactory.Fixture;
import com.github.fabriciolfj.cadastropessoa.CadastroPessoaApplicationTests;
import com.github.fabriciolfj.cadastropessoa.api.dto.request.PessoaResquestDTO;
import com.github.fabriciolfj.cadastropessoa.api.dto.response.PessoaResponseDTO;
import com.github.fabriciolfj.cadastropessoa.domain.service.PessoaService;
import com.github.fabriciolfj.cadastropessoa.wiremock.MockLogradouro;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import wiremock.org.apache.http.HttpStatus;
import wiremock.org.hamcrest.CoreMatchers;

import static com.github.fabriciolfj.cadastropessoa.template.loader.PessoaRequestDTOLoader.PESSOA_REQUEST_VALIDA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@DisplayName("Cenários para testar os processos da entidade pessoa")
public class PessoaServiceTest extends CadastroPessoaApplicationTests {

    private final PessoaService pessoaService;
    private static final String URL = "/pessoas";

    @Test
    @DisplayName("Criando uma pessoa")
    public void testWhenPersonCreated() throws JSONException {
        final PessoaResquestDTO request = Fixture.from(PessoaResquestDTO.class)
                .gimme(PESSOA_REQUEST_VALIDA);

        MockLogradouro.getLogradouro("14150-000");
        final PessoaResponseDTO response = pessoaService.create(request);

        assertTrue(response.getLogradouros().size() > 0);
        assertTrue(response.getNome() != null);
    }

    @Test
    @DisplayName("Teste controller")
    public void testWenApi() throws JSONException {
        final PessoaResquestDTO request = Fixture.from(PessoaResquestDTO.class)
                .gimme(PESSOA_REQUEST_VALIDA);

        MockLogradouro.getLogradouro("14150-000");

        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .post(URL)
                .then()
                //Assert
                .statusCode(HttpStatus.SC_CREATED)
                .body(notNullValue())
                .body("nome", is("teste teste"))
                .body("logradouros", notNullValue());
    }
}
