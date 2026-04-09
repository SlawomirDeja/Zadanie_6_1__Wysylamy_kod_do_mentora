package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("Reached end of test number " + testCounter);
    }

    @DisplayName("When we pass an empty list of numbers as an argument to the " +
                 "OddNumbersExterminator.exterminate() method, " +
                 "the method should also return an empty list of numbers.")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResult = new ArrayList<>();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(new ArrayList<>());
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("When we pass a list of even and odd numbers as an argument to the " +
                 "OddNumbersExterminator.exterminate() method, " +
                 "the method should return a list of even numbers from the input list.")

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(4);
        expectedResult.add(8);
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(4);
        inputList.add(5);
        inputList.add(7);
        inputList.add(8);
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(inputList);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

}
