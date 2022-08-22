package com.sanitas.test.calculator.service.impl;

import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import com.sanitas.test.calculator.enums.OperatorEnum;
import com.sanitas.test.calculator.service.CalculatorService;
import com.sanitas.test.calculator.service.OperationService;
import com.sanitas.test.calculator.service.OperationServiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private OperationServiceFactory operationServiceFactory;

    public CalculatorServiceImpl(OperationServiceFactory operationServiceFactory){
        this.operationServiceFactory = operationServiceFactory;
    }

    @Override
    public OperationResponse operateRequest(OperationRequest operationRequest) {

        OperatorEnum operator = operationRequest.getOperator();

        //validar operator valido

        List<Double> numbers = operationRequest.getNumbers();

        OperationService operationService = operationServiceFactory.getOperationService(operator);

        return OperationResponse.builder()
                .operationResult(operationService.operate(numbers))
                .build();
    }
}
