package com.sanitas.test.calculator.dto.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = OperatorAllowedValuesValidator.class)
public class OperatorAllowedValuesValidatorTest {

    @Autowired
    OperatorAllowedValuesValidator validator;

    @ParameterizedTest
    @MethodSource("isValidArgs")
    void isValidTest(String value, boolean expected){
        boolean result = validator.isValid(value,null);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> isValidArgs() {
        return Stream.of(
                Arguments.of(null,false),
                Arguments.of("", false),
                Arguments.of(" ", false),
                Arguments.of("notvalid", false),
                Arguments.of("ADD", true),
                Arguments.of("add", true),
                Arguments.of("SUB", true),
                Arguments.of("sub", true)

        );
    }
}
