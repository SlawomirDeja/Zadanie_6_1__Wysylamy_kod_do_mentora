package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionHandlingTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 2));
    }
}
