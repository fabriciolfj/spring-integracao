package com.github.fabriciolfj.cadastropessoa.template.loader;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.fabriciolfj.cadastropessoa.api.dto.request.PessoaResquestDTO;

public class PessoaRequestDTOLoader implements TemplateLoader {

    public static final String PESSOA_REQUEST_VALIDA = "requisicaoValida";
    @Override
    public void load() {
        Fixture.of(PessoaResquestDTO.class).addTemplate(PESSOA_REQUEST_VALIDA, new Rule() {
            {
                add("cep", "14150-000");
                add("nome", "teste teste");
            }
        });

    }
}
