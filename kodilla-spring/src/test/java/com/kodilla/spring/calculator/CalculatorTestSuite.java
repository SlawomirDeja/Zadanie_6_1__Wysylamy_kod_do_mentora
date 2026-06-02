package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        //Then
        assertEquals(5, calculator.add(2,3));
        assertEquals(1, calculator.sub(3,2));
        assertEquals(30, calculator.mul(5,6));
        assertEquals(4, calculator.div(8,2));
    }
}
