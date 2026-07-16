package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        Board board = context.getBean(Board.class);

        String task3 = "task3";
        String task9 = "task9";
        String task7 = "task7";

        board.getToDoList().getTasks().add(task3);
        board.getInProgressList().getTasks().add(task9);
        board.getDoneList().getTasks().add(task7);

        //When & Then
        assertEquals(task3, board.getToDoList().getTasks().get(0));
        assertEquals(task9, board.getInProgressList().getTasks().get(0));
        assertEquals(task7, board.getDoneList().getTasks().get(0));

        ((ConfigurableApplicationContext) context).close();
    }
}
