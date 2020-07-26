package com.github.fabriciolfj.cadastropessoa;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class CadastroPessoaApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeAll
	public static void beforeAll() {
		RestAssured.with().contentType(ContentType.JSON);
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		FixtureFactoryLoader.loadTemplates("com.github.fabriciolfj.cadastropessoa.template.loader");
	}

	@BeforeEach
	public void beforeEach() {
		RestAssured.port = port;
	}

}
