package com.sanitas.test.calculator.controller;

import com.sanitas.test.calculator.config.RestProperties;
import com.sanitas.test.calculator.dto.OperationRequest;
import com.sanitas.test.calculator.dto.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CalculatorController {


    @Operation(summary = "calculate the result of the arithmetic operation with the given numbers")
    @PostMapping(path = "/calculation")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "operation_request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestProperties.BAD_REQUEST_CODE, description = RestProperties.BAD_REQUEST_DESC),
            @ApiResponse(responseCode = RestProperties.OK_REQUEST_CODE, description = RestProperties.OK_REQUEST_DESC),
            @ApiResponse(responseCode = RestProperties.SERVER_ERROR_CODE, description = RestProperties.SERVER_ERROR_DESC),
    })
    ResponseEntity<OperationResponse> operate(@RequestBody @Valid OperationRequest operationRequest);
}