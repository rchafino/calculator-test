package com.sanitas.test.calculator.service.impl;

import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import com.sanitas.test.calculator.enums.OperatorEnum;
import com.sanitas.test.calculator.service.CalculatorService;
import com.sanitas.test.calculator.service.OperationService;
import com.sanitas.test.calculator.service.OperationServiceFactory;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private OperationServiceFactory operationServiceFactory;

    private TracerImpl tracerImpl;

    public CalculatorServiceImpl(OperationServiceFactory operationServiceFactory){
        this.operationServiceFactory = operationServiceFactory;
        this.tracerImpl = new TracerImpl();
    }

    @Override
    public OperationResponse operateRequest(OperationRequest operationRequest) {
        OperatorEnum operator = OperatorEnum.valueOf(operationRequest.getOperator().toUpperCase());
        List<Double> numbers = operationRequest.getNumbers();

        OperationService operationService = operationServiceFactory.getOperationService(operator);

        double operationResult = operationService.operate(numbers);

        tracerImpl.trace(operationResult);

        return OperationResponse.builder()
                .operationResult(operationResult)
                .build();
    }
}
