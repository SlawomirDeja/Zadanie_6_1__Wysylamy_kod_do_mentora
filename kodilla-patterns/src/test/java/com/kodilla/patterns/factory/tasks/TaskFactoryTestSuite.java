package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        //Then
        assertFalse(shoppingTask.isTaskExecuted());
        assertEquals("taskName1", shoppingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();
        //Then
        assertTrue(paintingTask.isTaskExecuted());
        assertEquals("taskName2", paintingTask.getTaskName());
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        //Then
        assertFalse(drivingTask.isTaskExecuted());
        assertEquals("taskName3", drivingTask.getTaskName());
    }
}
