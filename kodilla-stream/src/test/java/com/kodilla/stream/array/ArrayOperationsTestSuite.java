package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int numbers[] = new int[5];
        numbers[0] = 4;
        numbers[1] = 6;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 3;
        //When
        //Then
        assertEquals(5, ArrayOperations.getAverage(numbers));
    }
}
