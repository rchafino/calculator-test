package com.sanitas.test.calculator.service;

import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;

public interface CalculatorService {

    OperationResponse operateRequest(OperationRequest operationRequest);
}
