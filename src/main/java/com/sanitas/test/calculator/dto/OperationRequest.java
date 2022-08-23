package com.sanitas.test.calculator.dto;

import com.sanitas.test.calculator.dto.constraint.OperatorAllowedValues;
import com.sanitas.test.calculator.enums.OperatorEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Schema(name ="operation_request")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest implements Serializable {

    @Schema(name ="operator", example = "ADD",allowableValues ="ADD,SUB" ,description = "The requested arithmetic operator.")
    @OperatorAllowedValues(anyOf = {OperatorEnum.ADD, OperatorEnum.SUB})
    private String operator;

    @Schema(name ="numbers", example = "[20,4]", description = "Array of numbers.")
    @NotEmpty(message = "Array may not be empty or null")
    private List<Double> numbers;
}
