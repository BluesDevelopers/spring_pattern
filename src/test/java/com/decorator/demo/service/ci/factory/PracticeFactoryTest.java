package com.decorator.demo.service.ci.factory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.decorator.demo.enumeration.EnumUser;
import com.decorator.demo.service.IPracticesService;

public class PracticeFactoryTest {

    @Mock
    private IPracticesService ciCompanyDecoratorService;

    @Mock
    private IPracticesService ciIntermDecoratorService;

    @Mock
    private IPracticesService ciRegDecoratorService;

    @InjectMocks
    private PracticeFactory practiceFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        practiceFactory = new PracticeFactory(ciCompanyDecoratorService, ciIntermDecoratorService, ciRegDecoratorService);
    }

    @Test
    public void testGetServiceCompany() {
        IPracticesService result = practiceFactory.getService(EnumUser.COMPANY);
        assertEquals(ciCompanyDecoratorService, result);
    }

    @Test
    public void testGetServiceIntermediary() {
        IPracticesService result = practiceFactory.getService(EnumUser.INTERMEDIARY);
        assertEquals(ciIntermDecoratorService, result);
    }

    @Test
    public void testGetServiceRegional() {
        IPracticesService result = practiceFactory.getService(EnumUser.REGIONAL);
        assertEquals(ciRegDecoratorService, result);
    }

    @Test
    public void testGetServiceInvalidUser() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            practiceFactory.getService(null);
        });
        assertEquals("User cannot be null", exception.getMessage());
    }
}

