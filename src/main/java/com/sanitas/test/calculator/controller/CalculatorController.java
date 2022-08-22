package com.sanitas.test.calculator.controller;

import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CalculatorController {

    ResponseEntity<OperationResponse> operate(@RequestBody OperationRequest operationRequest);
}
