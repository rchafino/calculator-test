package com.sanitas.test.calculator.dto;

import com.sanitas.test.calculator.enums.OperatorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {

    private OperatorEnum operator;

    private List<Double> numbers;
}
