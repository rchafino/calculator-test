package com.sanitas.test.calculator.service.impl;

import com.sanitas.test.calculator.service.OperationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("subService")
public class SubServiceImpl implements OperationService {

    @Override
    public double operate(List<Double> numbers) {
        return numbers.stream()
                .reduce((acumulador, numero) -> {
                    return acumulador - numero;
                })
                .orElse(0.0);
    }
}
