package com.sanitas.test.calculator.dto.validator;

import com.sanitas.test.calculator.dto.constraint.OperatorAllowedValues;
import com.sanitas.test.calculator.enums.OperatorEnum;
import org.apache.commons.lang3.EnumUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OperatorAllowedValuesValidator implements ConstraintValidator<OperatorAllowedValues, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return Objects.nonNull(value) && (EnumUtils.isValidEnum(OperatorEnum.class, value) || EnumUtils.isValidEnum(OperatorEnum.class, value.toUpperCase()));
    }

}
