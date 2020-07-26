package com.github.fabriciolfj.cadastropessoa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class CadastroPessoaApplicationTests {

	@Test
	void contextLoads() {
	}

}
