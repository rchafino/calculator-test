package com.sanitas.test.calculator.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {

    double operate(List<Double> numbers);
}
