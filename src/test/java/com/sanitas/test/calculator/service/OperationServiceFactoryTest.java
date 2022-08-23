package com.sanitas.test.calculator.service;

import com.sanitas.test.calculator.enums.OperatorEnum;
import com.sanitas.test.calculator.service.impl.AddServiceImpl;
import com.sanitas.test.calculator.service.impl.SubServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OperationServiceFactoryTest {

    @InjectMocks
    private OperationServiceFactory operationServiceFactory;

    @Mock(name = "addService")
    private AddServiceImpl addService;

    @Mock(name = "subService")
    private SubServiceImpl subService;

    @Test
    void getAddServiceOK(){
        OperationService operationService = operationServiceFactory.getOperationService(OperatorEnum.ADD);
        assertThat(operationService).isInstanceOf(AddServiceImpl.class);
    }

    @Test
    void getSubServiceOK(){
        OperationService operationService = operationServiceFactory.getOperationService(OperatorEnum.SUB);
        assertThat(operationService).isInstanceOf(SubServiceImpl.class);
    }
}
