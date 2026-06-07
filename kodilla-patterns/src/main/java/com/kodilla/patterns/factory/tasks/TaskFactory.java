package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String taskClass) {

        return switch (taskClass) {
            case SHOPPING_TASK -> new ShoppingTask("taskName1", "whatToBuy1", 5);
            case PAINTING_TASK -> new PaintingTask("taskName2", "color1", "whatToPaint1");
            case DRIVING_TASK -> new DrivingTask("taskName3", "where1", "bus");
            default -> null;
        };
    }
}
