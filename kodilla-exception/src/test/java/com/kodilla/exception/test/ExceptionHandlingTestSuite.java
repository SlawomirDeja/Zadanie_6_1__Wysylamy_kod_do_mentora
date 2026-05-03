package com.kodilla.exception.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTestSuite {

    private static SecondChallenge secondChallenge;

    @BeforeAll
    static void constructSecondChallenge() {
        secondChallenge = new SecondChallenge();
    }

    @Test
    void testNo1ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 2));
    }

    @Test
    void testNo2ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 2));
    }

    @Test
    void testNo3ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 2));
    }

    @Test
    void testNo4ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 2));
    }

    @Test
    void testNo5ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(4, 2));
    }

    @Test
    void testNo6ProbablyIWillThrowException() {
        //Given
        //When
        //Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5));
    }

}
