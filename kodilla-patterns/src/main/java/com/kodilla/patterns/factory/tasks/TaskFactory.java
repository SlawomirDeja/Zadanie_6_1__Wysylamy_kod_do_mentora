package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final Task makeTask(String taskName, String whatToBuy, double quantity) {

        return new ShoppingTask(taskName, whatToBuy, quantity);

    }

    public final Task makeTask(String taskClass, String taskName, String string1, String string2) {

        return switch (taskClass) {

            case "PAINTING_TASK" -> new PaintingTask(taskName, string1, string2);
            case "DRIVING_TASK" -> new DrivingTask(taskName, string1, string2);
            default -> null;
        };

    }
}
