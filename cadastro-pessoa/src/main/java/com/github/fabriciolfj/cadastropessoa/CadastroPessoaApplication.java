package com.github.fabriciolfj.cadastropessoa;

import com.github.fabriciolfj.cadastropessoa.domain.integracao.request.LogradouroClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackageClasses = LogradouroClient.class)
@SpringBootApplication
public class CadastroPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoaApplication.class, args);
	}

}
