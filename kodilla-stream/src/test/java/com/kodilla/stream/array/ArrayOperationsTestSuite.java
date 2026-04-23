package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int numbers[] = new int[20];
        numbers[0] = 4;
        numbers[1] = 6;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 3;
        numbers[5] = 5;
        numbers[6] = 5;
        numbers[7] = 5;
        numbers[8] = 5;
        numbers[9] = 5;
        numbers[10] = 5;
        numbers[11] = 5;
        numbers[12] = 5;
        numbers[13] = 5;
        numbers[14] = 5;
        numbers[15] = 5;
        numbers[16] = 5;
        numbers[17] = 5;
        numbers[18] = 5;
        numbers[19] = 5;
        //When
        //Then
        assertEquals(5, ArrayOperations.getAverage(numbers));
    }
}
