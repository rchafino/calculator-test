package com.sanitas.test.calculator.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AddServiceImpl.class)
public class AddServiceTest {

    @Autowired
    AddServiceImpl addService;

    @Test
    void operate_whenFilledList_thenReturnResult(){
        List<Double> numbers= Arrays.asList(10.0,15.0);
        double result = addService.operate(numbers);

        assertThat(result).isEqualTo(25.0);
    }

    @Test
    void operate_whenEmptyList_thenReturnZero(){
        List<Double> numbers= Collections.emptyList();
        double result = addService.operate(numbers);

        assertThat(result).isZero();
    }
}
