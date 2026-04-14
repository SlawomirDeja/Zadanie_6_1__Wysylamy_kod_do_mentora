package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Adding and removing figures")
    class FirstGroupOfTests {

        @DisplayName("When we add a figure to the collection using the addFigure method, " +
                     "the number of figures in the collection should increase by 1.")
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Square("square_name_1", 21.212121F));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesQuantity());
        }

        @DisplayName("When we remove the last figure from the collection using the removeFigure method, " +
                     "this method should return true and the number of figures in the collection should be 0.")
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle_name_1", 22.222222F);
            shapeCollector.addFigure(circle);
            //When
            boolean result = shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("Retrieving and displaying figures")
    class SecondGroupOfTests {

        @DisplayName("When we retrieve a figure with index n from a collection, it should be the same " +
                     "figure stored in that collection at position number n.")
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle_name_1", 23.232323F);
            shapeCollector.addFigure(triangle);
            //When
            Shape retrievedFigure = shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals(triangle, retrievedFigure);
        }

        @DisplayName("The showFigures method should return the names of all figures in the collection " +
                     "separated by a space as one string.")
        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Square("square_name_5", 33.333333F));
            shapeCollector.addFigure(new Circle("circle_name_5", 34.343434F));
            shapeCollector.addFigure(new Circle("circle_name_6", 36.363636F));
            shapeCollector.addFigure(new Triangle("triangle_name_8", 38.383838F));
            //Then
            Assertions.assertEquals("square_name_5 circle_name_5 circle_name_6 triangle_name_8",
                                    shapeCollector.showFigures());
        }
    }
}
