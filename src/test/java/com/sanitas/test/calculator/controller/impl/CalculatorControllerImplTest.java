package com.sanitas.test.calculator.controller.impl;

import com.sanitas.test.calculator.CalculatorTestApplication;
import com.sanitas.test.calculator.config.RestProperties;
import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import com.sanitas.test.calculator.enums.OperatorEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@SpringBootTest(classes ={CalculatorTestApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerImplTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

   /* @MockBean
    private GreetingService service;*/

    @Test
    void operate() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+ RestProperties.BASE_PATH;
        URI uri = new URI(baseUrl.concat("/calculation"));

        OperationRequest operationRequest = OperationRequest.builder()
                .operator(OperatorEnum.ADD.toString())
                .numbers(Arrays.asList(10.0,5.0,20.0))
                .build();

        HttpEntity<OperationRequest> request = new HttpEntity<>(operationRequest, null);

        ResponseEntity<OperationResponse> result = this.restTemplate.postForEntity(uri, request, OperationResponse.class);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getBody()).isNotNull();
        Assertions.assertThat(result.getBody().getOperationResult()).isEqualTo(35.0);
    }
}
