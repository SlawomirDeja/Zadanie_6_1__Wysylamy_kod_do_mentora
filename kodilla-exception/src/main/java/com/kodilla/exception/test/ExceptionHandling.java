package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handle(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("An exception occurred " + e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
