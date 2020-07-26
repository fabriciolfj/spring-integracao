package com.github.fabriciolfj.cadastropessoa.wiremock;

import com.github.fabriciolfj.cadastropessoa.wiremock.util.ResponseBuilderUtil;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.apache.http.HttpStatus.SC_OK;

@UtilityClass
public class MockLogradouro {

    private static final String GET_LOGRADOURO = "/logradouros/%s";

    public void getLogradouro(@NonNull final String cep)  throws JSONException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        final var json = new JSONObject();
        json.put("cep", "14150-000");
        json.put("code", UUID.randomUUID().toString());

        stubFor(
                get(String.format(GET_LOGRADOURO, cep))
                .willReturn(ResponseBuilderUtil.createAResponse(json, SC_OK, headers))
        );
    }
}
