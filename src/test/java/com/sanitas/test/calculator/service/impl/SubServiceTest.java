package com.sanitas.test.calculator.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SubServiceImpl.class)
public class SubServiceTest {

    @Autowired
    SubServiceImpl subService;

    @Test
    void operate_whenFilledList_thenReturnResult(){
        List<Double> numbers= Arrays.asList(15.0,10.0);
        double result = subService.operate(numbers);

        assertThat(result).isEqualTo(5.0);
    }

    @Test
    void operate_whenEmptyList_thenReturnZero(){
        List<Double> numbers= Collections.emptyList();
        double result = subService.operate(numbers);

        assertThat(result).isZero();
    }
}
