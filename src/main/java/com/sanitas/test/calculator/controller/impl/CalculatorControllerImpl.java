package com.sanitas.test.calculator.controller.impl;

import com.sanitas.test.calculator.config.RestProperties;
import com.sanitas.test.calculator.controller.CalculatorController;
import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import com.sanitas.test.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= RestProperties.BASE_PATH , produces=RestProperties.DATA_TYPE)
public class CalculatorControllerImpl implements CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorControllerImpl(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @Override
    @PostMapping(path = "/calculation")
    public ResponseEntity<OperationResponse> operate(OperationRequest operationRequest) {
        return new ResponseEntity<>(calculatorService.operateRequest(operationRequest), HttpStatus.ACCEPTED);
    }

}
