package com.home.sabir.spring.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BusinessServicesMockTest {

    @Mock
    StudentDataService dataServiceMock;

    @InjectMocks
    StudentBusinessService businessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24, 15, 3});
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_NoValues() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}