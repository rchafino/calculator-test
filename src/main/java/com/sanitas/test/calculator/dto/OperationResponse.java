package com.sanitas.test.calculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Schema(name ="operation_response")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse implements Serializable {

    @Schema(name ="operation_result", description = "The result of the arithmetic operation.")
    private double operationResult;
}
