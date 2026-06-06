package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("entry1");
        //When
        //Then
        assertEquals("entry1", logger.getLastLog());
    }
}
