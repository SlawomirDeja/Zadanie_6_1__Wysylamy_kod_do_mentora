package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask("taskName1", "whatToBuy1", 5);
        //Then
        assertFalse(shoppingTask.isTaskExecuted());
        assertEquals("taskName1", shoppingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask("PAINTING_TASK", "taskName2",
                                                            "color1", "whatToPaint1");
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
        Task drivingTask = factory.makeTask("DRIVING_TASK", "taskName3",
                                                                   "where1", "bus");
        //Then
        assertFalse(drivingTask.isTaskExecuted());
        assertEquals("taskName3", drivingTask.getTaskName());
    }
}
