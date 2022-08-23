package com.sanitas.test.calculator.dto.constraint;

import com.sanitas.test.calculator.dto.validator.OperatorAllowedValuesValidator;
import com.sanitas.test.calculator.enums.OperatorEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OperatorAllowedValuesValidator.class)
public @interface OperatorAllowedValues {
    OperatorEnum[] anyOf();
    String message() default "must be any of {anyOf}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
