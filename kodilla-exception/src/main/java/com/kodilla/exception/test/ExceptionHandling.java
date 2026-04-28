package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handle(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
