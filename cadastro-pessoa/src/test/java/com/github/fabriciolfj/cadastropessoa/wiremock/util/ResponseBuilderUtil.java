package com.github.fabriciolfj.cadastropessoa.wiremock.util;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.Json;
import lombok.experimental.UtilityClass;
import org.json.JSONObject;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@UtilityClass
public class ResponseBuilderUtil {

    public static ResponseDefinitionBuilder createAResponse(
            final Object responseBody, final Integer httpStatus, final Map<String, String> headers) {

        final ResponseDefinitionBuilder responseDefinitionBuilder = aResponse()
                .withHeader("Content-Type", "application/json");

        if (headers != null) {
            headers.forEach(responseDefinitionBuilder::withHeader);
        }

        if (responseBody != null && responseBody instanceof JSONObject) {
            responseDefinitionBuilder.withBody(responseBody.toString());
        } else {
            responseDefinitionBuilder.withBody(Json.write(responseBody));
        }

        if (httpStatus != null) {
            responseDefinitionBuilder.withStatus(httpStatus);
        }

        return responseDefinitionBuilder;
    }

    public static ResponseDefinitionBuilder createAResponse(final Integer httpStatus) {
        return createAResponse(null, httpStatus, null);
    }

    public static ResponseDefinitionBuilder createAResponse(final Object responseBody) {
        return createAResponse(responseBody, null, null);
    }

    public static ResponseDefinitionBuilder createAResponse(final Object responseBody, final Integer httpStatus) {
        return createAResponse(responseBody, httpStatus, null);
    }

    public static ResponseDefinitionBuilder createAResponse(final Object responseBody,
                                                            final Map<String, String> headers) {
        return createAResponse(responseBody, null, headers);
    }

    public static ResponseDefinitionBuilder createAResponse(final Integer httpStatus,
                                                            final Map<String, String> headers) {
        return createAResponse(null, httpStatus, headers);
    }
}