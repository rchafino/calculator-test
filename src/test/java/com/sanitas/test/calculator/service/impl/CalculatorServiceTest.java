package com.sanitas.test.calculator.service.impl;

import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import com.sanitas.test.calculator.enums.OperatorEnum;
import com.sanitas.test.calculator.service.OperationService;
import com.sanitas.test.calculator.service.OperationServiceFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
@SpringBootTest("CalculatorServiceImpl.class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorServiceTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Mock
    private OperationServiceFactory operationServiceFactory;

    @Mock
    private OperationService operationService;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void operateRequest_whenRequestOk_thenReturnResponse() {
        OperationRequest operationRequest = OperationRequest.builder()
                .operator(OperatorEnum.ADD.toString())
                .numbers(Arrays.asList(10.0, 8.0))
                .build();

        when(operationServiceFactory.getOperationService(OperatorEnum.ADD)).thenReturn(operationService);
        when(operationService.operate(operationRequest.getNumbers())).thenReturn(18.0);

        OperationResponse response = calculatorService.operateRequest(operationRequest);

        assertThat(response).isNotNull();
        assertThat(response.getOperationResult()).isEqualTo(18.0);

        assertThat(outContent.toString().trim()).isEqualTo("result :: 18.0");
    }
}
