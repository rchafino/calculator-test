package com.sanitas.test.calculator.service;

import com.sanitas.test.calculator.enums.OperatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceFactory {

    @Autowired
    @Qualifier("addService")
    private OperationService addService;

    @Autowired
    @Qualifier("subService")
    private OperationService subService;

    public OperationService getOperationService(OperatorEnum operatorEnum) {
        switch (operatorEnum) {
            case ADD:
                return addService;
            case SUB:
                return subService;
            default:
                return addService;
        }
    }
}
