package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if (calculator.add(9,7) == 16) System.out.println("Addition test OK");
        else System.out.println("Addition error");

        if (calculator.subtract(9,7) == 2) System.out.println("Subtraction test OK");
        else System.out.println("Subtraction error");
    }
}
