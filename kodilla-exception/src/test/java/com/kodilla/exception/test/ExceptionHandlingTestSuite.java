package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When
        //Then
        assertAll(
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 2)),
            () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 2)),
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 2)),
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 2)),
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5))
        );

    }
}
